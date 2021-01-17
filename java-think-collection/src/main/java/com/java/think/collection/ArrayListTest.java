package com.java.think.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/4/11  12:55 PM
 * @version: 1.0
 */
public class ArrayListTest {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		list.add(0);
		list.add(1);
		list.add(2);

		list.remove(1);

		int h = list.hashCode();
		int h1 = h >>> 16;
		int h2 = h ^ h1;


		System.out.println(h2);
	}

}
