/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 11 Sept 2021 16:02:02
 */
public class MergeSortedArray_88 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
//		int m = 3;
//		int[] nums2 = { 2, 5, 6 };
//		int n = 3;
		int[] nums1 = {0};
		int m = 0;
		int[] nums2 = {1};
		int n =1;
		mergeBest(nums1, m, nums2, n);
		System.out.println("");
	}

    static void mergeBest(int[] a, int m, int[] b, int n) {
        
        int i=m-1;
        int j=n-1;
        
        int k = m+n-1;
        while(i>=0 && j>=0) {
            if(a[i] > b[j]) {
                a[k] = a[i];
                i--;
            }
            else {
                a[k] = b[j];
                j--;
            }
            k--;
        }
    }
	static void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < m && j < n) {
			k++;
			if (nums2[j] < nums1[i]) {
				int temp = nums1[i];
				nums1[i] = nums2[j];
				nums2[j] = temp;
			} else {
				i++;
			}
		}

		if (i == m) {
			for (int x = j; j < n; x++) {
				nums1[m + n - (n-x)] = nums2[x];
				j++;
			}
		} else {
			for (int x = i; x < m; x++) {
				nums1[m + n - (m-x)] = nums1[x];
				i++;
			}
		}
	}
	
	
    static void mergeSimple(int[] nums1, int m, int[] nums2, int n) {
        
        int[] res = new int[nums1.length];
        
        int i=0;
        int j=0;
        int k=0;
        while(k<nums1.length) {
            if(i<m && nums1[i] < nums2[j]) {
                res[k] = nums1[i];
                i++;
            }
            else{
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        for(i=0; i<nums1.length; i++) {
            nums1[i] = res[i];
        }
    }
    
    static void merge3(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) {
            return;
        }
        int i=0;
        int j=0;
        
        while(i<m) {
            if(nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
            }
            i++;
        }
        for(;i<m+n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
    }
}
