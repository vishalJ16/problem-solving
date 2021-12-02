/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 10 Oct 2021
 * 03:11:11
 */
public class ZigZagConversion_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 4;
		String ans = convert(s, numRows);
		System.out.println(ans);
	}

    static String convert(String s, int numRows) {
        StringBuilder[] sbArr = new StringBuilder[numRows];
        
        for(int i=0; i<numRows; i++) {
            sbArr[i] = new StringBuilder();
            
        }
        
        int k = 0;
        boolean down = false;
        for(int i=0; i<s.length(); i++) {
        	sbArr[k].append(s.charAt(i));
            if(k == numRows-1 || k == 0) {
                down = !down;
            }
            
            k += down ? 1 : -1;
        }
        
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : sbArr) {
            res.append(sb.toString());
        }
        
        return res.toString();
    }
}
