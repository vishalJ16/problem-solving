/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 24 Sept 2021 19:12:35
 */
public class PerfectSquares_279 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 51;
//		int ans = numSquares(n);
		int ans = findUsingDPOptimised(n, (int) Math.sqrt(n));
		System.out.println(ans);
	}

	static int min = Integer.MAX_VALUE;

	static int numSquares(int n) {
		/*
		 * RECURSIVE CODE works fine.... checked on eclipse...for input 330, got TLE on
		 * leetcode, using eclipse got the ans=3; and the actual ans is also 3. Also
		 * checked here in leetcode, by running code for TC 330.
		 */

		/*
		 * ALGORITHM : 1. Get sqrt of n : a. If n is perfect sq. then ans is 1 (implied
		 * by recursive base condition). b. else, n can be written as sum of perfect
		 * squares of combination of numbers from 1 to sqrt. There can be multiple such
		 * combinations; we will find all; and see which combination has least number of
		 * perfect squares. For e.g - 5 can be written as 4+1 or 1+1+1+1+1. The least
		 * number here is 2, in combination 4+1. 2. Loop in numSquares() is to find
		 * possibilities, when you start with sqrt number. For e.g. 12 = 3^2 + 3*1^1;
		 * also 12 = 3*2^2; also 12 = 12*1^1; 3. Loop in find() is for backtrack...see
		 * e.g to understand what I mean. For e.g. n = 43, ans is 3; 43 = 25 + 9 + 9;
		 * See code flow when find(5, 43, 0) is called -> We reach find(4, 18, 1) in
		 * next recursive call; now we proceed further, we reach find(3,2,2) ->
		 * find(2,2,2) -> find(1,2,2) -> find(1,1,3) -> return 4. But we missed the
		 * actual solution, which would have come, if we had started with find(3, 18,
		 * 1)...so it follows: find(3, 18, 1) -> find(3, 9, 2) -> return 3.
		 * 
		 * Please note - Any given n will be ultimately having at least 1 one such
		 * combination, i.e. summation of 1 to make it n. This implies, for any
		 * hypothetical case, if you are not able to write "n" as summation of perfefct
		 * squares, then you have the ans as summation of 1.
		 */

		// 331/588 tc passes, last failure input: 330
		int sqrt = (int) Math.sqrt(n);
		for (int i = sqrt; i >= 1; i--) {
			find(i, n, 0);
		}
		return min;
	}

	static void find(int sqrt, int sum, int count) {
		int ps = sqrt * sqrt;
		if (ps == sum) {
			count++;
			if (count < min) {
				min = count;
			}
			return;
		}
		if (ps > sum) {
			find(sqrt - 1, sum, count);
		} else {
			for (int i = sqrt; i >= 1; i--) {
				find(i, sum - ps, count + 1);
			}
		}
	}

	// ============ SOLUTION-2 ===========================================
	/*
	 * ALGORITHM:
	 * 1. Find sqrt of n.
	 * 2. n can be written as combination  of sum of ps[i], where 1<=i<=sqrt
	 */	
	static int findUsingDP(int n, int sqrt) {
		// 552/588 tc passes, last failure input: 7927
		int[][] res = new int[sqrt + 1][n + 1];

		for (int i = 1; i <= sqrt; i++) {
			for (int j = 1; j <= n; j++) {
				findMin(i, j, res);
			}
		}
		return res[sqrt][n];
	}

	static void findMin(int i, int j, int res[][]) {
		int min = Integer.MAX_VALUE;
		for (int k = i; k >= 1; k--) {
			int ans = j / (k * k);
			int rem = j % (k * k);
			if (rem != 0) {
				ans += res[k - 1][rem];
			}
			if (ans < min) {
				min = ans;
			}
		}
		res[i][j] = min;
	}

	// ============ SOLUTION-3 ===========================================
	static int findUsingDPOptimised(int n, int sqrt) {

		// 588/588 tc passes...!!!

		int[][] res = new int[sqrt + 1][n + 1];

		for (int i = 1; i <= sqrt; i++) {
//			System.out.println("i: " + i);
			for (int j = 1; j <= n; j++) {
				int ans = j / (i * i);
				int rem = j % (i * i);
				if (rem != 0) {
					ans += res[i - 1][rem];
				}
				if (i > 1) {
					ans = ans < res[i - 1][j] ? ans : res[i - 1][j];
				}
				res[i][j] = ans;
			}
		}
		return res[sqrt][n];
	}
}
