package com.java.think.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/17  下午4:44
 * @version: 1.0
 */
public class HashMapTest {

	private static ExecutorService executorService = Executors.newFixedThreadPool(20);


	public static void main(String[] args) {
		
		Map<String,Object> dataMap = new HashMap<>();

		testMapLoop(dataMap);
		Object v = dataMap.get("11");
		//System.out.println("==="+v.toString());


		System.out.println("*********"+v);
		System.out.println("*********"+dataMap.getOrDefault("35","0"));
	}



	public static void testMapLoop(Map<String,Object> dataMap){

		for (int j = 0;j< 10;j++) {
			executorService.submit(() -> {
				for (int i = 0; i < 1000; i++) {
					dataMap.put(i + "", "==" + i);
					System.out.println("================="+i);
				}
			});
		}

	}


}
