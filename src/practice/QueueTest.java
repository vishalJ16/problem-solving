/**
 * 
 */
package practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author v0j008y
 * 17 Sept 2021
 * 18:22:51
 */
public class QueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		q.add(2);
		
//		q.add(3);
		
		int size = q.size();
		for(int i=0; i<size-1; i++) {
			int x = q.remove();
			q.add(x);
		}
		
		System.out.println();
	}

}
