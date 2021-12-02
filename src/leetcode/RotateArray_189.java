/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 7 Sept 2021
 * 17:32:23
 */
public class RotateArray_189 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		int k = 2;
		rotate(nums, k);
		System.out.println();
	}

	static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        
        int i = 0;
        int j = 0;
        while(i < n-1) {
            int temp = nums[(i+k)%n];
            nums[(i+k)%n] = nums[j];
            nums[j] = temp;
            
            j++;
            i++;
            if(j==k) {
                j=0;
            }
        }
	}
}
