package leetcode;

/**
 * @author v0j008y 1 Sept 2021 00:33:26
 */
public class FirstAndLastPositionOfElementSortedArray_34 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = { 5, 7, 7, 8, 8, 10 };
		int target = 7;
		
		nums = new int[] {1};
		target = 1;

		int ans[] = searchRange(nums, target);
		System.out.println(ans[0] + ", " + ans[1]);
	}

	static int[] searchRange(int[] nums, int target) {
		return search(nums, 0, nums.length - 1, target);
	}

	static int[] search(int[] nums, int start, int end, int target) {
		int[] ans = { -1, -1 };
		if(nums.length == 0) {
			return ans;
		}
		while (start <= end) {
			int mid = (start + end) / 2;

			if (nums[mid] == target) {
				// find pos
				int s =mid;
				while(s>=start && nums[s] ==target) {
					s--;
				}
				int e = mid;
				while(e<=end && nums[e] == target) {
					e++;
				}

				ans[0] = s+1;
				ans[1] = e-1;
				return ans;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}
}
