/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author v0j008y
 * 25 Sept 2021
 * 00:46:07
 */
public class ShuffleANARray_384 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {-6,10,184};
		ShuffleANARray_384 o = new ShuffleANARray_384(nums);
		for(int i=0; i<4; i++) {
			o.shuffle();
		}
		System.out.println();
	}
	
    int[] originalArr;
    int[] copy;
    
    int shuffleCount = 1;
    
    public ShuffleANARray_384(int[] nums) {
        this.originalArr = nums;
        this.copy = Arrays.copyOf(nums,nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = copy.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            res[(i+shuffleCount)%n] = copy[i];
        }
        shuffleCount++;
        copy = res;
        return res;
    }

}
