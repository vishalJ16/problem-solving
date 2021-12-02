/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author v0j008y 15 Sept 2021 14:39:17
 */
public class RottingOranges_994 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
//		int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
//		int[][] grid = {{0,2}};
		int[][] grid = { { 2, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		int count = orangesRotting(grid);
		System.out.println(count);
	}

	static int orangesRotting(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		int time = 0;
		int freshOrangesCount = 0;
		Queue<Cell> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					Cell cell = new Cell(i, j);
					q.add(cell);
				} else if (grid[i][j] == 1) {
					freshOrangesCount++;
				}
			}
		}

		while (!q.isEmpty() && freshOrangesCount > 0) {
			time++;

			int sz = q.size();
			while (sz > 0) {
				sz--;
				Cell cell = q.poll();

				freshOrangesCount = mark(grid, m, n, cell.x, cell.y - 1, freshOrangesCount, q);
				freshOrangesCount = mark(grid, m, n, cell.x, cell.y + 1, freshOrangesCount, q);
				freshOrangesCount = mark(grid, m, n, cell.x + 1, cell.y, freshOrangesCount, q);
				freshOrangesCount = mark(grid, m, n, cell.x - 1, cell.y, freshOrangesCount, q);
			}
		}

		return freshOrangesCount == 0 ? time : -1;
	}

	static int mark(int[][] grid, int m, int n, int i, int j, int freshOrangesCount, Queue<Cell> q) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return freshOrangesCount;
		}
		if (grid[i][j] != 0 && grid[i][j] != 2) {
			grid[i][j] = 2;
			Cell cell = new Cell(i, j);
			q.add(cell);
			freshOrangesCount--;
		}
		return freshOrangesCount;
	}

	static class Cell {
		int x;
		int y;

		Cell(int i, int j) {
			this.x = i;
			this.y = j;
		}
	}

	static int M;
	static int N;
	static int[][] visited = new int[M][N];

	static int orangesRottingIncorrect(int[][] grid) {
		/*
		 * This solution won't work. The problem is - I am iterating from [0,0] row-wise
		 * and column-wise....but what if a cell gets "2" after you have already
		 * processed it as a source cell? For e.g. 1st row had all 1s, and first element
		 * of 2nd row was "2". So when you iterate over first row, your count does not
		 * increase. But when you reach 1st cell of 2nd row, [0,0] cell gets "2" , and
		 * then whole has potential to get "2". But this code is not processing it.SO it
		 * fails here.
		 *
		 * Correct way to approach is - add newly converted "2" cells to the queue, and
		 * check if cells adjacent to this cell can get "2" or not.
		 */
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		M = m;
		N = n;
		visited = new int[M][N];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] != 1 && grid[i][j] == 2) {
//					count++;
					boolean areNewMarked = mark(grid, m, n, i, j);
					if (areNewMarked) {
						count++;
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0 && grid[i][j] != 2) {
					return -1;
				}
			}
		}
		return count;
	}

	static boolean mark(int[][] grid, int m, int n, int x, int y) {
		boolean ans = false;
		for (int j = y; j < n; j++) {
			if (visited[x][j] != 1 && grid[x][j] == 2) {
				ans = markRotten(grid, m, n, x, j - 1) || ans;
				ans = markRotten(grid, m, n, x, j + 1) || ans;
				ans = markRotten(grid, m, n, x + 1, j) || ans;
				ans = markRotten(grid, m, n, x - 1, j) || ans;
			}
		}
		for (int i = x + 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] != 1 && grid[i][j] == 2) {
					ans = markRotten(grid, m, n, i, j - 1) || ans;
					ans = markRotten(grid, m, n, i, j + 1) || ans;
					ans = markRotten(grid, m, n, i + 1, j) || ans;
					ans = markRotten(grid, m, n, i - 1, j) || ans;
				}
			}
		}
		visited = new int[m][n];
		return ans;
	}

	static boolean markRotten(int[][] grid, int m, int n, int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return false;
		}
		if (grid[i][j] != 0 && grid[i][j] != 2) {
			grid[i][j] = 2;
//			visited[i][j] = 1;
			return true;
		}

		return false;
	}
}
