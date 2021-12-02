/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author v0j008y 11 Nov 2021 20:46:40
 */
public class WordLadder_127 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
		WordLadder_127 o = new WordLadder_127();
		int ans = o.ladderLength(beginWord, endWord, wordList);
		System.out.println(ans);
	}

	int min = Integer.MAX_VALUE;
	Set<String> wordSet;

	int outerLoop;
	int recursiveCall;

	public int ladderLength(String beginWord, String endWord, String[] wordList) {

		long start = System.nanoTime();
		int ans = 0;

		Set<String> set = new HashSet<>();
		for (String s : wordList) {
			set.add(s);
		}
		wordSet = set;
		if (wordSet.contains(endWord)) {
			transform(beginWord.toCharArray(), endWord, 1);
		}

		System.out.println("ladderLength time: " + (System.nanoTime() - start));
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public void transform(char[] start, String end, int count) {
		// 23/49 tc passed...remaining TLE
		String s = String.valueOf(start);
//		System.out.println(s);
		if (s.equals(end)) {
			if (count < min) {
				min = count;
			}
			return;
		}

		if (wordSet.size() == 0) {
			min = -1;
			return;
		}

		for (int i = 0; i < start.length; i++) {
			char c = start[i];
			char temp = c;
			for (int j = 'a'; j <= 'z'; j++) {
//				System.out.println("outerloop: " + ++outerLoop);
				if (j != c) {
					start[i] = (char) j;
					String curr = String.valueOf(start);
					if (wordSet.contains(curr)) {
//						System.out.println("recursiveCall: " + ++recursiveCall);
						wordSet.remove(curr);
						transform(start, end, count + 1);
						wordSet.add(curr);
					}
					start[i] = temp;
				}
			}
		}
	}

//	==========================Approach -2 =====================================

	Map<String, List<String>> patternMap;

	public int ladderLength2(String beginWord, String endWord, String[] wordList) {

		long start = System.nanoTime();
		int ans = 0;

		Set<String> set = new HashSet<>();
		for (String s : wordList) {
			set.add(s);
		}
		wordSet = set;

		Map<String, List<String>> hm = new HashMap<>();
		for (String s : wordList) {
			char[] ch = s.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				char temp = ch[i];
				ch[i] = '*';
				String pattern = String.valueOf(ch);
				List<String> list = hm.getOrDefault(pattern, new ArrayList<>());
				list.add(s);
				hm.put(pattern, list);
				ch[i] = temp;
			}
		}
		patternMap = hm;
		if (wordSet.contains(endWord)) {
			transform2(beginWord.toCharArray(), endWord, 1);
		}

		System.out.println("ladderLength time: " + (System.nanoTime() - start));
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public void transform2(char[] start, String end, int count) {
		String s = String.valueOf(start);
		if (s.equals(end)) {
			if (count < min) {
				min = count;
			}
			return;
		}

		if (wordSet.size() == 0) {
			min = -1;
			return;
		}

		for (int i = 0; i < start.length; i++) {
			char temp = start[i];
			start[i] = '*';
			String word = String.valueOf(start);
			if (patternMap.containsKey(word)) {
				for (String str : patternMap.get(word)) {
					if (wordSet.contains(str)) {
						wordSet.remove(str);
						transform2(str.toCharArray(), end, count + 1);
						wordSet.add(str);
					}
				}
			}
			start[i] = temp;
		}
	}

//	=====================================================================
	// didn't see,I solved it with notion as every subsequent word would differ by
	// either +1 or -1 in char pos.

//    int min = Integer.MAX_VALUE;
//    Set<String> wordSet;
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        
//        int ans = 0;
//        
//        Set<String> set = new HashSet<>();
//        for(String s : wordList) {
//            set.add(s);
//        }
//        wordSet = set;
//        if(wordSet.contains(endWord)) {
//            transform(beginWord.toCharArray(), endWord, 0);
//        }
//        
//        return min;
//    }
//    
//    public void transform2(char[] start, String end, int count) {
//    	
//    	String s = String.valueOf(start);
//        if(s.equals(end)) {
//            if(count < min) {
//                min = count;
//            }
//            return;
//        }
//        
//        if(wordSet.size() == 0) {
//            min = -1;
//            return;
//        }
//        
//        for(int i=0; i<start.length; i++) {
//            char c = start[i];
//            char temp = c;
//            // c == 'a' ? 'A' : c-1;
//            
//            if(c != 'a') {
//            start[i] = (char)(c-1);
//            String curr = String.valueOf(start);
//            if(wordSet.contains(curr)) {
//                wordSet.remove(curr);
//                transform(start, end, count+1);
//                wordSet.add(curr);
//            }
//                start[i] = temp;
//            }
//            
//            // c == 'z' ? 'Z' : c+1;
//            if(c != 'z') {
//                start[i] = (char)(c+1);
//                String curr = String.valueOf(start);
//                if(wordSet.contains(curr)) {
//                    wordSet.remove(curr);
//                    transform(start, end, count+1);
//                    wordSet.add(curr);
//                }
//                start[i] = temp;
//            }
//        }
//    }
}
