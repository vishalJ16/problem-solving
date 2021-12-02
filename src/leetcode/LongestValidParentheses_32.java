/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author v0j008y
 * 9 Oct 2021
 * 01:27:57
 */
public class LongestValidParentheses_32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "(()";
		s = "()(())";
		int ans = longestValidP(s);
		System.out.println(ans);
	}
	
    static int longestValidParentheses(String s) {
        
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int count = 0;
        int openCount = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.add(c);
                openCount++;
            }
            else { // c == )
                while(openCount>0 && !stack.isEmpty()) {
                    stack.pop();
                    count += 2;
                    openCount--;
                }
                max = count > max ? count : max;
                if(openCount != 0) {
                    // stack is empty...
                    // This implies you encountered closed bracket and there is no open bracket yet, so invalid.
                    count = 0;
                    openCount = 0;
                }
            }
        }
        return max;
    }
    
   static int longestValidP(String s) {
        
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int count = 0;
        
        int prevInd = -1;
        int prevCount = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                prevInd = i-1;
                break;
            }
        }
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.add(c);
            }
            else { // c == )
                if(!stack.isEmpty()) {
                    stack.pop();
                    count += 2;
                    if(prevInd + count == i) {
                        count += prevCount;
                        prevCount = count;
                        prevInd = i;
                    }
//                    else {
//                        prevCount = 0;
//                        prevInd = i;
//                    }
                }
                max = count > max ? count : max;
                if(stack.isEmpty()) {
                    // stack is empty...
                    // This implies you encountered closed bracket and there is no open bracket yet, so invalid.
                    count = 0;
                }
            }
        }
        return max;
    }

}
