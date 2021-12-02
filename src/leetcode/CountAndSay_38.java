/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 1 Sept 2021
 * 01:27:05
 */
public class CountAndSay_38 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 6;
		System.out.println(countAndSay(n));
	}
	
    static String countAndSay(int n) {
        if(n==1) {
            return "1";
        }
        return say(countAndSay(n-1));
    }
    
    static String say(String s) {
        // int n = Integer.valueOf(s);
        int count = 1;
        String ans = "";
        int n = s.length();
        if(n == 1) {
            return "1"+s;
        }
        for(int i=1; i<n; i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                count++;
            }
            else {
                ans += String.valueOf(count)+s.charAt(i-1);
                count = 1;
            }
        }
        if(s.charAt(n-2) != s.charAt(n-1)) {
            ans += "1"+s.charAt(n-1);
        }
        else {
            ans += String.valueOf(count)+s.charAt(n-1);
        }
        return ans;
    }

}
