package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author v0j008y 11 Nov 2021 12:48:40
 */
public class TripletSum_15 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] nums = { -1, 0, 1, 2, -1, -4, 5, -6, 5, 6 };
		int[] nums = { -1, 0, 1, 2, -1, -4};
		TripletSum_15 o = new TripletSum_15();
		List<List<Integer>> res = o.threeSum(nums);
		res = o.tripletSum(nums);
		System.out.println();
	}

	public List<List<Integer>> threeSum(int[] nums) {
		// approach -1
		// 315/318 tc passed....remaining 3 TLE

		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < n; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				for (int k = j + 1; k < n; k++) {
					if (k > j + 1 && nums[k] == nums[k - 1]) {
						continue;
					}
					if (i != j && i != k && j != k) {
						if (nums[i] + nums[j] + nums[k] == 0) {
							List<Integer> curr = new ArrayList<>();
							curr.add(nums[i]);
							curr.add(nums[j]);
							curr.add(nums[k]);
							res.add(curr);
						}
					}
				}
			}
		}
		return res;
	}

	public List<List<Integer>> tripletSum(int[] nums) {
		// approach 2

		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		// (nums[i], list of indexes)
		HashMap<Integer, List<Integer>> hm = new HashMap<>();
//		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < n; i++) {

//			hm.put(nums[i], i);
			List<Integer> indexes = hm.getOrDefault(nums[i], new ArrayList<>());
			indexes.add(i);
			hm.put(nums[i], indexes);
		}

//		int i=0;
		for (int j = 1; j < n; j++) {
			if (j > 1 && nums[j] == nums[j - 1]) {
				continue;
			}
			for (int k = j + 1; k < n; k++) {
				if (k > j + 1 && nums[k] == nums[k - 1]) {
					continue;
				}
				int sum = nums[j] + nums[k];

				if (hm.containsKey(-sum)) {
					List<Integer> list = hm.get(-sum);
					for(int ind : list) {
						if(ind <j && ind <k) {
							List<Integer> curr = new ArrayList<>();
							curr.add(-sum);
							curr.add(nums[j]);
							curr.add(nums[k]);
							res.add(curr);
							break;
						}
					}
//					if (hm.get(-sum) != j && hm.get(-sum) != k) {
//						List<Integer> curr = new ArrayList<>();
//						curr.add(-sum);
//						curr.add(nums[j]);
//						curr.add(nums[k]);
//						res.add(curr);
//					}
////					
//					boolean canForm = false;
//					List<Integer> indexes = hm.get(-sum);
//					for (int ind : indexes) {
//						if(ind !=j && ind!= k) {
//							canForm = true;
//							break;
//						}
////						if (ind < j) {
////							canForm = true;
////							break;
////						}
////						if (ind >= j) {
////							break;
////						}
//					}
//					if (canForm) {
//						List<Integer> curr = new ArrayList<>();
//						curr.add(-sum);
//						curr.add(nums[j]);
//						curr.add(nums[k]);
//						res.add(curr);
//					}
				}
			}
		}
		return res;
//      Set<Integer> set = new HashSet<>();
//      for(int i=0; i<n; i++) {
//          for(int j=i+1; j<n; j++) {
//              set.add(nums[i]+nums[j]);
//          }
//      }

//      for(int i=0; i<n; i++) {

//      }
	}
}
