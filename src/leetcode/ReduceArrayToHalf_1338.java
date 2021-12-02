/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author v0j008y 1 Dec 2021 19:55:55
 */
public class ReduceArrayToHalf_1338 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ReduceArrayToHalf_1338 o = new ReduceArrayToHalf_1338();
		int ans = o.minSetSize2(a);
		System.out.println("ans: " + ans);
	}

//	===================approach 2==============================
	public int minSetSize2(int[] arr) {

		Map<Integer, Integer> hm = new HashMap<>();
		for (int x : arr) {
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}

		int[] freq = new int[hm.size()];
		int k = 0;
		for (int v : hm.values()) {
			freq[k] = v;
			k++;
		}
		Arrays.sort(freq);

		int removed = 0;
		int count = 0;
		for (int i = freq.length - 1; i >= 0; i--) {
			removed += freq[i];
			count++;

			if (removed >= arr.length / 2) {
				return count;
			}
		}
		return count;
	}

//	===================approach 1==============================
	public int minSetSize(int[] arr) {
		int n = arr.length;
		Map<Integer, Integer> hm = new HashMap<>();

		for (int i : arr) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}

		Pair[] a = new Pair[hm.size()];
		int i = 0;

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
			Pair p = new Pair(e.getKey(), e.getValue());
			a[i] = p;
			i++;
		}

		buildMaxHeap(a, a.length);

		int removedSize = 0;
		int count = 0;

		int heapSize = a.length;
		while (removedSize < n / 2) {
			count++;
			removedSize += extractMax(a, heapSize).freq;
			heapSize--;
		}

		return count;
	}

	void buildMaxHeap(Pair[] a, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(a, i, n);
		}
	}

	void heapify(Pair[] a, int i, int n) {
		Pair max = a[i];
		int maxInd = i;

		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && a[l].freq > max.freq) {
			max = a[l];
			maxInd = l;
		}
		if (r < n && a[r].freq > max.freq) {
			max = a[r];
			maxInd = r;
		}

		if (maxInd != i) {
			Pair temp = a[i];
			a[i] = a[maxInd];
			a[maxInd] = temp;

			heapify(a, maxInd, n);
		}
	}

	Pair extractMax(Pair[] a, int heapSize) {
		Pair max = a[0];
		a[0] = a[heapSize - 1];
		heapSize--;
		heapify(a, 0, heapSize);
		return max;
	}

}

class Pair {
	int value;
	int freq;

	Pair(int value, int freq) {
		this.value = value;
		this.freq = freq;
	}
}
