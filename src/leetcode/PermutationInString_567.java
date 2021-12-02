/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v0j008y 8 Sept 2021 12:46:38
 */
public class PermutationInString_567 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidbaooo";
		boolean ans = checkInclusion(s1, s2);
		System.out.println(ans);

	}

	static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}

		// count of each char in s1
		Map<Character, Integer> hm = new HashMap<>();
		for (char c : s1.toCharArray()) {
			int count = 1;
			if (hm.containsKey(c)) {
				count += hm.get(c);
			}
			hm.put(c, count);
		}

		Map<Character, Integer> temp = new HashMap<>();
		temp.putAll(hm);

		// in s2
		Map<Character, Integer> charLastPos = new HashMap<>();
		int lastPos = 0;

//		Map<Character, Integer> charMatchCountForLastPos = new HashMap<>();

		int charMatchCount = 0;
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);

			if (temp.containsKey(c)) {
				int count = temp.get(c);
				if (count > 0) {
					charMatchCount++;
					temp.put(c, count - 1);
				} else {
					lastPos = lastPos > charLastPos.get(c) ? lastPos : charLastPos.get(c);
//					char ch = s2.charAt(lastPos);
					charMatchCount = i - lastPos;
					temp.putAll(hm);
					for (int k = lastPos + 1; k <= i; k++) {
						char c1 = s2.charAt(k);
						if (temp.containsKey(c1)) {
							temp.put(c1, temp.get(c1) - 1);
						}
					}
				}
			} else {
				charMatchCount = 0;
				temp.putAll(hm);
			}

			if (charMatchCount == s1.length()) {
				return true;
			}
			charLastPos.put(c, i);
//			charMatchCountForLastPos.put(c, charMatchCount);
		}
		return false;
	}

}
