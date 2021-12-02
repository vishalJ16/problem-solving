/**
 * 
 */
package leetcode;

import java.util.List;

/**
 * @author v0j008y
 * 1 Sept 2021
 * 23:37:30
 */
public class Util {

	
	static <T> void print(List<T> list) {
		for(T e : list) {
			System.out.print(e + ", ");
		}
	}
	
	static <T> void printArr(T arr[]) {
		for(T e : arr) {
			System.out.print(e + ", ");
		}
	}
}
