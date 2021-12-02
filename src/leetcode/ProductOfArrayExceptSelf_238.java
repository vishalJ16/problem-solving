/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 24 Sept 2021 13:33:24
 */
public class ProductOfArrayExceptSelf_238 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 }; // res = [24,12,8,6]
		int[] b = { -1, 1, 0, -3, 3 }; // res = [0,0,9,0,0]
		int[] c = { -1, 1, 0, -3, 3, 0 }; // res = [0,0,0,0,0,0]

		productExceptSelf(a);
		productExceptSelf(b);
		productExceptSelf(c);

	}

	static int[] productExceptSelf(int[] a) {

		// challenges : 1. what if arr has 1 zero; 2. what if arr has multiple
		// zeros...divison won't work here

		/*
		 * 3 cases we can have: 1. No zeros: simple take prod of all a[i], and res[i] =
		 * prod/a[i]; 2. Only 1 zero: All res[i] will be zero, except for one index
		 * where a[i] = 0; For this res[i], take prod of all a[i] except 0. Assign this
		 * to res[i]. 3. More than 1 zero, in this case all res[i] will be zero.
		 * 
		 */

		int[] res = new int[a.length];

		int zeroCount = 0;
		int singlZeroIndex = -1;
		int prod = 1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				zeroCount++;
				singlZeroIndex = i;
			} else {
				prod *= a[i];
			}
		}
		if (zeroCount > 1) {
			// return all zeros
			return res;
		}
		if (zeroCount == 1) {
			res[singlZeroIndex] = prod;
			return res;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				res[i] = prod;
			} else {
				res[i] = prod / a[i];
			}
		}
		return res;
	}
}
