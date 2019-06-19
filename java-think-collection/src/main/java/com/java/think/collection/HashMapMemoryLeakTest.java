package com.java.think.collection;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.junzixiehui.common.object.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/17  下午4:44
 * @version: 1.0
 */
public class HashMapMemoryLeakTest {

	private static ExecutorService executorService = Executors.newFixedThreadPool(20);

	public static void main(String[] args) {


		Set<Object> set = Sets.newHashSet();

		Student student1 = new Student();
		student1.setAge(1);
		student1.setName("aa");

		Student student2 = new Student();
		student2.setAge(2);
		student2.setName("bb");

		Student student3 = new Student();
		student3.setAge(3);
		student3.setName("cc");

		set.add(student1);
		set.add(student2);
		set.add(student3);

		System.out.println(set.toString());

		student3.setAge(4);

		set.remove(student3);

		System.out.println(set.toString());

	}


}
