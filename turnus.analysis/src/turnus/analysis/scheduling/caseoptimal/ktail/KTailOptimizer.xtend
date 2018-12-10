package turnus.analysis.scheduling.caseoptimal.ktail

import com.google.common.collect.LinkedHashMultimap
import java.util.ArrayList
import java.util.HashMap
import java.util.LinkedHashMap
import java.util.List
import java.util.Map
import org.apache.poi.ss.formula.eval.NotImplementedException
import org.eclipse.emf.ecore.util.EcoreUtil
import turnus.analysis.scheduling.caseoptimal.FSMScheduleGenerator
import turnus.common.io.Logger
import turnus.common.io.ProgressPrinter
import turnus.model.analysis.scheduling.ActorFire
import turnus.model.analysis.scheduling.ActorSelectionSchedule
import turnus.model.analysis.scheduling.FSM
import turnus.model.analysis.scheduling.FSMCombinator
import turnus.model.analysis.scheduling.FSMTransition
import turnus.model.analysis.scheduling.Sequence
import turnus.model.analysis.scheduling.impl.SchedulingFactoryImpl

class KTailOptimizer implements Optimizer{
	LinkedHashMap<Prefix,InferenceState> prefixes;
	LinkedHashMap<ActorFire,Integer> actors_to_id;
	LinkedHashMap<Integer,ActorFire> id_to_actors;
	LinkedHashMultimap<InferenceState,Prefix> eqClasses;
	Integer[] intActions;
	final SchedulingFactoryImpl schedfac;
	final int k;
	KTails ktails;
	int nextClass;
	
	new(int k){
		this.k=k;
		this.actors_to_id=new LinkedHashMap;
		this.id_to_actors=new LinkedHashMap;
		this.prefixes=new LinkedHashMap;
		this.nextClass=0;
		this.eqClasses= LinkedHashMultimap.create();
		
		this.schedfac=new SchedulingFactoryImpl;
		
	}
	
	//implement prefix so that it always has pre and tail, equals first checks tail, then pre...avoids copying and concatenating arrays
	def boolean isEquivalent(Prefix p1, Prefix p2){
		ktails.reset();
		while(!ktails.done() ){
					val Integer[] tail=ktails.next;
					val p1star = new Prefix(p1,tail);
					val p2star = new Prefix(p2,tail);
					
					val p1Contained=prefixes.containsKey(p1star);
					val p2Contained=prefixes.containsKey(p2star);
					
					val both_contained=p1Contained && p2Contained;
					val both_not_contained=!p1Contained && !p2Contained;
					if(!(both_contained||both_not_contained)){
						return false;
					}
				}
		return true;
	}
	
	
	def genAlphabet(Iterable<ActorFire> actions){
		Logger.info("Generating integer actor ids as alphabet");
		//translate actors into integer id to speed up comparisons, also generates alphabet
		var next_id=0;
		var ind=0;
		intActions = newArrayOfSize(actions.size);
		for(a:actions){
			var inAlphabet=false;
			if(!actors_to_id.empty){
			for (ActorSelectionSchedule ac:actors_to_id.keySet){
				if(!inAlphabet && a.equals(ac)){
					inAlphabet=true;
				}
			}}
			if (!inAlphabet){
				actors_to_id.put(a,next_id);
				id_to_actors.put(next_id,a);
				next_id+=1;
			}
			intActions.set(ind,actors_to_id.get(a));
			ind+=1;
			
		}
		Logger.info("Generated alphabet of size %d",id_to_actors.size);
	}
	
	def findStates(){
		Logger.info("Generating equivalence classes, #prefixes: %d",prefixes.size);
		var progress=new ProgressPrinter("Classifying Prefixes: ",prefixes.size*prefixes.size);
		//generate equivalence classes
		for(i:0..<prefixes.size){
			val p1=prefixes.keySet.toArray.get(i) as Prefix;
			for(j:i..<prefixes.size){
				val p2=prefixes.keySet.toArray.get(j) as Prefix;
				val equivalent=isEquivalent(p1,p2);
				
				if (equivalent){
					val p1Class=prefixes.get(p1);
					val p2Class=prefixes.get(p2);
				if (p1Class !==null && p2Class!==null){
						if(p1Class!= p2Class){
						throw new NotImplementedException("Two equivalent states have different equivalence classes!=null, this should never happen")
						//else do nothing, it's fine
						}
				}else if(p1Class!==null && p2Class===null){
					prefixes.put(p2,p1Class);
				}else if(p1Class===null && p2Class!==null){
					prefixes.put(p1,p2Class);
				}else{
					val newState=new InferenceState(nextClass);
					prefixes.put(p1,newState);
					prefixes.put(p2,newState);
					nextClass+=1;
				}
				}
				ktails.reset;
				progress.increment;
				
			}
		}
		progress.finish();
		
		Logger.info("Grouping by states, assigning non-equivalent prefixes to singleton states");

		var altered=new HashMap<Prefix,InferenceState>;
		
		for(e:prefixes.entrySet){
			val prefix=e.key;
			val s= if(e.value===null){nextClass+=1;new InferenceState(nextClass-1)}else{e.value};
			eqClasses.put(s,prefix);
			if(e.value===null){
			altered.put(prefix,s);
			}
		}
		for(e:altered.entrySet){
			prefixes.put(e.key,e.value);
		}
		for(e:prefixes.entrySet){
			var s=e.value;
			s.prefixes.add(e.key);
		}
		//make the set of prefixes available from the inference states...HACK FIXME
		for(s:eqClasses.keySet){
		Logger.info("State %d with %d prefixes",s.id,s.prefixes.size);
		}
		Logger.info("Total #States: %d",eqClasses.keySet.size);
	}
	
		def genTransitions(){
		Logger.info("Generating transitions ");
		var numTrans=0;
		for(state:eqClasses.keySet){
			val ps=eqClasses.get(state);
			for (p:ps){
				for (a:id_to_actors.keySet){
					
					val  Integer[] a_arr=#[a];
					val next_prefix=new Prefix(p,a_arr);
					Logger.debug("Checking if prefix %s + token %d in known prefixes",p.toString,a);
					
					var next_state=prefixes.get(next_prefix);
					if(next_state!==null){
						
						Logger.debug("Prefix found, generating transistion from %d->%d, with action %d",state.id,next_state.id,a);
						val transition= new Transition(state,next_state,a);
						next_state.incomings.add(transition);//TODO: check if this does'nt invalidate the iterator...
						Logger.debug("State %d has new incoming transistion %d->%d, now %d incomings",next_state.id,transition.sourceState.id,transition.goalState.id,next_state.incomings.size);
						state.outgoings.add(transition);
						Logger.debug("State %d has new outgoing transistion %d->%d, now %d outgoings",state.id,transition.sourceState.id,transition.goalState.id,state.outgoings.size);
						
						numTrans+=1;
					}
				}
			}
		}
		Logger.info("Total #Transitions: %d",numTrans);
	}
	

	
	def checkStates(){
		for(state:eqClasses.keySet){
			Logger.info("State %d from eqClaseses has %d incomings and %d outgoings and %d prefixes",state.id,state.incomings.size, state.outgoings.size,state.prefixes.size);
		}
		for(state:prefixes.values.toSet){
			Logger.info("State %d from prefixes.valueset has %d incomings and %d outgoings and %d prefixes",state.id,state.incomings.size, state.outgoings.size,state.prefixes.size);
		}
	}

	

	def DEBUG_check_unrolledFSM(FSM fsm, List<ActorFire> actions){
		val varstates=new LinkedHashMap;
		val fsmstates=new LinkedHashMap;
		val unrolled_actions=new ArrayList<ActorSelectionSchedule>;
		for(v:fsm.vars){
			varstates.put(v.name,Integer.parseInt(v.initialVal,10));
		}
		for(s:fsm.states){
			fsmstates.put(s.enumName,s);
		}
		var curState=fsm.startState;
		
		var step=0;
		while(!curState.equals(fsm.terminalState)){
			val s=fsmstates.get(curState);
			Logger.info('''Got state «s.enumName» with transitions:
			«FOR t:s.transitions»
			«t.targetStateEnumName»
			«ENDFOR»
			and updates
			«FOR t:s.varUpdates»
			«t.operation.^var»«t.operation.op»«t.operation.^val»
			«ENDFOR»
			''')
			val transitionCand= new ArrayList;
			for(u:s.varUpdates){
				switch u.operation.op{
					case ADD:{varstates.addTo(u.operation.^var,u.operation.^val)}
					case SET:{varstates.put(u.operation.^var, u.operation.^val)}
				}
			}
			Logger.info('''Updated vars to «FOR v:varstates.entrySet»«v.key»:«v.value»«ENDFOR»''')
			for(t:s.transitions){
				if(t.ConditionsFullfilled(varstates)){
					transitionCand.add(t);
				}
			}
			if(transitionCand.size==1){
				val t=transitionCand.last;
				val sched=EcoreUtil.copy(t.transitionSchedule);
				switch sched{
					case sched instanceof  ActorFire:{unrolled_actions.add(sched)}
					case sched instanceof Sequence:{unrolled_actions.addAll((sched as Sequence).actions)}
				}
				curState=t.targetStateEnumName;
				Logger.info('''Found next state «curState»,,at step«step»''')
			}else if(transitionCand.size>0){
				Logger.error('''Have ambigous transitions from state «curState», have «transitionCand.size» candidates , at step«step»
				«FOR t:transitionCand»
				«t.toString»:Target«t.targetStateEnumName»,Schedule:«t.transitionSchedule»
				Conditions:«t.cond»
				«ENDFOR»''');
				throw new NotImplementedException('''Have ambigous transitions from state «curState», have «transitionCand.size» candidates , at step«step»
				«FOR t:transitionCand»
				«t.toString»:Target«t.targetStateEnumName»,Schedule:«t.transitionSchedule»
				Conditions:«t.cond»
				«ENDFOR»''')
			}else{
				val msg='''At state«curState»» No transition away, but also not in final state, at step«step»''';
				throw new NotImplementedException(msg);
			}
			step+=1;
		}
		var sameSchedule=actions.size==unrolled_actions.size;
		for(i:0..<actions.size){
			if(sameSchedule){
				if(!actions.get(i).equals(unrolled_actions.get(i))){
					sameSchedule=false;
							throw new KtailConditionFuseException('''Expected the FSM generated by ktails to unroll to the same actions as the original trace. Not the case, differs at step «i»''')
	
				}
			}
		}
	}
	
	def boolean ConditionsFullfilled(FSMTransition transition, Map<String,Integer> vars){
		var c=transition.cond;
		Logger.info('''Checking conditions in varstate:
		«FOR e:vars.entrySet»
		«e.key»:«e.value»
		«ENDFOR»
		''')
		while(c!==null){
			val v=c.compval;
			val cv=vars.get(c.valName);
			val next_c=if(c.combinedCond!==null){
				if(c.combinedCond.combinator.equals(FSMCombinator.AND)){
					c.combinedCond.cond
				}else{
					throw new NotImplementedException("Only support and chains");
				}
			}else{null};
			if(c.valName ===null || switch c.comp{
				case EQ:{cv==v}
				case GREQ:{cv>=v}
				case SMEQ:{cv<=v}
				case NEQ:{cv!=v}
				case GREATER:{cv>v}
				case SMALLER:{cv<v}
			}){
				Logger.info('''Condition «c.valName» «c.comp» «c.compval» fullfiled''')
				c=next_c
		
			}
			else{
				Logger.info('''Condition «c.valName» «c.comp» «c.compval» not fullfiled, exit''')
				return false
			};
		}
		Logger.info("All conditions fullfilled, transition can go")
		return true;
	}
	
	def addTo(LinkedHashMap<String, Integer> map, String string, Integer integer) {
		map.put(string,map.get(string)+integer);
	}

	override def ActorSelectionSchedule optimize(ActorSelectionSchedule input)  {
		val actions = switch input {
			case input instanceof Sequence: (input as Sequence).getActions(),
			default: return input // RLE only makes sense in sequences
		}
		genAlphabet(actions);
		
		Logger.info("Generating integer prefixes");
		//generate all prefixes
		prefixes = new LinkedHashMap();
		for( i:0..actions.size()){
			val intPrefix=new Prefix(intActions,i,k);
			prefixes.put(intPrefix,null);//not in an equivalance class at creation
		}
		
		//generate all k-tails
		val alpha=id_to_actors.keySet;
		Logger.info("Generating ktails for alphabet of size %d, k=%d",alpha.size,k);
		this.ktails = new KTails(k,alpha);
		Logger.info("#ktails: %d",Math.round(Math.pow(k,alpha.size)));
		
		
		findStates();
		
		genTransitions;
		
		var fsmSchedGen = new FSMScheduleGenerator(eqClasses,prefixes,intActions,k,id_to_actors);
		val stateFuser=new KTailStateFuser(eqClasses,prefixes);
		stateFuser.fuseStates();
		Logger.info("Generating Schedule in EMF Model");
		
		fsmSchedGen.transient_states=stateFuser.fsm.transientPrefixes;
		val fsm= fsmSchedGen.getSchedule();
		DEBUG_check_unrolledFSM(fsm,actions);

	
		return fsm;
	}
	
}