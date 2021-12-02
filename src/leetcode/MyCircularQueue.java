/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 10 Oct 2021 22:27:08
 */
public class MyCircularQueue {

	int size;
	int[] a;

	int head; // i, not a[i]
	int tail; // i, not a[i]
	int currSize;

	public MyCircularQueue(int k) {
		this.size = k;
		this.a = new int[k];
		this.head = -1;
		this.tail = -1;
		this.currSize = 0;
	}

	public boolean enQueue(int value) {
		if (currSize == size) {
			return false;
		}
		if (currSize == 0) {
			head = head +1;
		}
		tail = tail + 1;
		tail = tail % size;
		a[tail] = value;

		currSize++;

		return true;
	}

	public boolean deQueue() {
		if (currSize == 0) {
			return false;
		}
		int x = a[head];
		a[head] = 0;
		head = head + 1;
		head = head % size;

		currSize--;

		return true;
	}

	public int Front() {
		if (currSize == 0) {
			return -1;
		}
		return this.a[head];
	}

	public int Rear() {
		if (currSize == 0) {
			return -1;
		}
		return this.a[tail];
	}

	public boolean isEmpty() {
		return currSize == 0;
	}

	public boolean isFull() {
		return currSize == size;
	}

	public static void main(String[] args) {
//		int k = 3;
//		MyCircularQueue obj = new MyCircularQueue(3);
//		boolean x = obj.enQueue(1);
//		x = obj.enQueue(2);
//		x = obj.enQueue(3);
//		x = obj.enQueue(4);
//
//		int rear = obj.Rear();
//		boolean isFull = obj.isFull();
//		x = obj.deQueue();
//		x = obj.enQueue(4);
//		int front = obj.Front();
//		x = obj.deQueue();
//		rear = obj.Rear();

		int k = 81;
		MyCircularQueue obj = new MyCircularQueue(k);
		boolean x = obj.enQueue(69);
		x = obj.deQueue();
		x = obj.enQueue(92);
		x = obj.enQueue(12);
		x = obj.deQueue();
		x = obj.isFull();
		x = obj.isFull();
		int front = obj.Front();
		x = obj.deQueue();
//		
//		x = obj.enQueue(4);
//
//		int rear = obj.Rear();
//		boolean isFull = obj.isFull();
//		x = obj.deQueue();
//		x = obj.enQueue(4);
//		int front = obj.Front();
//		x = obj.deQueue();
//		rear = obj.Rear();
	}
}
