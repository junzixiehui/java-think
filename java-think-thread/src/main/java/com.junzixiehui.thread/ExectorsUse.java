package com.junzixiehui.thread;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/8/8  下午2:47
 * @version: 1.0
 */
public class ExectorsUse {




	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		List<String> partitionList = Lists.newArrayList("4","9","2");

		for (int i = 1;i < 100;i++){
			partitionList.add("6");
		}

		try {
			for (final String partition : partitionList){
				executorService.submit(new Runnable() {
					public void run() {
						try {
							Thread.sleep(Integer.valueOf(partition) * 1000);
							System.out.println("===="+partition);
						} catch (Exception e){
							e.printStackTrace();
						}

					}
				});
			}

			System.out.println("end1....");

		} finally {
			System.out.println("end2....");

			if (!executorService.isShutdown()){
				executorService.shutdown();
			}
			System.out.println("end3....");

		}




	}

	public void send(String str) throws Exception{
		Thread.sleep(Integer.valueOf(str) * 1000);
		System.out.println("===="+str);
	}





}
