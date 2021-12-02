/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 2 Sept 2021 00:41:21
 */
public class SearchA2dMatrix_74 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[][] = { { 1 } };
		boolean ans = searchMatrix(nums, 2);
		System.out.println(ans);
		/*
		 * Another good solution:
		 * https://leetcode.com/problems/search-a-2d-matrix/discuss/1438534/Binary-
		 * search-with-intuitive-video-explanation-resource-or-0-ms
		 * 
		 */	}

	static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int row = findRowNumber(matrix, target);
		if (row == -1) {
			return false;
		}
		return findNumber(matrix[row], target);
	}

	static int findRowNumber(int a[][], int k) {
		int low = 0;
		int high = a.length-1; // no. of rows
		int col = a[0].length - 1; // last column

		while (low <= high) {
			int mid = (low + high) / 2;

			if ((k == a[mid][col]) || (mid == 0 && k < a[mid][col])
					|| (mid > 0 && k < a[mid][col] && k > a[mid - 1][col])) {
				return mid;
			}
			else if((mid < a.length - 1 && k > a[mid][col] && k < a[mid + 1][col])) {
				return mid+1;
			} else if (k < a[mid][col]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	static boolean findNumber(int a[], int k) {
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (k == a[mid]) {
				return true;
			} else if (k > a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

}
