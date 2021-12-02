package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author v0j008y 11 Sept 2021 22:26:41
 */
public class Combinations_77 {

	/**
	 * @param args
	 */

	static List<List<Integer>> res = new ArrayList<>();

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		combine(n, k);
		System.out.println();
	}

	static List<List<Integer>> combine(int n, int k) {
		combine(new ArrayList<>(), n, k, 1);
		return res;
	}

	static void combine(List<Integer> list, int n, int k, int start) {
		if (list.size() == k) {
			List<Integer> temp = new ArrayList<>(list);
			res.add(temp);
			return;
		}

		for (int i = start; i <= n; i++) {
			list.add(i);
			combine(list, n, k, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
