package com.java.think.collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/1/18  3:21 PM
 * @version: 1.0
 */
public class CopyOnWriteListTest {



	public static void main(String[] args) {
		List<String> list = Lists.newCopyOnWriteArrayList();
		list.add("ddd");
		list.add("222");
		list.add("2111");

		Iterator iterator = list.iterator();
		while (iterator.hasNext()){
			final Object next = iterator.next();
			if (next.equals("ddd")){
				list.remove(next);
			}
		}
		System.out.println(list);
	}

}
