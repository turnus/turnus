package turnus.analysis.scheduling.caseoptimal.ktail

import com.google.common.collect.LinkedHashMultimap
import java.util.Arrays
import java.util.Iterator
import java.util.LinkedHashMap
import java.util.LinkedHashSet
import org.eclipse.xtend.lib.annotations.Accessors
import turnus.common.io.Logger

@Accessors class InferenceFSM {
	LinkedHashSet<InferenceState> states;
	LinkedHashMap<Prefix,InferenceState> reachablePrefixes;
	LinkedHashMap<Prefix,InferenceState> transientPrefixes;
	final InferenceState entryState;
	final InferenceState terminalState;
	new(LinkedHashMultimap<InferenceState, Prefix> eqClasses, LinkedHashMap<Prefix, InferenceState> prefixes) {
		this.states= new LinkedHashSet<InferenceState>;
		this.states.addAll(eqClasses.keySet);
		this.reachablePrefixes = prefixes;
		this.transientPrefixes = new LinkedHashMap;
		var Prefix largestPrefix=null;
		var InferenceState entry;
		for(p:reachablePrefixes.keySet){
			if(p.full.combined_size==0){
				entry=reachablePrefixes.get(p);
			}
			if(largestPrefix===null || largestPrefix.full.combined_size<p.full.combined_size){
				largestPrefix=p;
			}
		}
		
		this.entryState=entry;
		this.terminalState=reachablePrefixes.get(largestPrefix);
	}
	
	def trimNode(Iterator<InferenceState> it,InferenceState s){
				it.remove;
				for(p:s.prefixes){
				//remove the prefixes represented in this state, since they are no longer reachable, only transient during transitions
				
				val removed_state=reachablePrefixes.remove(p);	
				transientPrefixes.put(p,removed_state);
				}
	}
	
	def boolean checkReachable(Prefix prefix) {
		val traverser=new TraceReconstructor(this,prefix);
		try{
			traverser.depth_first();
			return true;
		}catch (PrefixStuckException e){
			Logger.info(e.message);
			return false;
		}
	}
	def toDot(boolean prefixTable){
		'''digraph g{
		«FOR s:states»
		n«s.id» [label="«s.id»"];
		«ENDFOR»
		«FOR s:states»
		«FOR t:s.outgoings»
		n«t.sourceState.id»->n«t.goalState.id» [label="«Arrays.toString(t.actions.toArray)»"];
		«ENDFOR»
		«ENDFOR»
		«IF prefixTable»
		 graph [label=<<TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
		 <TR><TD><b>State</b></TD><TD><b>Prefixes</b></TD></TR>
		 «FOR s:states»
		 <TR><TD>n«s.id»</TD><TD>«FOR p:s.prefixes SEPARATOR ",<br/>"»«p.toString»«ENDFOR»</TD></TR>«ENDFOR»,
		 labelloc=b, fontsize=12];
		</TABLE>>];
		«ENDIF»
	}
	'''	
	}
	def toDot() {
		return toDot(false);
	}
	
}
