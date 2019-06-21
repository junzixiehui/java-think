package com.junzixiehui.jvm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/6/20  13:58
 * @version: 1.0
 */
public class JvmTest {

	public static void main(String[] args) throws IOException {

		Thread t = new DemoThread();
		// 启动线程
		t.start();
		System.in.read();
	}

	static class DemoThread extends Thread {

		@Override
		public void run() {
			try {
				TimeUnit.HOURS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
