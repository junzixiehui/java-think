package com.junzixiehui.jvm;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2021/1/17  6:15 PM
 * @version: 1.0
 */
public class VolatileTest {

	private static volatile int COUNTER = 0;

	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}

	static class ChangeListener extends Thread {

		@Override
		public void run() {
			int threadValue = COUNTER;
			while (threadValue < 5) {
				//System.out.println("COUNTER =  " + COUNTER + "");
				if (threadValue != COUNTER) {
					System.out.println("Got Change for COUNTER : " + COUNTER + "");
					threadValue = COUNTER;
				}
			}
		}
	}

	static class ChangeMaker extends Thread {

		@Override
		public void run() {
			int threadValue = COUNTER;
			while (COUNTER < 5) {
				System.out.println("Incrementing COUNTER to : " + (threadValue + 1) + "");
				COUNTER = ++threadValue;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) { e.printStackTrace(); }
			}
		}
	}


}
