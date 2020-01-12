package com.junzixiehui.thread.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/7/12  11:36
 * @version: 1.0
 */
public class TestHystrix extends HystrixCommand<String> {

	protected TestHystrix(HystrixCommandGroupKey group) {
		super(group);
	}

	protected String run() throws Exception {
		System.out.println("具体逻辑");
		Thread.sleep(200);
		return null;
	}

	public static void main(String[] args) {
		TestHystrix testHystrix = new TestHystrix(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
		testHystrix.execute();
	}
}
