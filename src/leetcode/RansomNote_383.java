/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v0j008y 15 Sept 2021 12:49:51
 */
public class RansomNote_383 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String ransomNote = "a";
		String magazine = "ba";
		boolean ans = canConstruct(ransomNote, magazine);
		System.out.println(ans);
	}

	static boolean canConstruct(String ransomNote, String magazine) {

//      int[] a = new int[26];

//      for(int i=0; i<ransomNote.length(); i++) {
//          a[ransomNote.charAt(i) - 'a']++;
//      }

//      for(int i=0; i<magazine.length(); i++) {
//          a[magazine.charAt(i) - 'a']--;
//      }

//      for(int i=0; i<26; i++) {
//          if(a[i] > 0) {
//              return false;
//          }
//      }
//      return true;

		Map<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < ransomNote.length(); i++) {
			int v = 1;
			if (hm.containsKey(ransomNote.charAt(i))) {
				v += hm.get(ransomNote.charAt(i));
			}
			hm.put(ransomNote.charAt(i), v);
		}

		for (int i = 0; i < magazine.length(); i++) {
			if (hm.containsKey(magazine.charAt(i))) {
				hm.put(magazine.charAt(i), hm.get(magazine.charAt(i))-1);
			}
		}

		for (int v : hm.values()) {
			if (v > 0) {
				return false;
			}
		}
		return true;
	}
}
