package turnus.analysis.scheduling.caseoptimal

import com.google.common.collect.LinkedHashMultimap
import java.util.LinkedHashMap
import java.util.ArrayList
import java.util.HashSet
import java.util.Stack
import turnus.common.io.Logger
import java.util.EmptyStackException

class PrefixStuckException extends EmptyStackException{
	final InferenceState stuckState;
	final Prefix stuckPrefix;
	new() {
        super();
        this.stuckPrefix=null;
        this.stuckState=null;
    }
    new(Prefix stuckPrefix, InferenceState stuckState){
    	super();
    	this.stuckState=stuckState;
    	this.stuckPrefix=stuckPrefix;
    }
    @Override
    def override getMessage(){
    	if(this.stuckPrefix==null){
    		"The fsm could not be traversed with the given prefix"
    	}else{
    		'''The fsm traversal got stuck at prefix 
    		«stuckPrefix.toString»
    		and state
    		«stuckState.id»'''
    	}
    }
}

class TraceReconstructor {
	final InferenceFSM fsm;
	InferenceState initialState;
	Prefix fullPrefix;
	ArrayList<Transition> order;
	Stack<HashSet<Transition>> remainders = new Stack;
	Stack<Integer> remainder_len = new Stack;
	Stack<Prefix> bifurc_prefix = new Stack;
	new(LinkedHashMultimap<InferenceState, Prefix> eqClasses, LinkedHashMap<Prefix, InferenceState> prefixes, Prefix fullPrefix) {
		this.fullPrefix=fullPrefix;
		this.order=new ArrayList(fullPrefix.full.combined_size);
		this.fsm=new InferenceFSM(eqClasses,prefixes);
	
	}
	
	new(InferenceFSM fsm, Prefix fullPrefix) {
		this.fullPrefix=fullPrefix;
		this.order=new ArrayList(fullPrefix.full.combined_size);
		this.fsm=fsm;
	}
	
	def rememberBifurcation(HashSet<Transition> remaining,Integer i, Prefix p){
		Logger.info("Pushing %d candidates onto stack at length %d",remaining.size,i);
		remainders.push(remaining);
		remainder_len.push(i);
		bifurc_prefix.push(p);
		
	}
	def public depth_first(){
		//depth first search with backtracking and dead end detection using the full prefix
		var curPrefix=fullPrefix;
		var curState=fsm.reachablePrefixes.get(curPrefix);
		
		var done=false;
		var ind=0;
		while(!done){
			done=curPrefix.full.combined_size==0;
			if(!done){
			var frontier = new HashSet;
			for(t:curState.incomings){
					frontier.add(t);
			}
				var candidates=new HashSet;
			for(t:frontier){
				
				
				if(curPrefix.canSubtract(t) &&t.sourceState.prefixes.contains(curPrefix.subtract(t))){
						candidates.add(t);
				}
				}
				
				if(candidates.size==1){
					if(order.size>ind){
					order.set(ind,candidates.last);
					}else{
						order.add(candidates.last);
					}
				}else if(candidates.size>1){
					val try_choice=candidates.last;
					candidates.remove(try_choice);
					
					if(order.size>ind){
					order.set(ind,try_choice);
					}else{
						order.add(try_choice);
					}
					rememberBifurcation(candidates,ind,curPrefix);
				}else{
					//if we are in this branch, we have hit a dead and and need to backtrack.
					// we pop the index from the stack, pop the hashset,remove one candidate
					// if there are remaining candidats, we pop them on the stack again. if the hashset is empty, then not
					try {ind=remainder_len.pop;
					val remainder_cands=remainders.pop;
					val try_choice=remainder_cands.last;
					remainder_cands.remove(try_choice);
					curPrefix=bifurc_prefix.pop;
					if(remainder_cands.size>0){
						rememberBifurcation(remainder_cands,ind,curPrefix)
					};
					order.set(ind,try_choice);//no check here, since we should only be here when backtracking
					}catch (EmptyStackException e){
						throw new PrefixStuckException(curPrefix,curState);
					}
				}
			
			curState=order.get(ind).sourceState;
			curPrefix=curPrefix.subtract(order.get(ind));
			ind+=1;
			}
		}
		initialState=order.get(ind-1).sourceState;
		return order.subList(0,ind).reverse;
	}
	
	def initial_state() {
		return initialState;
	}
}
	