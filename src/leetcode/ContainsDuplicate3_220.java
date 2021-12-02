/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 14 Sept 2021 20:43:07
 */
public class ContainsDuplicate3_220 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { -2147483648, 2147483647 };
		int k = 1;
		int t = 1;
		containsNearbyAlmostDuplicate(a, k, t);
	}

	static boolean containsNearbyAlmostDuplicate(int[] a, int k, int t) {

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j <= i + k && j < a.length; j++) {
				if (Math.abs(a[i] - a[j]) <= t) {
					return true;
				}
			}
		}
		return false;
	}
}
