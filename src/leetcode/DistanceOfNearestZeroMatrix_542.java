/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 9 Sept 2021 23:27:38
 */
public class DistanceOfNearestZeroMatrix_542 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

		int[][] mat = { { 0 }, { 0 }, { 0 }, { 0 }, { 0 } };

//		int[][] mat = { { 1, 1, 0, 0, 1, 0, 0, 1, 1, 0 }, { 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
//				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//				{ 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 } };

		long start = System.currentTimeMillis();
		int[][] res = updateMatrix3(mat);
		System.out.println(res);
		System.out.println("Time taken in millis: " + (System.currentTimeMillis() - start));
		print(res);
	}

	static int[][] updateMatrix(int[][] mat) {

		int[][] res = new int[mat.length][mat[0].length];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] != 0) {
					res[i][j] = find(mat, i, j, 0);
				}
			}
		}
		return res;
	}

	static int find(int[][] a, int i, int j, int count) {
		if (i < 0 || j < 0 || i >= a.length || j >= a[0].length) {
			return Integer.MAX_VALUE;
		}
		if (a[i][j] == 0) {
			return count;
		}
		int min = Integer.MAX_VALUE;
		if (a[i][j] != -1) {
			int temp = a[i][j];
			a[i][j] = -1;
			min = min(find(a, i + 1, j, count + 1), find(a, i - 1, j, count + 1), find(a, i, j + 1, count + 1),
					find(a, i, j - 1, count + 1));
			a[i][j] = temp;
		}
		return min;
	}

	static int min(int a, int b, int c, int d) {
		int min = a < b ? a : b;
		min = c < min ? c : min;
		min = d < min ? d : min;
		return min;
	}

	static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + ", ");
			}
			System.out.println();
		}
	}

	static int[][] updateMatrixUsingDP(int[][] mat) {

		int[][] res = new int[mat.length][mat[0].length];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] != 0) {
					res[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] != 0) {
					res[i][j] = findDP(mat, i, j, 0, res);
				}
			}
		}
		return res;
	}

	static int findDP(int[][] a, int i, int j, int count, int[][] res) {
		if (i < 0 || j < 0 || i >= a.length || j >= a[0].length) {
			return Integer.MAX_VALUE;
		}
		if (a[i][j] == 0) {
			return count;
		}
		if (res[i][j] != -1 && res[i][j] != Integer.MAX_VALUE) {
			return res[i][j];
		}
		int min = Integer.MAX_VALUE;
		if (a[i][j] != -1) {
			int temp = a[i][j];
			a[i][j] = -1;
			min = min(findDP(a, i + 1, j, count + 1, res), findDP(a, i - 1, j, count + 1, res),
					findDP(a, i, j + 1, count + 1, res), findDP(a, i, j - 1, count + 1, res));
			res[i][j] = min;
			a[i][j] = temp;
		}
		return min;

	}

//	=====================SOLUTION-3==========================
	static int[][] updateMatrix3(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] res = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = Integer.MAX_VALUE - 1;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					res[i][j] = 0;
				} else {
					if (i > 0) {
						res[i][j] = Math.min(res[i - 1][j] + 1, res[i][j]);
					}
					if (j > 0) {
						res[i][j] = Math.min(res[i][j - 1] + 1, res[i][j]);
					}
				}
			}
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (mat[i][j] == 0) {
					res[i][j] = 0;
				} else {
					if (i < m - 1) {
						res[i][j] = Math.min(res[i + 1][j] + 1, res[i][j]);
					}
					if (j < n - 1) {
						res[i][j] = Math.min(res[i][j + 1] + 1, res[i][j]);
					}
				}
			}
		}

		return res;
	}
}
