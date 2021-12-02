/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author v0j008y
 * 14 Sept 2021
 * 23:45:47
 */
public class PascalTriangle_118 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;
		generate(n);
	}
	
    static List<List<Integer>> generate(int n) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int[][] a = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    a[i][j] = 1;
                }
                else {
                    a[i][j] = a[i-1][j-1] + a[i-1][j];
                }
            }
            List<Integer> list = addToList(a,i,i);
            res.add(list);
        }
        return res;
    }
    
    static List<Integer> addToList(int[][] a, int r, int c) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=c; i++) {
            list.add(a[r][i]);
        }
        return list;
    }

}
