package com.junzixiehui.str;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2021/3/14  9:12 PM
 * @version: 1.0
 */
public class LongNoRepectStt {

	public static int lengthOfLongestSubstring(String s) {
		// 记录字符上一次出现的位置
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int n = s.length();

		int res = 0;
		int start = 0;
		// 窗口开始位置
		for (int i = 0; i < n; i++) {
			char index = s.charAt(i);
			final Integer j = map.get(index) == null ? -1 : map.get(index);
			start = Math.max(start, j + 1);
			res = Math.max(res, i - start + 1);
			map.put(index, i);
		}
		return res;
	}

	public static void main(String[] args) {
		final int len = lengthOfLongestSubstring("abcabcdbb");
		final int len1 = lengthOfLongestSubstringV1("abcabcdbb");
		System.out.println(len);
		System.out.println(len1);
	}

	public static int lengthOfLongestSubstringV1(String s) {
		// 记录字符上一次出现的位置
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int n = s.length();

		int res = 0;
		int start = 0;
		// 窗口开始位置
		for (int i = 0; i < n; i++) {
			char index = s.charAt(i);
			final Integer j = map.get(index);
			if (j != null) {
				start = j + 1;
			}

			res = Math.max(res, i - start + 1);
			map.put(index, i);
		}
		return res;
	}
}
