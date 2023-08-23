package turnus.analysis.scheduling.caseoptimal.ktail

import java.util.Set

public class KTails {
	int k;
	final Set<Integer> alphabet;
	// XXX note, the object supplying the Set needs to have consistent iteration order, like linkedhashset or treeset. The order itself is not important, but it must sty the same between iterations
	boolean done;
	Integer[] currentTail;
	Integer[] currentIndices;

	new(int k, Set<Integer> alphabet) {
		this.k = k;
		this.alphabet = alphabet;
		this.done = false;
		currentTail = newArrayOfSize(k);
		currentIndices = newArrayOfSize(k);

		for (i : 0 ..< k) {
			currentTail.set(i, alphabet.toArray.get(0) as Integer);
			currentIndices.set(i, 0);
		}
	}

	def boolean done() {
		done
	// currentIndices.forall[i|i>=alphabet.size]
	}

	def Integer[] next() {
		increment();
		for (i : 0 ..< k) {
			val ind = currentIndices.get(i);
			currentTail.set(i, alphabet.toArray.get(ind) as Integer);
		}
		return currentTail;
	}

	def boolean incrementPos(Integer index) {
		val oldval = currentIndices.get(index);
		val overflow = oldval + 1 >= alphabet.size;
		currentIndices.set(index, (oldval + 1) % alphabet.size);
		return overflow;
	}

	def reset() {
		done = false;
		for (i : 0 ..< k) {
			currentIndices.set(i, 0);
			currentTail.set(i, alphabet.toArray.get(0) as Integer);
		}
	}

	def increment() {
		var cur_index = currentTail.size - 1;
		var increment_done = false;
		while (cur_index >= 0 && !done && !increment_done) {
			increment_done = !incrementPos(cur_index);
			cur_index -= 1;
		}
		if (!increment_done && cur_index < 0) {
			done = true;
		}
	}

}
