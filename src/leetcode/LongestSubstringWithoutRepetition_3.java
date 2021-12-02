/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v0j008y
 * 7 Sept 2021
 * 22:59:03
 */
public class LongestSubstringWithoutRepetition_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abba";
		System.out.println(longestSubstring(s));
	}

    static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> hm = new HashMap<>();
        int count = 0;
        int max = 0;
        int lastRepeatedCharPos = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(hm.containsKey(c)) {
                if(count > max ){
                    max = count;
                }
                lastRepeatedCharPos = lastRepeatedCharPos > hm.get(c) ? lastRepeatedCharPos : hm.get(c);
                count = i-lastRepeatedCharPos;
            }
            else {
                count++;
            }
            hm.put(c,i);
        }
        return max > count ? max : count;
    }
    
    static int longestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int cur = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) { // if char has appeared.
                int length = i - map.get(s.charAt(i)); // we get the length between last_char and cur_char. 
                if(length > cur) {
                    cur++; // Case #1.
                }else {
                    cur = length; // Case #2.
                }
            }else { 
                cur++; // if char never appear before, we just add 1 length.
            }
            map.put(s.charAt(i), i); // update char index.
            if(cur > res) res = cur;
        }
        return res;
    }
}
