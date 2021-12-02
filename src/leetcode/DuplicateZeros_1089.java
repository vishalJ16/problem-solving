/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author v0j008y 3 Oct 2021 15:43:33
 */
public class DuplicateZeros_1089 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };
		duplicateZeros(arr);
		System.out.println();
	}

	static void duplicateZeros(int[] a) {
		int n = a.length;
		int[] b = new int[n];

		int i = 0;
		int j = 0;

		while (i < n && j < n) {
			if (a[i] == 0) {
				b[j] = 0;
				j++;
				if (j < n) {
					b[j] = 0;
				}
			} else {
				b[j] = a[i];
			}
			i++;
			j++;
		}

		for (i = 0; i < n; i++) {
			a[i] = b[i];
		}
	}

//    static void duplicateZeros(int[] a) {
//        Queue<Integer> q = new LinkedList<>();
//        
//        for(int i=0; i<a.length; i++) {
//            q.add(a[i]);
//            
//            if(a[i] == 0) {
//                q.add(0);
//            }
//            a[i] = q.poll();
//        }
//    }

//    public void duplicateZeros(int[] a) {
//		int i = 0;
//		int zeroCount = 0;
//		while (i < a.length) {
//			if (a[i] == 0) {
//				zeroCount++;
//				i++;
//			} else if (zeroCount == 0) {
//				i++;
//			} else {
//				// a[i] != 0
//				int last = a.length - 1;
//				for (int x = a.length - 1 - zeroCount; x >= i; x--) {
//					a[last] = a[x];
//					last--;
//				}
//				while (i < a.length && zeroCount > 0) {
//					a[i] = 0;
//					i++;
//					zeroCount--;
//				}
//			}
//		}
//	}
//    
//	public void duplicateZeros(int[] a) {
//		Queue<Integer> q = new LinkedList<>();
//		int i = 0;
//		int zeroCount = 0;
//		while (i < a.length) {
//			int x = i;
//			while (!q.isEmpty()) {
//				a[x] = q.poll();
//				x++;
//			}
//			if (a[i] == 0) {
//				zeroCount++;
//				i++;
//			} else if (zeroCount == 0) {
//				i++;
//			} else {
//				// a[i] != 0
//				x = i;
//				while (x < a.length - zeroCount) {
//					q.add(a[x]);
//					x++;
//				}
//				while (i<a.length && zeroCount > 0) {
//					a[i] = 0;
//					i++;
//					zeroCount--;
//				}
//			}
//		}
//	}
}
