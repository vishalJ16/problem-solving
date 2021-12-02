/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 8 Sept 2021
 * 23:24:25
 */
public class FloodFill_733 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = {{0,0,0},{0,1,1}};
		int sr = 1;
		int sc = 1;
		int newColor = 1;
		floodFill(a, sr, sc, newColor);
		System.out.println();
	}
	
    static int[][] floodFill(int[][] a, int sr, int sc, int newColor) {
        dfs(a, sr,sc,a.length, a[0].length, a[sr][sc],newColor);
        return a;
    }
    
    static void dfs(int[][] a, int i, int j, int m, int n, int value, int c) {
        if(i<0 || j<0 || i>=m || j>=n) {
            return;
        }
        if(a[i][j] == value) {
            a[i][j] = -1;
            dfs(a, i+1, j, m, n, value, c);
            dfs(a, i-1, j, m, n, value, c);
            dfs(a, i, j+1, m, n, value, c);
            dfs(a, i, j-1, m, n, value, c);
            a[i][j] = c;
        }
    }

}
