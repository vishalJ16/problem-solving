/**
 * 
 */
package practice;

/**
 * @author v0j008y
 * 10 Sept 2021
 * 23:52:56
 */
public class ReverseStringPrint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "vishal";
		reverse(s);
	}
	
	static void reverse(String s) {
		if(s == null)
			return;
		reverse(s.toCharArray(), 0);
	}

	static void reverse(char[] a, int index) {
		if(index == a.length) {
			return;
		}
		reverse(a, index+1);
		System.out.println(a[index]);
	}
}
