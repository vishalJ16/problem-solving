/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author v0j008y 11 Oct 2021 01:13:36
 */
public class OpenTheLock_752 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OpenTheLock_752 obj = new OpenTheLock_752();

		String target = "0202";
		String[] deadends = new String[] { "2000" };

		int ans = obj.openLock(deadends, target);
		System.out.println(ans);
	}

	int min = Integer.MAX_VALUE;
	Set<String> visited = new HashSet<>();

	public int openLock(String[] deadends, String target) {

		for (String s : deadends) {
			visited.add(s);
		}

		int count = 0;
		Queue<String> q = new LinkedList<>();
		q.add("0000");
		while (!q.isEmpty()) {
			int sz = q.size();

			while (sz > 0) {
				String curr = q.poll();
				if (!visited.contains(curr)) {
					if (curr.equals(target)) {
						return count;
					}
					getAllNextStates(curr, q, visited);
					visited.add(curr);
				}
				sz--;
			}
			count++;
		}

		return -1;
	}

	void getAllNextStates(String curr, Queue<String> q, Set<String> visited) {
		char[] ch = curr.toCharArray();
		for (int i = 0; i < curr.length(); i++) {
			char c = ch[i];

			ch[i] = ch[i] == '0' ? '9' : (char) (c - 1);
			String s = new String(ch);
			if (!visited.contains(s)) {
				q.add(s);
			}

			ch[i] = c;
			ch[i] = ch[i] == '9' ? '0' : (char) (c + 1);
			s = new String(ch);
			if (!visited.contains(s)) {
				q.add(s);
			}
			ch[i] = c;
		}
	}

	public int openLockWrong(String[] deadends, String target) {

		Set<String> set = new HashSet<>();
		for (String s : deadends) {
			set.add(s);
		}
		count(target, set, "0000", 0);

		return min == Integer.MAX_VALUE ? -1 : min;
	}

	void count(String target, Set<String> set, String curr, int count) {
		/*
		 * This approach is wrong. The reason being - I am recursively calling it with
		 * one char changing...and going into depth. Rather I should generate all
		 * possible next state from current and then proceed. So, from curr string we
		 * can have 8 possibilities, and then pick one of them and generate next 8 and
		 * so on. For e.g.curr=0000; next can be =
		 * 0001,0010,0100,1000,0009,0090,0900,9000
		 */
		if (set.contains(curr)) {
			return;
		}
		if (visited.contains(curr)) {
			return;
		}
		if (curr.equals(target)) {
			min = count < min ? count : min;
			return;
		}

		visited.add(curr);
		for (int i = 0; i < curr.length(); i++) {
			char c = curr.charAt(i);
			c = c == '0' ? '9' : (char) (c - 1);
			curr = curr.substring(0, i) + c + curr.substring(i + 1);
			count(target, set, curr, count + 1);

			c = c == '9' ? '1' : (char) (c + 1);
			curr = curr.substring(0, i) + c + curr.substring(i + 1);
			count(target, set, curr, count + 1);
		}
//		visited.remove(curr);
	}

}
