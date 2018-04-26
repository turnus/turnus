package turnus.analysis.scheduling.caseoptimal.ktail

import java.util.ArrayList
import java.util.LinkedHashMap
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import turnus.analysis.scheduling.caseoptimal.ScheduleInfereceTransition
import turnus.analysis.scheduling.caseoptimal.ScheduleInferenceState
import turnus.common.io.Logger
import turnus.model.analysis.scheduling.FSMComparator
import weka.classifiers.trees.J48
import org.eclipse.ui.dialogs.TwoArrayQuickSorter.StringComparator

abstract class Node{
	def abstract String subtreeToSource();
	def abstract Node flatten();
	def abstract void fuseTransitions(ScheduleInferenceState state);
}

abstract class Condition{
	
}



@Data class MultiCondition {
	ArrayList<BranchCondition> partials;
	new(BranchCondition cond){
		partials=new ArrayList;
		partials.add(cond);
	}
	new(){
		partials=new ArrayList;
	}
	@Override
	def override String toString(){
		'''«FOR p:partials SEPARATOR '&&'»«p.toString»«ENDFOR»'''
	}
}

@Data class Leaf extends Node{
	String stateName;
	String source;
	String transitionSched;
	def public static String regex(){
		regex(null)
	}
	def public static String regex(Integer i){
		'''\[(?<sourceState«i»>[a-zA-Z0-9_]+)->(?<targetState«i»>[a-zA-Z0-9_]+)--(?<transitionSched«i»>[0-9]*) \([0-9.\/]+\)\]'''
	}
	new(Matcher leafMatcher){
		this(leafMatcher,null)
	}
	
	new(Matcher leafMatcher, Integer i){
		stateName=leafMatcher.group('''targetState«i»''')
		source=leafMatcher.group('''sourceState«i»''')
		transitionSched=leafMatcher.group('''transitionSched«i»''')
	}
	def String toKey(){
		'''«source»->«stateName»--«transitionSched»'''
	}
	@Override
	def override subtreeToSource() {
	'''
		next_state=«stateName»;
	'''
	}
	
	override flatten() {
		return this;
	}
	
	override fuseTransitions(ScheduleInferenceState state) {
		val ts=new LinkedHashMap;
		for(t:state.transitions){
			ts.put(t.toKey,t);
		}
		if(ts.size==1){
			val t=ts.values.last;
		val newTran = new ScheduleInfereceTransition(t.actions,new MultiCondition,t.sourceState,t.targetState,t.vars);
		state.transitions.clear;
		state.transitions.add(newTran);
		}else if(ts.size!=0){//no transition means terminal leaf state=> also ok
			throw new KtailConditionFuseException('''Expected only 1 valid followup transition in Leaf based on transition key, got «ts.size»''')
		}
	}
	
}

@Data class MultiBranch extends Node{
	ArrayList<MultiCondition> conditions;
	ArrayList <Node> nodes;
	
	override subtreeToSource() {
		'''«FOR i:0..<nodes.size »
		«IF i==0»if(«conditions.get(i).toString» ){
		«ELSE»else if(«conditions.get(i).toString»){
			«ENDIF»
			«nodes.get(i).subtreeToSource»
		}
		«ENDFOR»
		'''
	}
	
	override flatten() {		
				var flat_conditions =new ArrayList;
				var flat_nodes=new ArrayList;
				for(j:0..<conditions.size){
					val n=nodes.get(j);
					val c=conditions.get(j);
					switch n{
						case n instanceof Leaf:{flat_conditions.add(c);flat_nodes.add(n);},
						case n instanceof Branch:{
					val mb=(n as Branch).flattenToMultiBranch;
					//add all sub branches in this branch, with the branching conditions added to any already existend conditions
					for(i:0..<mb.conditions.size){
						val nc=mb.conditions.get(i);
						val nn=mb.nodes.get(i);
						nc.partials.addAll(0,c.partials);//since we are higher up in the decision tree we need to prepend
						flat_conditions.add(nc);
						flat_nodes.add(nn);
						}
						},
						case n instanceof MultiBranch:{
							val mb=n as MultiBranch;
					//add all sub branches in this branch, with the branching conditions added to any already existend conditions
					for(i:0..<mb.conditions.size){
						val nc=mb.conditions.get(i);
						val nn=mb.nodes.get(i);
						nc.partials.addAll(0,c.partials);//since we are higher up in the decision tree we need to prepend
						flat_conditions.add(nc);
						flat_nodes.add(nn);
						}
						}
					}
				}
				new MultiBranch(flat_conditions,flat_nodes)
	}
	
	override fuseTransitions(ScheduleInferenceState state) {
		val ts=new LinkedHashMap;
		for(t:state.transitions){
			ts.put(t.toKey,t);
		}
		if(state.transitions.size>=conditions.size){
		//sanity check, if the decision tree classifier does it's job properly it identifies
		//unique state->actions->state triples and reduces the amount of transitions
		val newTrans=new ArrayList;
		for(i:0..<conditions.size){
			val MultiCondition c=conditions.get(i);
			val n=nodes.get(i) as Leaf;//at this point there should only be leafs in the multibranch, as this should only be called on a flattened condiitontree
			val k=n.toKey;
			val t=ts.get(k);
			val newTran=new ScheduleInfereceTransition(t.actions,c,t.sourceState,t.targetState,t.vars);
			newTrans.add(newTran);
		}
		state.transitions.clear;
		state.transitions.addAll(newTrans);
		
		
		}else{
			throw new KtailConditionFuseException("Expected the number if unique state->action->state transitions to equal the number of branches, not the case.")
			}
		}
	
}
	
@Data class Branch extends Node{

	String varname;
	BranchCondition leftCond;
	BranchCondition rightCond;
	Node left;
	Node right;
	//
	static val branchRegex='''^\[(?<varname>[a-zA-Z0-9_]+):(?<condl> [<=>]+ [0-9.]+),(?<condr> [<=>]+ [0-9.]+)(?<branches>\[.+\])\]$'''
	static val leafRegex='''^«Leaf.regex»$'''
		
	static val branchPattern=Pattern.compile(branchRegex)
	static val leafPattern=Pattern.compile(leafRegex)
	
	def splitFSA(String s){
		Logger.info('''Splitting branches «s»''')
		val startat =0
		var started=false
		var b=0
		for (i:0..<s.length){
			val char c=s.charAt(i)
			val char openBracket='['
			val char closeBracket=']'
			if(c===openBracket){
				b+=1
				started=true
			}else if(started && c===closeBracket){
				b-=1
			}
			if(started &&b==0){
				val splitind=startat+i+1
				val left=s.subSequence(0,splitind)
				val right=s.subSequence(splitind,s.length)
				return left -> right
			}
		}
		
	}
	//
	
	new(Matcher branchMatcher){
		varname=branchMatcher.group('''varname''');
		leftCond=new BranchCondition(varname,branchMatcher.group('''condl'''));
		rightCond=new BranchCondition(varname,branchMatcher.group('''condr'''));
		val branches=branchMatcher.group('''branches''');
		
		val left_right =splitFSA(branches)
		val leftString = left_right.key
		val rightString = left_right.value
		Logger.info('''left:«leftString»''')
		Logger.info('''right:«rightString»''')
		val leafleft=leafPattern.matcher(leftString)
		val branchleft=branchPattern.matcher(leftString)
		
		val leafright=leafPattern.matcher(rightString)
		val branchright=branchPattern.matcher(rightString)
		
		left=if(leafleft.matches){
			new Leaf(leafleft)
		}else if(branchleft.matches){
			new Branch(branchleft)
		}
		right=if(leafright.matches){
			new Leaf(leafright)
		}else if(branchright.matches){
			new Branch(branchright)
		}
	}
	
	
	
	@Override
	def override subtreeToSource() {
		'''if(«leftCond.toString»){
			«left.subtreeToSource»
		}else if(«rightCond.toString»){
			«right.subtreeToSource»
		}'''
	}
	def static void flattenBranch(Node b, BranchCondition bCond,ArrayList<MultiCondition> conditions,ArrayList<Node> nodes){
		switch b{
			case b instanceof Leaf: {conditions.add(new MultiCondition(bCond));nodes.add(b)},
			case b instanceof Branch:{
				val mb= (b as Branch).flattenToMultiBranch;
				//add all sub branches in this branch, with the branching condition added to any already existend conditions
				for(i:0..<mb.conditions.size){
					val c=mb.conditions.get(i);
					val n=mb.nodes.get(i);
					c.partials.add(0,bCond);//since we are higher up in the decision tree we need to prepend
					conditions.add(c);
					nodes.add(n);
				}
			},
			case b instanceof MultiBranch:{
				val mb=b as MultiBranch;
				//add all sub branches in this branch, with the branching condition added to any already existend conditions
				for(i:0..<mb.conditions.size){
					val c=mb.conditions.get(i);
					val n=mb.nodes.get(i);
					c.partials.add(0,bCond);//since we are higher up in the decision tree we need to prepend
					conditions.add(c);
					nodes.add(n);
				}
			}
		}
	}
	
	def flattenToMultiBranch(){
		var conditions = new ArrayList<MultiCondition>;
		var nodes=new ArrayList<Node>;
		flattenBranch(left,leftCond,conditions,nodes);		
		flattenBranch(right,rightCond,conditions,nodes);
		new MultiBranch(conditions,nodes)
	}
	override flatten() {
		flattenToMultiBranch
		}
		
		override fuseTransitions(ScheduleInferenceState state) {
			this.flattenToMultiBranch.fuseTransitions(state)
		}
	
	def static getRegex() {
		branchRegex
	}
	
}

@Data class Comparator{
	@Accessors(PUBLIC_GETTER) String stringRepresentation;
	def toFSMComparator(){
		switch stringRepresentation{
			case "==":return FSMComparator.EQ
			case ">=":return FSMComparator.GREQ
			case "<=":return FSMComparator.SMEQ
			case "<":return FSMComparator.SMALLER
			case ">":return FSMComparator.GREATER
			case "!=":return FSMComparator.NEQ
		}
	}
}

@Data class BranchCondition extends Condition{
	String varname;
	Comparator comparator;
	String value;
	
	new(String varname,String cond){
		val split_cond=cond.trim.split(" ");
		this.varname=varname;
		comparator=new Comparator(split_cond.get(0));
		value=split_cond.get(1);
	}
	def public static regex(Integer i){
		'''(?<cond«i»> [<=>]+ [0-9.]+)'''
	}
	
	def public static regex(Integer i, Integer j){
		'''(?<cond«i»«j»> [<=>]+ [0-9.]+)'''
	}
	
	@Override
	def override String toString(){
		'''«varname» «comparator.stringRepresentation» «value»'''
	}
}


class KtailFuseParseException extends KtailConditionFuseException{
	
	new(String message) {
		super(message);
	}
	
}

class KTailDecisionTreeClassifier extends J48 {
	new(){
		super()
		this.minNumObj = 1;
		this.confidenceFactor = 1;//quivalent to not pruning, since we want deterministic decisions
	}
	def static getTransitionConds(String prefix){
		val branchRegex = '''«Branch.regex»'''
		val leafRegex = '''^«Leaf.regex»$'''
		val branch=Pattern.compile(branchRegex);
		val leaf=Pattern.compile(leafRegex);
		var curString=prefix;
	
		val branch_matcher=branch.matcher(curString);
		val leaf_matcher=leaf.matcher(curString);
		Logger.info('''Parsing prefix:
		«curString»
		branchRegex:«branchRegex»
		leafRegex:«leafRegex»
		''');
		val Node root= if(branch_matcher.matches){
				
				new Branch(branch_matcher)
			
			}else if(leaf_matcher.matches){
				
				new Leaf(leaf_matcher)
			
			}
			else{
					throw new KtailFuseParseException('''Could not parse tree:\n«curString»''');				
			}
		
		
		//get inner, check if full match
		//if full match descend into branches
		root.flatten()
	}
	def getTransitionConds(){
		val prefixString =this.prefix.replaceAll("\n","").replaceAll("\t","");
			getTransitionConds(prefixString)
				}
	}