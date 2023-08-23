package turnus.analysis.scheduling.caseoptimal.ktail

import java.util.ArrayList
import java.util.HashSet
import java.util.LinkedHashMap
import turnus.analysis.scheduling.caseoptimal.ScheduleInferenceState
import turnus.common.io.Logger
import weka.core.Attribute
import weka.core.DenseInstance
import weka.core.Instances

class KtailConditionFuseException extends Exception {
	// Parameterless Constructor
	new() {
	}

	// Constructor that accepts a message
	new(String message) {
		super(message);
	}
}

class KTailConditionFuser {
	// provides methods for inferring more complex state variable based on fixed_value transitions
	def decisionTreeFuse(LinkedHashMap<InferenceState, ScheduleInferenceState> states,
		LinkedHashMap<String, Integer> vars) {

		var attInfo = new ArrayList;
		var stateVars = new LinkedHashMap
		for (v : vars.entrySet) {
			attInfo.add(new Attribute(v.key))
			stateVars.put(v.key, 0 as double);
		}

		val classNameSet = new HashSet;
		for (e : states.entrySet) {
			val inf_sched_s = e.value;
			for (t : inf_sched_s.transitions) {
				classNameSet.add(t.toKey);
			}
		}
		val classNameArr = new ArrayList;
		classNameArr.addAll(classNameSet);
		val stateNameNominal = new Attribute("transition", classNameArr);
		attInfo.add(stateNameNominal);
		val instance_cap = 10; // TODO check if this needs to be set fixed or it can grow
		for (e : states.entrySet) {
			val s = e.value;
			var Instances train = new Instances("transitions", attInfo, instance_cap)
			train.classIndex = attInfo.size - 1; // set the last attribute as class
			for (t : s.transitions) {

				var t_inst = new DenseInstance(attInfo.size);
				t_inst.dataset = train;
				var i = 0;
//			Logger.info('''
//			Adding transition instance in state «s.enumName»:
//			«t.toKey»
//			vars«FOR en:stateVars.entrySet SEPARATOR ','»«en.key»:«en.value»«ENDFOR»''')
				for (v : vars.keySet) {
					if (t.vars.get(v) === null) {
						t_inst.setValue(i, stateVars.get(v));
					} else {
						val newVal = t.vars.get(v);
						t_inst.setValue(i, newVal);
						stateVars.put(v, newVal as int as double);
					}
//			Logger.info('''«v» set to «vars.get(v)»''')
					i += 1;
				}
				t_inst.setValue(i, '''«t.toKey»''');
//			Logger.info('''Instance «t_inst.toString»''')
				train.add(t_inst);
			}
			var dtc = new KTailDecisionTreeClassifier();
			dtc.buildClassifier(train);
			try {
				val conditionTree = dtc.transitionConds;
//			Logger.info('''
//			«dtc.toString»
//			''');
//			Logger.info('''
//			BEFORE fusion «s.enumName» has the following transitions:
//			«FOR t:s.transitions»
//			«t.toKey» with conditoin «t.cond.toString»
//			«ENDFOR»
//			Decition tree is:
//			«dtc.graph»
//			''')
				Logger.info('''
				Decision Tree for state «s.enumName» is:
				«dtc.graph»''')
				conditionTree.fuseTransitions(s)
//			Logger.info('''
//			AFTER fusion «s.enumName» has the following transitions:
//			«FOR t:s.transitions»
//			«t.toKey» with conditoin «t.cond.toString»
//			«ENDFOR»
//			''');
			} catch (KtailFuseParseException ex) {
				Logger.error(ex.message);
				throw ex
			}
		}
	}
}
