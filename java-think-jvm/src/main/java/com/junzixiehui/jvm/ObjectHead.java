package com.junzixiehui.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/1/12  5:18 PM
 * @version: 1.0
 */
public class ObjectHead {

	static L c = new L();
	static JvmTest jvmTest = new JvmTest();

	public static void main(String[] args) {
		final String s = ClassLayout.parseInstance(c).toPrintable();

		final String v = ClassLayout.parseClass(L.class).toPrintable();

		System.out.println(s);
		System.out.println(v);
	}

}
