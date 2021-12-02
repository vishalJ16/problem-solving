/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 1 Sept 2021
 * 23:36:24
 */
public class SortColors_75 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = {1,2,0};
		sortColors(nums);
		System.out.println("done");
	}

    static void sortColors(int[] nums) {
        
        int n = nums.length;
        
        int zeroPos = 0;
        int twoPos = n-1;
        
        for(int i=0; i<n; i++) {
            if(zeroPos < i && nums[i] == 0) {
                while(zeroPos <i && nums[zeroPos] == 0) {
                    zeroPos++;
                }
                swap(nums, i, zeroPos);
                if(nums[i] == 0 || nums[i] == 2) {
                	i=i-1;
                }
                zeroPos++;
            }
            else if(twoPos >i && nums[i] == 2) {
                while(twoPos > i && nums[twoPos] == 2) {
                    twoPos--;
                }
                swap(nums, i, twoPos);
                if(nums[i] == 0 || nums[i] == 2) {
                	i=i-1;
                }
                twoPos--;
            }
        }
    }
    
    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
