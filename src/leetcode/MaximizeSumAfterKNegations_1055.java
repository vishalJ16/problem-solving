/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author v0j008y 29-Sep-2021 7:13:51 pm
 */
public class MaximizeSumAfterKNegations_1055 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 4, 2, 3 };
		int k = 1;
		int ans = largestSumAfterKNegations(nums, k);
		System.out.println(ans);

		nums = new int[] { 3, -1, 0, 2 };
		k = 3;
		ans = largestSumAfterKNegations(nums, k);
		System.out.println(ans);

		nums = new int[] { 2, -3, -1, 5, -4 };
		k = 2;
		ans = largestSumAfterKNegations(nums, k);
		System.out.println(ans);
		
		nums = new int[] { 4, 4, -9, 2, 1, 7, 5, 8 };
		k = 3;
		ans = largestSumAfterKNegations(nums, k);
		System.out.println(ans);
	}

	static int largestSumAfterKNegations(int[] nums, int k) {

		/*
		 * ALGO: 
		 * 1. sort the array
		 * 2. starting from sorted a[0], negate all a[i] till
		 * k-limit is reached or a[i] becomes non-negative;
		 * 3. If, at this point, a[i] == 0, then break the loop. This implies, we are negating 0 multiple times, which will have no impact on result;
		 * 4. Else, choose abs value of smaller of smallest positive and largest negative, i.e. min(abs(a[i-1]),abs(a[i])).
		 * 5. Negate k minus remaining times this min number.
		 * 6. Return sum of this modified arr.
		 */
		Arrays.sort(nums);

		int i = 0;
		int j = 0;
		while (i < k) {
			if (j < nums.length) {
				if (nums[j] < 0) {
					nums[j] = -nums[j];
					j++;
				} else if (nums[j] == 0) {
					break;
				} else {
					if (j == 0) {
						nums[j] = ((int) Math.pow(-1, k - i)) * nums[j];
					} else {
						int index = nums[j] < nums[j - 1] ? j : j - 1;
						nums[index] = ((int) Math.pow(-1, k - i)) * nums[index];
						break;
					}
				}
			}
			else {
				int index = nums[j - 1] < nums[j - 2] ? j - 1 : j - 2;
				nums[index] = ((int) Math.pow(-1, k - i)) * nums[index];
				break;
			}
			i++;
		}

		int sum = 0;
		for (int x : nums) {
			sum += x;
		}

		return sum;
	}

}
