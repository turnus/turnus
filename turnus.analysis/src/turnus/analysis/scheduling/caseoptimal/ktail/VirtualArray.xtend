package turnus.analysis.scheduling.caseoptimal.ktail
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Arrays

@Accessors class VirtualArray {
	ArrayList<Integer[]> arrays=new ArrayList;
	int combined_size=0;
	new(Integer[] a){
		add(a);
	}
	new(Integer[] a,Integer[] b){
			add(a);
			add(b);
	}
	new(Integer[] a,Integer[] b,Integer[] c){
		add(a);
		add(b);
		add(c);
		}
	def add(Integer[] a){
		if(a!=null){
		combined_size+=a.size;
		arrays.add(a);
		}
	}
	def Integer get(int i){
		if(i<combined_size){
		var combinedInd=i;
		for(a:arrays){
			if(combinedInd>=a.size){
				combinedInd-=a.size;
			}else{
				return a.get(combinedInd);
			}
		}
		}
		throw new IndexOutOfBoundsException(String.format("Error with virtual array, combined size %d, access at %d",combined_size,i));
		}
		
	def continuedHash(int hash,Integer[] arr){
		var result=hash;
		if(arr!=null && arr.size!=0){
			for(i:arr){
				result=(result*31).bitwiseXor(i);
			}
		}
		return result;
	}
	@Override
	override public int hashCode(){
		var hash=1;
		for(a:arrays){
			hash=continuedHash(hash,a);
		}
		return hash;
	}
	
	@Override
	def public override String toString(){
		var s= new String;
		for(a:arrays){
			s=s+Arrays.toString(a);
		}
		return s;
	}
	
	@Override
	override public boolean equals(Object o){
		if(o!=null && o instanceof VirtualArray){
			val oa=o as VirtualArray;
			if(oa.combined_size==combined_size){
				for(i:combined_size>..0){
					if(get(i)!=oa.get(i)){
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	new(VirtualArray va){
		this.arrays.addAll(va.arrays);
		this.combined_size=va.combined_size;
	}
	def toArray(){
		var newArr=newArrayOfSize(combined_size);
		var end=arrays.get(0).size;
		var start=0;
		var array=0;
		while(end<=combined_size){
			val cur_arr=arrays.get(array);
			for(ind:start..<end){
				newArr.set(ind,cur_arr.get(ind-start));
			}
			array+=1;
		}
		return newArr
	}
	def getRange(Integer start, Integer stop){
		var out=newArrayOfSize(stop-start);
		for(i:start..<stop){
			out.set(i,get(i));
		}
		return out;
	}
	def VirtualArray extend(Integer[] a){
		var extended=new VirtualArray(this);
		extended.add(a);
		return extended;
	}
}