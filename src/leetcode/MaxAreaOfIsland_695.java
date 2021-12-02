/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 9 Sept 2021 00:02:35
 */
public class MaxAreaOfIsland_695 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		int ans = maxAreaOfIsland(grid);
		System.out.println(ans);
	}

	static int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int count = dfs(grid, i, j, grid.length, grid[0].length);
					max = count > max ? count : max;
				}
			}
		}
		return max;
	}

	static int dfs(int[][] a, int i, int j, int m, int n) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return 0;
		}
		if (a[i][j] != 1) {
			return 0;
		}
		a[i][j] = -1;
		int count = 1;
		count += dfs(a, i + 1, j, m, n);
		count += dfs(a, i - 1, j, m, n);
		count += dfs(a, i, j + 1, m, n);
		count += dfs(a, i, j - 1, m, n);

		a[i][j] = 1;
		return count;
	}

}
