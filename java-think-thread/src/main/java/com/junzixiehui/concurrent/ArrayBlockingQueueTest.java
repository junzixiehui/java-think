package com.junzixiehui.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/10/22  17:03
 * @version: 1.0
 */
public class ArrayBlockingQueueTest {

	public static void main(String[] args) throws Exception {

		ArrayBlockingQueue queue = new ArrayBlockingQueue(1);
		queue.put("a");
		queue.put("b");
		queue.put("c");

		final Object c = queue.take();
		final Object b = queue.take();
		final Object a = queue.take();
	}
}
