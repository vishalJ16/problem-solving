/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 27 Sept 2021
 * 22:43:25
 */
public class AssignCookies_455 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] g = {1,2};
		int[] s = {1,2,3};
		int ans = findContentChildren(g, s);
		System.out.println(ans);
	}
	
    static int findContentChildren(int[] g, int[] s) {
        
        int count = 0;
        for(int i=0,j=0; i<s.length && j<g.length; i++,j++) {
            if(s[i] >= g[j]) {
                count++;
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        return count;
    }

}
