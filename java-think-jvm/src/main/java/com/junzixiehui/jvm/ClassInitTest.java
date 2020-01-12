package com.junzixiehui.jvm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/6/21  20:15
 * @version: 1.0
 */
public class ClassInitTest {


	/*MSGCODE->Category内存索引*/
	private static Map CODE_MAP_CACHE;

	static {
		CODE_MAP_CACHE = new HashMap();
		//为了说明问题,我在这里初始化一条数据
		CODE_MAP_CACHE.put("0", "北京市");
	}

	//单态实例　一切问题皆由此行引起
	private static final ClassInitTest SINGLE_ENUM_RESOLVER = new ClassInitTest();

	//private, for single instance

	private ClassInitTest() {
		//初始化加载数据  引起问题，该方法也要负点责任
		initEnums();
	}

	/**
	 * 初始化所有的枚举类型
	 */
	public static void initEnums() {
		// ~~~~~~~~~问题从这里开始暴露 ~~~~~~~~~~~//
		if (null == CODE_MAP_CACHE) {
			System.out.println("CODE_MAP_CACHE为空,问题在这里开始暴露.");
			CODE_MAP_CACHE = new HashMap();
		}
		CODE_MAP_CACHE.put("1", "北京市");
		CODE_MAP_CACHE.put("2", "云南省");
	}

	public Map getCache() {
		return Collections.unmodifiableMap(CODE_MAP_CACHE);
	}

	/**
	 * 获取单态实例
	 *
	 * @return
	 */
	public static ClassInitTest getInstance() {
		return SINGLE_ENUM_RESOLVER;
	}

	public static void main(String[] args) {
		System.out.println(ClassInitTest.getInstance().getCache());
	}
}
