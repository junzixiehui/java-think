package com.junzixiehui.thread;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/8/8  下午2:43
 * @version: 1.0
 */
public class ExectorTest {

	static int b = 2;
	//step.2
	static {
		b = 3;
	}

	public static void main(String[] args) {
		ExectorTest s = new ExectorTest();
		System.out.println(s.b);
		//b=3
	}

}
