/**
 * 
 */
package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author v0j008y 21 Oct 2021 23:39:23
 */
public class UniqueCombinationSum_Oracle {
	/*
	 * Exact same ques:
	 * https://www.geeksforgeeks.org/all-unique-combinations-whose-sum-equals-to-k/
	 *
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] a = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		int[] a = {1,1,1,2,2,4};
		target = 7;
		findSum(a, target);
	}

	static void findSum(int a[], int target) {
		Arrays.sort(a);
		findSum(a, target, new ArrayList<Integer>(), 0);
	}

	static void findSum(int a[], int target, List<Integer> list, int start) {
		if (target == 0) {
			printAns(list);
			return;
		}
		if (target < 0) {
			System.out.println("target < 0");
			printAns(list);
			return;
		}
		for (int i = start; i < a.length; i++) {
			if(i > start && a[i] == a[i-1]) {
				continue;
			}
			list.add(a[i]);
			findSum(a, target - a[i], list, i + 1);
			list.remove(list.size() - 1);
		}
	}

	static void printAns(List<Integer> list) {
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
