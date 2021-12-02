/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author v0j008y 26 Sept 2021 10:34:52
 */
public class CoinChange_322 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;

//		coins = new int[] { 186, 419, 83, 408 };
//		amount = 6249;
//
//		coins = new int[] { 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422 };
//		amount = 9864;
		int ans = coinChangeDP2(coins, amount);
		System.out.println(ans);
	}

	static int min = Integer.MAX_VALUE;

	static int coinChangeRecur(int[] coins, int amount) {
		Arrays.sort(coins);
		recur(amount, 0, coins, 0);
		return min;
	}

	static void recur(int amount, int count, int[] coins, int start) {
		if (amount == 0) {
			min = count < min ? count : min;
			return;
		}
		if (amount < 0) {
			return;
		}
		for (int i = start; i < coins.length; i++) {
			recur(amount - coins[i], count + 1, coins, i);
		}
	}

	// DP-2
	static int coinChangeDP2(int[] coins, int amount) {
		Arrays.sort(coins);
		int[] minCoinsForAmount = new int[amount + 1];

		minCoinsForAmount[0] = 0;
		for (int i = 1; i <= amount; i++) {
			minCoinsForAmount[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					int currMinForAmountMinusCoinValue = minCoinsForAmount[i - coins[j]];

					if (currMinForAmountMinusCoinValue != Integer.MAX_VALUE
							&& currMinForAmountMinusCoinValue + 1 < minCoinsForAmount[i]) {
						minCoinsForAmount[i] = currMinForAmountMinusCoinValue + 1;
					}
				}
			}
		}
		return minCoinsForAmount[amount] == Integer.MAX_VALUE ? -1 : minCoinsForAmount[amount];
	}

	// DP-1
	static int coinChangeDP1(int[] coins, int amount) {
		Arrays.sort(coins);
		int dp[][] = new int[coins.length + 1][amount + 1];

		for (int i = 0; i <= coins.length; i++) {
			for (int j = 0; j <= amount; j++) {
				if (j == 0) {
					dp[i][j] = 0;
				} else if (i == 0) {
					dp[i][j] = Integer.MAX_VALUE - 10;
				} else if (j < coins[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				}
			}
		}
		return dp[coins.length][amount] == Integer.MAX_VALUE - 10 ? -1 : dp[coins.length][amount];
	}

	static int coinChange(int[] coins, int amount) {
		/*
		 * THERE'S ONE PROBLEM WITH THIS SOLUTION. CONSIDER: [2,5] amount = 16. Its
		 * solution should be 5. But my code would give 8. See the code flow, you will
		 * understand the problem. The mistake I am making is- I am dividing the number
		 * with ith coin value, keeping the res as no.of coins, and taking the remainder
		 * to form remaining amount using other denominations. What rather I should do
		 * is - I should only subtract the current coin value from required amount, and
		 * then check from dp table that how can I form amount-coinValue using other
		 * denominations or this coin value.
		 */
		Arrays.sort(coins);
		if (amount == 0) {
			return 0;
		}
		int[][] dp = new int[coins.length][amount + 1];

		for (int i = 1; i <= amount; i++) {
			if (i % coins[0] == 0) {
				dp[0][i] = i / coins[0];
			} else {
				dp[0][i] = -1;
			}
		}

		for (int i = 1; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				int num = j / coins[i];
				int rem = j % coins[i];
				if (rem != 0) {
					// rem != 0 means amount j cannot be fully achieved using ith coin.
					// So, j-rem was formed using "num" ith coins; rem amount needs to be created
					// using coins having denomination smaller than ith coin.

					if (dp[i - 1][rem] == -1) {
						// this if-condition implies, rem amount cant be fulfilled using smaller
						// denomination, which in turn implies amount j cannot be achieved using coins
						// till ith denominations; so amount j has to be created using (i-1)th
						// denominations...this value might also be -1, but then this would be the final
						// case; hence it is implied that amount j cant be written using ith
						// denomination
						num = dp[i - 1][j];
					} else if (dp[i - 1][j] == -1) {
						// this if-condition implies, amount j cant be written using previous
						// denominations; and since rem!=0 , both things combined implies amount j
						// cannot be written using ith coins
						num = -1;
					} else {
						num = Math.min(num + dp[i - 1][rem], dp[i - 1][j]);
					}
				}
				if (j == 249) {
					System.out.println();
				}
				dp[i][j] = num;
				if (dp[i][j] == 20) {
					System.out.println("Found at: " + i + ", " + j);
				}
			}
		}
		return dp[coins.length - 1][amount];
	}
}
