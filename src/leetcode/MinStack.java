/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author v0j008y 11 Oct 2021 15:59:53
 */
class MinStack {

	List<Integer> list;
	int top;

	int min;

	public MinStack() {
		list = new ArrayList<>();
		min = Integer.MAX_VALUE;
	}

	public void push(int val) {
		list.add(val);
		top = val;

		min = val < min ? val : min;
	}

	public void pop() {
		if (list.size() != 0) {
			int x = list.remove(list.size() - 1);

			// update top
			if (list.size() > 0) {
				top = list.get(list.size() - 1);
				// update min
				if (x == min) {
					min = Integer.MAX_VALUE;
					for (int i : list) {
						min = i < min ? i : min;
					}
				}
			} else {
				min = Integer.MAX_VALUE;
			}
		}
	}

	public int top() {
		return top;
	}

	public int getMin() {
		return min;
	}

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(val);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
	public static void main(String[] args) {
		
//		MinStack obj = new MinStack();
//		obj.push(-2);
//		obj.push(0);
//		obj.push(-3);
//		int param_4 = obj.getMin();
//		obj.pop();
//		int param_3 = obj.top();
//		param_4 = obj.getMin();
		
		
		MinStack obj = new MinStack();
		obj.push(2147483646);
		obj.push(2147483646);
		obj.push(2147483647);
		int param_3 = obj.top();
		obj.pop();
		int param_4 = obj.getMin();
		obj.pop();
		param_4 = obj.getMin();
		obj.pop();
		obj.push(2147483647);
		param_3 = obj.top();
		param_4 = obj.getMin();
		obj.push(-2147483648);
		param_3 = obj.top();
		param_4 = obj.getMin();
		obj.pop();
		param_4 = obj.getMin();
		
	}
}
