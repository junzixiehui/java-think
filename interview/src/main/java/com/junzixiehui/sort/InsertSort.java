package com.junzixiehui.sort;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2021/3/7  4:52 PM
 * @version: 1.0
 */
public class InsertSort {

	public static void main(String[] args) {
		int num[] = {3, 2, 4, 5, 1};
		final int[] sortV2 = insertiSort(num);
		for (int i = 0; i < sortV2.length; i++) {
			System.out.println(sortV2[i]);
		}
	}

	/**
	 * @author: qulibin
	 * @description:
	 * 1.从哪一个位置开始遍历
	 * 2.插入到那个位置
	 * @date: 8:47 PM 2021/3/7
	 * @return:
	 */
	private static int[] insertiSort(int num[]) {
		if (num == null || num.length == 0) {
			return num;
		}
		int len = num.length;
		for (int i = 1; i < len; i++) {
			int tem = num[i];
			int j = i;
			while (j > 0 && num[j - 1] > tem) {
				num[j] = num[j - 1];
				j--;
			}
			if (j != i) {
				num[j] = tem;
			}
		}
		return num;
	}

	private static void swap(int[] num, int i, int j) {
		int tem = num[i];
		num[i] = num[j];
		num[j] = tem;
	}
}
