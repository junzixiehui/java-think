package com.junzixiehui.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/1/16  15:37
 * @version: 1.0
 */
public class LinkedBlockingQueueTest {

	public static void main(String[] args) {
		LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

		linkedBlockingQueue.add("11");
		linkedBlockingQueue.add("22");
		linkedBlockingQueue.add("33");

		try {
			for (int i = 0; i < 4; i++) {
				final Object take = linkedBlockingQueue.poll();
				System.out.println(take);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
