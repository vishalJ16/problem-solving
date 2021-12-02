/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author v0j008y 24 Nov 2021 22:27:08
 */
public class LIS_300 {

	static int max = 0;
	static List<Integer> list = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 10, 9, 2, 5, 3, 7, 101, 18 };
		a = new int[] { 0, 1, 0, 3, 2, 3 };
		LIS_300 o = new LIS_300();
		o.lengthOfLIS(a);
		System.out.println("max:" + max);
	}

	public int lengthOfLIS(int[] nums) {
		// 22/54 tc passed
		for (int i = 0; i < nums.length; i++) {
//			System.out.print(nums[i] + "->");
//			list.add(nums[i]);
			find(nums, i, i + 1, 1, nums[i]);
//			list.remove(list.size() - 1);
		}
		return max;
	}

	void find(int[] a, int pivot, int startIndex, int count, int last) {
		if (startIndex >= a.length) {
//			System.out.println();
			print(list);
			if (count > max) {
				max = count;
			}
			return;
		}

		for (int i = startIndex; i < a.length; i++) {
//			System.out.print(a[startIndex] + "->");
//			list.add(a[startIndex]);
			if (a[i] > last) {
				find(a, pivot, i + 1, count + 1, a[i]);
			} else {
				find(a, pivot, i + 1, count, last);
			}
//			list.remove(list.size() - 1);
		}
	}
	
	// =============== approach 2=======================
	
	void print(List<Integer> list) {
		for (int i : list) {
			System.out.print(i + "->");
		}
		System.out.println();
	}

}
