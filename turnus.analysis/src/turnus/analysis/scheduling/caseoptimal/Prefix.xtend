package turnus.analysis.scheduling.caseoptimal

import turnus.model.analysis.scheduling.ActorSelectionSchedule
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Arrays
import com.google.common.collect.ObjectArrays

@Accessors class Prefix {
	final Integer[] pre;
	final Integer[] tail;
	final Integer[] ktail;//temporary tail only used when comparing
	final VirtualArray full;
	final int k;
	
	new(Integer[] pre, Integer[] tail){
		this.pre=pre;
		this.tail=tail;
		this.k=tail.size;
		this.ktail=null;
		this.full=new VirtualArray(pre,tail);
	}
		new(Integer[] pre, Integer[] tail,Integer[] ktail){
		this.pre=pre;
		this.tail=tail;
		this.k=tail.size;
		this.ktail=ktail;
		this.full=new VirtualArray(pre,tail,ktail);
	}
	
	new(Integer[] content, int k){
		if(content.size>k){
		this.pre=Arrays.copyOfRange(content,0,content.size-k);
		this.tail=Arrays.copyOfRange(content,content.size-k,content.size);
		}
		else{
			this.pre=content;
			this.tail=null;
		}
		this.k=k;
		this.ktail=null;
		this.full=new VirtualArray(pre,tail);
	}
	
	new(Integer[] content, int i,int k){
		if(content != null && content.size>=i){
			this.k=k;
			this.ktail=null;
			if(i>k){
				this.tail=Arrays.copyOfRange(content,i-k,i);
				this.pre=Arrays.copyOfRange(content,0,i-k);
			}else{
				this.tail=null;
				this.pre=Arrays.copyOfRange(content,0,i);
			}
			this.full=new VirtualArray(pre,tail);
		}else{
			this.ktail=null;
			this.pre=null;
			this.k=k;
			this.tail=null;
			this.full=null;
			throw new ArrayIndexOutOfBoundsException("Supplied array is either 0 or array.size<i");
		}
	}
	

	new(Prefix p, Integer[] a){
		this.k=p.k;
		this.pre=p.pre;
		if(p.tail==null){
			this.tail=a;
			this.ktail=null;
		}else if(p.ktail==null){
			this.tail=p.tail;
			this.ktail=a;
		}else{
			this.tail=ObjectArrays.concat(p.tail,p.ktail,Integer);
			this.ktail=a;
		}
		this.full=new VirtualArray(pre,tail,ktail);
	}
	def public boolean canSubtract(Transition t){
		for(i:0..<t.actions.size){
			if(t.actions.size>full.combined_size || full.get(full.combined_size-t.actions.size+i)!=t.actions.get(i)){
				return false;
				}
		}
		return true;
	}
	def public Prefix subtract(Transition t){
		
		for(i:0..<t.actions.size){
			if(t.actions.size>full.combined_size || full.get(full.combined_size-t.actions.size+i)!=t.actions.get(i)){
				throw new ArithmeticException("Can't subtract the transition from this prefix, since the prefixes tail doesn't match the transition");
			}
		}
		var pref = new Prefix(full.getRange(0,full.combined_size-t.actions.size),k);
		return pref;
	}
	
	def public Prefix add(Transition t){
		return new Prefix(this,t.actions);
	}
	

	@Override
	public override def int hashCode(){
		return full.hashCode;	
	}
	
	@Override
	def override public String toString(){
		return this.full.toString;
	}
	
	def public boolean hasPrefix(Prefix o){
		for(i:0..o.full.combined_size){
			if(full.get(i)!=o.full.get(i)){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public override def boolean equals(Object o){
		if(o instanceof Prefix && hashCode==o.hashCode){
			val o_p= o as Prefix;
			return o_p.full.equals(full);
		}
		return false;
	}
}