package turnus.analysis.scheduling.caseoptimal

import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.LinkedHashSet

@Accessors class InferenceState {
	
	final int id;
	LinkedHashSet<Transition> incomings=new LinkedHashSet;
	LinkedHashSet<Transition> outgoings=new LinkedHashSet;
	LinkedHashSet<Prefix> prefixes = new LinkedHashSet;
	
	new(int id){
		this.id=id;
	}
	@Override
	def override public int hashCode(){
		return id;
	}
	@Override
	def override public boolean equals(Object o){
		if(o instanceof InferenceState && (o as InferenceState).id==id){
			return true;
		}else{
			return false;
		}
	}
	
	
}