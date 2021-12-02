/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author v0j008y 14 Sept 2021 00:47:32
 */
public class IntersectionOf2Arr_350 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 1 };
		int[] b = { 2, 2 };
		intersect(a, b);
		System.out.println();
	}

	static int[] intersect(int[] a, int[] b) {

//	         // approach-1 using sorting
//	         List<Integer> list = new ArrayList<>();
//	         Arrays.sort(a);
//	         Arrays.sort(b);

//	         int i=0;
//	         int j=0;

//	         while(i<a.length && j<b.length) {
//	             if(a[i]-b[j] == 0) {
//	                 list.add(a[i]);
//	                 i++;
//	                 j++;
//	             }
//	             else if (a[i] > b[j]) {
//	                 j++;
//	             }
//	             else {
//	                 i++;
//	             }
//	         }

//	         int[] res = new int[list.size()];
//	         for(i=0; i<list.size(); i++) {
//	             res[i] = list.get(i);
//	         }
//	         return res;

		// approach 2 using hashing

		Map<Integer, Integer> hm1 = new HashMap<>();
		Map<Integer, Integer> hm2 = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			int count = 1;
			if (hm1.containsKey(a[i])) {
				count += hm1.get(a[i]);
			}
			hm1.put(a[i], count);
		}

		for (int i = 0; i < b.length; i++) {
			int count = 1;
			if (hm2.containsKey(b[i])) {
				count += hm2.get(b[i]);
			}
			hm2.put(b[i], count);
		}

		List<Integer> list = new ArrayList<>();
		hm1.forEach((k, v) -> {
			if (hm2.containsKey(k)) {
				int n = hm2.get(k) < v ? hm2.get(k) : v;
				for (int i = 0; i < n; i++) {
					list.add(k);
				}
			}
		});

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

}
