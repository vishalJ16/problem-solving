package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author v0j008y 13 Nov 2021 23:05:21
 */
public class QuadSum_18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		QuadSum_18 o = new QuadSum_18();
		o.fourSum(nums, target);
		System.out.println();
	}

	public List<List<Integer>> fourSum(int[] a, int target) {
		int n = a.length;
		List<List<Integer>> res = new ArrayList<>();

		// Map<Integer, List<Pair>> hm = new HashMap<>();
		Map<Integer, Pair> hm = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (i != j) {
					Pair p = new Pair(i, j);
					int sum = a[i] + a[j];
					// List<Pair> list = hm.getOrDefault(sum, new ArrayList<>());
					// list.add(p);
					// hm.put(sum,list);
					hm.put(sum, p);
				}
			}
		}

		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = a[i] + a[j];
				if (hm.containsKey(target - sum) && !visited.contains(target - sum)) {
					visited.add(target - sum);
					Pair p = hm.get(target - sum);
					// for(Pair p : hm.get(target-sum)) {
					if (i != p.a && i != p.b && j != p.a && j != p.b) {
						List<Integer> temp = new ArrayList<>();
						temp.add(a[i]);
						temp.add(a[j]);
						temp.add(a[p.a]);
						temp.add(a[p.b]);
						res.add(temp);
					}
					// }
				}
			}
		}
		return res;
	}

	class Pair {
		int a;
		int b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

}
