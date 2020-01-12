package com.junzixiehui.algorithm.queue;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/7/12  15:16
 * @version: 1.0
 */
public class QueueImp {

	Object objArr[] = null;
	private int head = 0;
	private int tail = 0;

	public QueueImp(int capacity) {
		objArr = new Object[capacity];
	}

	public void push(Object obj) {
		if (tail == objArr.length - 1) {
			return;
		}
		objArr[tail] = obj;
		tail++;
	}

	public Object pop() {
		if (tail == head) {
			return null;
		}
		Object obj = objArr[head];
		head++;
		return obj;
	}

	public static void main(String[] args) {
		QueueImp queue = new QueueImp(5);
		queue.push("aaa");
		queue.push("bbb");
		queue.push("ccc");
		queue.push("ccc");
		queue.push("ccc");
		queue.push("ccc");
		queue.push("ccc");

		final Object pop = queue.pop();

		System.out.println(pop);
	}
}
