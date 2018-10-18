package com.junzixiehui.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/8/8  下午4:52
 * @version: 1.0
 */
public class AsyncTest {


	public static void main(String[] args) {


		Future future = new FutureTask(new Callable() {
			public Object call() throws Exception {
				System.out.println("call===");
				return 1;
			}
		});


		try {
			if(future.isDone()){
				System.out.println(future.get());
			} else {
				System.out.println("not done");
			}


			System.out.println(future.get());

		} catch (Exception e){
			e.printStackTrace();
		}


	}




}
