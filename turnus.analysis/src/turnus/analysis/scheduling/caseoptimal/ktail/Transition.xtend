package turnus.analysis.scheduling.caseoptimal.ktail

import java.util.ArrayList
import java.util.Arrays
import org.apache.poi.ss.formula.eval.NotImplementedException
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors class Transition {
	public final InferenceState sourceState;
	public final InferenceState goalState;
	public ArrayList<Integer> actions=new ArrayList;
	
	public new( InferenceState source, InferenceState goal, Integer action){
		this.goalState=goal;
		this.sourceState=source;
		this.actions.add(action);
	}
	public new( InferenceState source, InferenceState goal,  Iterable<Integer> actions){
		this.goalState=goal;
		this.sourceState=source;
		this.actions.addAll(actions);
	}
		
	def public static combine(Transition t1,Transition t2){
		var newTran = new Transition(t1.sourceState,t2.goalState,t1.actions);
		newTran.actions.addAll(t2.actions);
		if(!newTran.connects(t1.sourceState,t2.goalState)){
			throw new NotImplementedException("The transition formed by combining these two transitions would not actually be able to connect the two states");
		}
		return newTran;
	}
	
	@Override
	def override public int hashCode(){
		return (sourceState.hashCode*31).bitwiseXor(goalState.hashCode*15);
		}
		
	@Override
	def override public boolean equals(Object o){
		if(o!==null && o instanceof Transition){
			val ot= o as Transition;
		if(this.goalState==ot.goalState && this.sourceState==ot.sourceState && Arrays.equals(this.actions.toArray,ot.actions.toArray())){
		return true;
		}
	}
	
	return false;
	
	}
	def public boolean connects(Prefix p1,Prefix p2){
		return connects(p1,p2,true);
	}
	
	def public boolean connects(Prefix p1, Prefix p2, boolean directed){
	val p1_extended=p1.full.extend(actions);
	return p1_extended.equals(p2.full) || (!directed && p2.full.extend(actions).equals(p1.full));
	}

	def public boolean connects(InferenceState  s1, InferenceState s2){
	for(p1:s1.prefixes){
		for(p2:s2.prefixes){
			if(connects(p1,p2)){
				return true;
			}
		}
	}
	return false;
	}
}
