/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author v0j008y
 * 5 Sept 2021
 * 23:04:04
 */
public class ReverseString_344 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char s[] = {'h','e','l','l','o'};
		reverseString(s);
		System.out.println();
		
		List<String> l1 = new ArrayList();
		List<String> l2 = new ArrayList();
		l1.add("apple");
		l2 = l1;
		l2.add("mango");
		l2 = new ArrayList<String>();
		l2 = null;
		System.out.println();
	}

    static void reverseString(char[] s) {
        
        int start = 0;
        int end = s.length-1;
        
        reverse(s,start,end);
    }
    
    static void reverse(char[] s, int i, int j) {
        if(i >= j) {
            return;
        }
        if(j-i == 1) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        reverse(s,i+1,j-1);
    }
}
