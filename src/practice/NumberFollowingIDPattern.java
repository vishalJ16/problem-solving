/**
 * 
 */
package practice;

/**
 * @author v0j008y 31 Oct 2021 00:09:47
 */
public class NumberFollowingIDPattern {

	/**
	 * @param args https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126
	 */
	public static void main(String[] args) {
		String[] q = { "DDDDDDDD", "IIIIIIII", "DD", "III", "IIDDD", "DIDIDIDI", "IDIDIDID" };

		for (String s : q) {
			System.out.println(printMinNumberForPattern(s));
		}
	}

	static String printMinNumberForPattern(String s) {
		String ans = "";
		int x = 0;
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 0;

		int dCount = 0;
		int iCount = 0;
		while (k < s.length()) {
			if (s.charAt(k) == 'D') {
				while (k < s.length() && s.charAt(k) == 'D') {
					dCount++;
					k++;
				}
			} else {
				while (k < s.length() && s.charAt(k) == 'I') {
					iCount++;
					k++;
				}
			}

			if (dCount == 0) {
				if (k == s.length()) {
					iCount = iCount + 1;
				}
				for (int i = 0; i < iCount; i++) {
					x = getMin(nums);
					nums[x] = 0;
					ans += x;
				}
				iCount = 0;
				// if(k == s.length()) {
				// ans += x+1;
				// break;
				// }
			} else {
				if (k == s.length()) {
					dCount = dCount + 1;
				}
				int start = x + dCount;
				for (int i = 0; i < dCount; i++) {
					ans += start;
					nums[start] = 0;
					start--;
				}
				dCount = 0;
				// if(k == s.length()) {
				// ans += start;
				// break;
				// }
			}

			// while(k<s.length() && s.charAt(k) == 'D') {
			// count++;
			// k++;
			// }
			// // if(c == 'I') {
			// if(count == 0) {
			// x = getMin(nums);
			// nums[x-1] = 0; // mark a no. 0 when used.
			// ans += x;
			// }
			// else {
			// int start = x+count;
			// for(int i=0; i<count; i++) {
			// ans += start;
			// nums[start-1] = 0;
			// start--;
			// }
			// count = 0;
			// }
			// if(k <s.length() && s.charAt(k) == 'I') {
			// k++;
			// }
			// // }
		}
		return ans;
	}

	static int getMin(int[] a) {
		int min = 10;
		for (int i : a) {
			if (i != 0 && i < min) {
				min = i;
			}
		}
		return min;
	}

}
