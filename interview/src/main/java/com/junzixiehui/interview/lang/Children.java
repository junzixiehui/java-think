package com.junzixiehui.interview.lang;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/7/2  15:58
 * @version: 1.0
 */
public class Children extends Parent{

	@Override
	public void test() {
		System.out.println("dddd");
	}

	public static void main(String[] args) {
		Children children = new Children();
		children.test();


		String status = "1";
		int i = 1;

		System.out.println();
		System.out.println(status.equals(i));
	}
}
