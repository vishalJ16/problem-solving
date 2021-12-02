/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author v0j008y 12 Sept 2021 17:15:29
 */
public class Permutations_46 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		permute(nums);
		System.out.println();
	}

	static List<List<Integer>> res = new ArrayList<>();

	static List<List<Integer>> permute(int[] nums) {
		permute(nums.length, 0, nums);
		return res;
	}

	static void permute(int n, int ind, int[] nums) {
		if (ind == n) {
			List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
			res.add(new ArrayList<>(list));
			return;
		}

		for (int i = ind; i < n; i++) {
			swap(nums, i, ind);
//            list.add(nums[i]);
			permute(n, ind + 1, nums);
//            list.remove(list.size()-1);
			swap(nums, i, ind);
		}
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	
    public List<List<Integer>> permute2(int[] nums) {
        int[] visited = new int[nums.length];
        permute2(nums.length, nums,visited, new ArrayList<>());
        return res;
    }
    
    public void permute2(int n, int[] nums, int[] visited, List<Integer> temp) {
        if(temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                int idx = temp.size();
                temp.add(nums[i]);
                permute2(n, nums, visited, temp);
                temp.remove(idx);
                visited[i] = 0;
            }
        }
        
    }

}
