/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author v0j008y
 * 8 Oct 2021
 * 23:15:28
 */
public class CoinChange2_518 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int amount = 500;
		int[] coins = {3,5,7,8,9,10,11};
		
		amount = 5;
		coins = new int[] {1,2,5};
		int ans = change(amount, coins);
		System.out.println(ans);
	}

    static int change(int amount, int[] coins) {
        Arrays.sort(coins);
//        return ways(amount, coins, 0);
        return waysDP(amount, coins);
    }
    
    static int waysDP(int amount, int[] coins) {
    	int[] waysForAmount = new int[amount+1];
    	waysForAmount[0] = 1;
    	
//    	for (int i=0; i<coins.length; i++)
//            for (int j=coins[i]; j<=amount; j++)
//            	waysForAmount[j] += waysForAmount[j-coins[i]];
// 
//        return waysForAmount[amount];
        
    	for(int i=1; i<=amount; i++) {
    		for(int j=0; j<coins.length; j++) {
    			if(i >= coins[j]) {
    				int rem = i-coins[j];
					waysForAmount[i] = waysForAmount[i] + waysForAmount[rem];
    			}
    		}
    	}
    	return waysForAmount[amount];
    }
    
    static int ways(int amount, int[] coins, int start) {
        if(amount == 0) {
            return 1;
        }
        if(amount < 0) {
            return 0;
        }
        int count = 0;
        for(int i=start; i<coins.length; i++) {
            count += ways(amount-coins[i], coins, i);
        }
        return count;
    }
}
