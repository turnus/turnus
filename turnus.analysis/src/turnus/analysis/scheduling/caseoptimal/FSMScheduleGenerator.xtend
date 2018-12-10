package turnus.analysis.scheduling.caseoptimal

import com.google.common.collect.LinkedHashMultimap
import java.util.Arrays
import java.util.LinkedHashMap
import java.util.LinkedHashSet
import java.util.Map
import org.apache.poi.ss.formula.eval.NotImplementedException
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import turnus.analysis.scheduling.caseoptimal.ktail.BranchCondition
import turnus.analysis.scheduling.caseoptimal.ktail.InferenceState
import turnus.analysis.scheduling.caseoptimal.ktail.KTailConditionFuser
import turnus.analysis.scheduling.caseoptimal.ktail.MultiCondition
import turnus.analysis.scheduling.caseoptimal.ktail.Prefix
import turnus.analysis.scheduling.caseoptimal.ktail.TraceReconstructor
import turnus.analysis.scheduling.caseoptimal.ktail.Transition
import turnus.common.io.Logger
import turnus.model.analysis.scheduling.ActorFire
import turnus.model.analysis.scheduling.FSM
import turnus.model.analysis.scheduling.FSMCombinator
import turnus.model.analysis.scheduling.FSMOp
import turnus.model.analysis.scheduling.impl.SchedulingFactoryImpl

@Data class ScheduleInferenceState{
	String enumName;
	LinkedHashSet<ScheduleInfereceTransition> transitions;
}
@Data class ScheduleInfereceTransition{
	Integer[] actions;
	MultiCondition cond;
	String sourceState;
	String targetState;
	LinkedHashMap<String,Integer> vars;
	def String toKey(){
		val key='''«sourceState»->«targetState»--«FOR a:actions»«a»«ENDFOR»''';
		//Logger.info(key);
		key
	}
	new(Integer[] actions,BranchCondition cond,String source, String target,Map<String,Integer> vars){
		this.actions=actions;
		this.cond=new MultiCondition(cond);
		this.sourceState=source;
		this.targetState=target;
		this.vars=new LinkedHashMap;
		for(e:vars.entrySet){
			this.vars.put(e.key,e.value);
		}
	}
	
	new(Integer[] actions,MultiCondition cond,String source, String target,Map<String,Integer> vars){
		this.actions=actions;
		this.cond=cond;
		this.sourceState=source;
		this.targetState=target;
		this.vars=new LinkedHashMap;
		for(e:vars.entrySet){
			this.vars.put(e.key,e.value);
		}
	}
}
class FSMScheduleGenerator {
	val schedfac=new SchedulingFactoryImpl;
	LinkedHashMultimap<InferenceState, Prefix> eqClasses;
	LinkedHashMap<Prefix, InferenceState> prefixes;
	Integer[] intActions;
	Integer k;
	final LinkedHashMap<Integer,ActorFire> id_to_actor;
	@Accessors LinkedHashMap<Prefix, InferenceState> transient_states = null;
	
	new(LinkedHashMultimap<InferenceState, Prefix> eqClasses, LinkedHashMap<Prefix, InferenceState> prefixes, Integer[] intActions,Integer k,LinkedHashMap<Integer,ActorFire> id_to_actor) {
	this.eqClasses=eqClasses;
	this.prefixes=prefixes;
	this.intActions=intActions;
	this.k=k;
	this.id_to_actor=id_to_actor;
	}

	def getFSMState(ScheduleInferenceState s,String stepVarName){
		var state =schedfac.createFSMState;
		state.enumName=s.enumName;
		state.varUpdates.add(getIncOp('''«s.enumName»_visits'''));
		state.varUpdates.add(getIncOp('''«stepVarName»'''));
		Logger.info('''Adding transitions to «s.enumName»''')
		for(t:s.transitions){
			Logger.info('''adding transition «t.toKey»''')
			val newT=getFSMTransition(t);
			state.transitions.add(newT);
		}
		return state;
	}
	
	def getCond(MultiCondition mc){
		var curCond=schedfac.createFSMCondition;
		val cond=curCond;
		var i=1;
		Logger.info('''Translating multicond «mc.toString»''')
		for(p:mc.partials){
			curCond.comp=p.comparator.toFSMComparator;
			curCond.compval=Integer.parseInt(p.value,10);
			curCond.valName=p.varname;
			Logger.info('''Added «p.varname»«curCond.comp»«curCond.compval»''')
			if(i<mc.partials.size){
				val combinedCond=schedfac.createFSMCombination;
				combinedCond.combinator=FSMCombinator.AND;
				combinedCond.cond=schedfac.createFSMCondition;
				curCond.combinedCond=combinedCond;
				curCond=combinedCond.cond;
			}
			i+=1;
		}
		cond
	}
	def getFSMTransition(ScheduleInfereceTransition t){
		var transcond=getCond(t.cond);
		
		var transition=schedfac.createFSMTransition;

		transition.cond = transcond;
		transition.sourceStateEnumName=t.sourceState;
		transition.targetStateEnumName=t.targetState;
		val seq=schedfac.createSequence;
		for(a:t.actions){
		val act=EcoreUtil.copy(id_to_actor.get(a));
		seq.actions.add(act);	
		}
		transition.transitionSchedule=seq;
		return transition;
	
	}
	def getScheduleInfereceTransition(String stateVar,Integer stateVarValue,Transition t,Map<String,Integer> varStates){
		val cond=new BranchCondition(stateVar,'''== «stateVarValue»''');
		new ScheduleInfereceTransition(t.actions,cond,stateName(t.sourceState),stateName(t.goalState),varStates)
	}
	
	def getFSMVar(String type,String name, String initialVal){
		var fsmvar=schedfac.createFSMVar;
		fsmvar.name=name;
		fsmvar.initialVal=initialVal
		fsmvar.type=type;
		return fsmvar;
	}
	
	
	def getDecOp(String stateVar){
		
		var dec_op = (new SchedulingFactoryImpl).createFSMOperation
		var decrementvar=(new SchedulingFactoryImpl).createFSMVarUpdate;
		dec_op.^var = stateVar;
		dec_op.^val = -1;
		dec_op.op = FSMOp.ADD;
		decrementvar.operation = dec_op;
		return decrementvar;
	}
		
	
	def InferenceState findPreviousState(Integer[] intActions,InferenceState cur_state, Prefix curPrefix){
		var LinkedHashSet<InferenceState> possiblePredecessors=new LinkedHashSet;
		for(t:cur_state.incomings){
			
			Logger.info("Checking whether transition %d->%d with actions \n %s\n valid transition to current prefix\n %s\n",
				t.sourceState.id,t.goalState.id,Arrays.toString(t.actions.toArray),curPrefix.toString
			);
			
			
				if(curPrefix.canSubtract(t)&&t.sourceState.prefixes.contains(curPrefix.subtract(t))){
					possiblePredecessors.add(t.sourceState)
				}
		}
		
		
			
		if(possiblePredecessors.size==1){
			return possiblePredecessors.last;
		}else if(possiblePredecessors.size >1){
			//TODO find a heuristic to choose...for now just take the last
			return possiblePredecessors.last;
		}else{
			if(transient_states!==null){
			for(e:transient_states.entrySet){
				for(t:e.value.outgoings){
					if(t.goalState.prefixes.contains(curPrefix) && t.connects(t.sourceState,cur_state)){
						Logger.info("Valid transition would have been from %d->%d, with actions %s",t.sourceState.id,t.goalState.id,Arrays.toString(t.actions.toArray));
					}
				}
			}
			}
			throw new NotImplementedException("No possible predecessors found, probable error in inference logic")
		}
	}
	def getIncOp(String stateVar){
	
		var dec_op = (new SchedulingFactoryImpl).createFSMOperation
		var incrementvar=(new SchedulingFactoryImpl).createFSMVarUpdate
		dec_op.^var = stateVar;
		dec_op.^val = 1;
		dec_op.op = FSMOp.ADD;
		incrementvar.operation = dec_op;
		return incrementvar	;
	}
	def ScheduleInferenceState getInferenceSchedState(String name,String stepVarName){
		new ScheduleInferenceState(name,new LinkedHashSet)
	}
	def static String stateName(InferenceState state){
		'''state_«state.id»'''
	}
	
	def public FSM getSchedule(){
		var vars=new LinkedHashMap;
		val stepVar="stepVar";
		vars.put(stepVar,0);
		val fullPrefix = new Prefix(intActions,intActions.size,k);
		val TraceReconstructor tracerec=new TraceReconstructor(eqClasses,prefixes,fullPrefix);
		val transition_order=tracerec.depth_first();
		var curState = tracerec.initial_state();
		val states=new LinkedHashMap;
		var initialState=getInferenceSchedState(stateName(curState),stepVar);
		vars.put('''«stateName(curState)»_visits''',0)
		states.put(curState,initialState);
		
		
		for(t:transition_order){
			val curfsmState=states.get(curState);
			val varKey='''«curfsmState.enumName»_visits''';
			if(!vars.containsKey(varKey)){
				vars.put(varKey,0);
			}
			
			vars.incrementKey(varKey);
			vars.incrementKey(stepVar);
						
			val nextState=t.goalState;
			if(!states.containsKey(nextState)){
				var newState=getInferenceSchedState(stateName(nextState),stepVar);
				states.put(nextState,newState);
				Logger.info("Mapped inference State %d to %s",nextState.id,newState.enumName);
			}
			
			var inf_transition=getScheduleInfereceTransition(stepVar,vars.get(stepVar),t,vars);
			
			curfsmState.transitions.add(inf_transition);
			Logger.info('''
			Added «inf_transition.toKey» to «curfsmState.enumName», now «curfsmState.transitions.size» tranitions''');
			curState=t.goalState;
		}
			
		//add a final transition to the "terminal" state
		vars.incrementKey(stepVar);
		vars.incrementKey('''«stateName(curState)»_visits''');
		val terminalInfState=new InferenceState(Integer.MAX_VALUE);
		val terminalState=getInferenceSchedState(stateName(terminalInfState),stepVar);
		val Integer[] none=newArrayOfSize(0);
		val terminal_tran =new Transition(curState,terminalInfState,none);
		terminalInfState.incomings.add(terminal_tran);
		curState.outgoings.add(terminal_tran);
		vars.put('''«stateName(terminalInfState)»_visits''',0);
		val inf_transition=getScheduleInfereceTransition(stepVar,vars.get(stepVar),terminal_tran,vars);
		states.get(curState).transitions.add(inf_transition);
		
		Logger.info('''Added «inf_transition.toKey» to «states.get(curState).enumName», now «states.get(curState).transitions.size» tranitions''');
		states.put(terminalInfState,terminalState);
		
		val schedfac=new SchedulingFactoryImpl();
		
		var fsm = schedfac.createFSM();
		fsm.startState = initialState.enumName;
		fsm.terminalState=terminalState.enumName;
				
		val conditionFuser= new KTailConditionFuser;
		conditionFuser.decisionTreeFuse(states,vars);
		for(e:states.entrySet){
			val s=e.value;
			val newstate=getFSMState(s,stepVar);
			fsm.states.add(newstate);
		}
		for(e:vars.entrySet){
		val fsmvar=getFSMVar("int",e.key,"0");
		fsm.vars.add(fsmvar);
		}
		fsm	
	}
	
	
	def incrementKey(LinkedHashMap<String, Integer> map, String key) {
			map.put(key,map.get(key)+1);
	}
	


}