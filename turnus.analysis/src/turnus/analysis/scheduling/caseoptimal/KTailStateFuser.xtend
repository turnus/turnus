package turnus.analysis.scheduling.caseoptimal

import turnus.common.io.Logger
import java.util.LinkedHashSet
import java.util.Iterator
import turnus.model.analysis.scheduling.Sequence
import turnus.model.analysis.scheduling.impl.SequenceImpl
import turnus.model.analysis.scheduling.impl.SchedulingFactoryImpl

import org.eclipse.xtend.lib.annotations.Accessors
import com.google.common.collect.LinkedHashMultimap
import java.util.LinkedHashMap
import java.util.ArrayList
import java.util.Arrays
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.HashSet
import org.apache.poi.ss.formula.eval.NotImplementedException

@Accessors class KTailStateFuser {
	@Accessors(PUBLIC_GETTER)  InferenceFSM fsm;
	new(LinkedHashMultimap<InferenceState, Prefix> eqClasses,LinkedHashMap<Prefix, InferenceState> prefixes) {
	this.fsm = new InferenceFSM(eqClasses,prefixes);
	}
	new(InferenceFSM fsm){
		this.fsm=fsm;
	}
	
	
		//removes a node which is the middle of a chain of 3 nodes, all connected with single edges
	def fuseOneToOne(InferenceState s,Iterator<InferenceState> it){
			var pred=s.incomings.last.sourceState;
			pred.outgoings.remove(s.incomings.last);
			var suc=s.outgoings.last.goalState;
			suc.incomings.remove(s.outgoings.last);
				val newTran = Transition.combine(s.incomings.last,s.outgoings.last);
				pred.outgoings.add(newTran);
				suc.incomings.add(newTran);
				
				Logger.info("Creating new transition from %d->%d with %d actions",pred.id,suc.id,newTran.actions.size);
				
				val connects=newTran.connects(pred,suc);
				Logger.info("New connections connects pred and suc:%b",connects);
				if(!connects){
					throw new NotImplementedException("This causes our search to fail");
				}
				Logger.info("Removing state %d, from deterministic chain %d->%d->%d",s.id,pred.id,s.id,suc.id);
				fsm.trimNode(it,s);
	}
	
	//removes a fanout node
	def fuseOneToMany(InferenceState s,Iterator<InferenceState> it){
		
			var debug_transitions_done=new HashSet;	
			var pred=s.incomings.last.sourceState;
			pred.outgoings.remove(s.incomings.last);
			var fanout=new ArrayList;
			for(t:s.outgoings){
				var suc=t.goalState;
				suc.incomings.remove(t);
				val newTran = Transition.combine(s.incomings.last,t);
				pred.outgoings.add(newTran);
				suc.incomings.add(newTran);	
				fanout.add(suc.id);
				
								debug_transitions_done.add(newTran);
				for(td: debug_transitions_done){
					Logger.info("Transition %d->%d has %d actions after adding %d->%d",td.sourceState.id,td.goalState.id,td.actions.size,t.sourceState.id,t.goalState.id);
				}
			}
	Logger.info("Removing state %d, from fanout chain %d->%d->%s",s.id,pred.id,s.id,Arrays.toString(fanout.toArray));
						
				fsm.trimNode(it,s);
				
	}

	def logDot(){
	
	val dot=fsm.toDot();
	
	Logger.info('''Current graph:
	
	«dot»''');

	}
		
	//removesa a fan in node
	def fuseManyToOne(InferenceState s, Iterator<InferenceState> it){
			var debug_transitions_done=new HashSet;	
			var suc=s.outgoings.last.goalState;
			suc.incomings.remove(s.outgoings.last);
			var fanin=new ArrayList;
			for(t:s.incomings){
				var pred=t.sourceState;
				pred.outgoings.remove(t);
				val newTran = Transition.combine(t,s.outgoings.last);
				pred.outgoings.add(newTran);
				suc.incomings.add(newTran);
				fanin.add(pred.id);
				Logger.info("Removing state %d, from fanin chain %s->%d->%d",s.id,Arrays.toString(fanin.toArray),s.id,suc.id);
				debug_transitions_done.add(newTran);
				for(td: debug_transitions_done){
					Logger.info("Transition %d->%d has %d actions after adding %d->%d",td.sourceState.id,td.goalState.id,td.actions.size,t.sourceState.id,t.goalState.id);
				}
			}
				
				fsm.trimNode(it,s);
	}

	
	def fuseStates(){
		var Prefix finalPrefix=null;
		for(p:fsm.reachablePrefixes.keySet){
			if(finalPrefix==null || p.full.combined_size>finalPrefix.full.combined_size){
				finalPrefix=p;
			}
		}
		
		var numTrans=0;
		for(s:fsm.states){
			numTrans+=s.outgoings.size;
		}
		Logger.info("Performing State Fusion, starting with %d states and %d transitions",fsm.states.size,numTrans)
		var updated=true;
		while(updated){
		var removed=new LinkedHashSet;
		updated=false;
		for(var Iterator<InferenceState> it =fsm.states.iterator; it.hasNext();){
			var state=it.next;
			var removeState=false;
			if(state != fsm.entryState && state != fsm.terminalState){//never touch initial or terminal state
				if(state.incomings.size==1&&state.outgoings.size==1){
				//simplisitc fusion check first, only the middle of a -o-o-o- linear graph
				if(state.incomings.last != state.outgoings.last)//don't remove self loops
				{
					
				if(true || state.incomings.last.sourceState!=state.outgoings.last.goalState){//don't contract the last loop
				fuseOneToOne(state,it);
				updated=true;
				removeState=true;
				
				}
				}
			}
			else if(state.incomings.size==1&& state.outgoings.size>1){
				var selfLoop=false;
				for(t:state.outgoings){
					if(!selfLoop && t.goalState.equals(state)){//don't remove selfloop-fanouts
						selfLoop=true;
					}
					}
				if(!selfLoop){
				fuseOneToMany(state,it);
				updated=true;
				removeState=true;
				}
			}else if(state.incomings.size>1 && state.outgoings.size==1){
				if(!state.outgoings.last.goalState.equals(state)){//don't remove self loop fanins
				fuseManyToOne(state,it);
				updated=true;
				removeState=true;
				
				}
				
				}
				
			
			if(removeState){
			
			Logger.info("All prefixes reachable after contraction:%b",fsm.checkReachable(finalPrefix))
			logDot;
			}				
			}

		}
		Logger.info("Removed %d states by state fusion",removed.size);
		numTrans=0;		
		for(s:fsm.states){
			numTrans+=s.outgoings.size;
		}
		}
		Logger.info("Finished State Fusion, ended with %d states and %d transitions",fsm.states.size,numTrans)
	}
}