package com.junzixiehui.sort;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2021/3/7  4:52 PM
 * @version: 1.0
 */
public class BubbleSort {

	public static void main(String[] args) {
		int num[] = {3, 2, 4, 5, 1};
		final int[] selectSort = selectSort(num);
		for (int i = 0; i < selectSort.length; i++) {
			System.out.println(selectSort[i]);
		}
		final int[] sortV2 = sortV2(num);
		for (int i = 0; i < sortV2.length; i++) {
			System.out.println(sortV2[i]);
		}
	}

	private static int[] sortV2(int num[]) {
		if (num == null || num.length == 0) {
			return num;
		}
		int len = num.length;
		for (int i = 1; i < len; i++) {
			boolean flag = false;
			for (int j = 0; j < len - i; j++) {
				if (num[j] > num[j + 1]) {
					swap(num, j, j + 1);
					flag = true;
				}
			}
			if (!flag){
				break;
			}
		}
		return num;
	}

	private static int[] selectSort(int num[]) {
		if (num == null || num.length == 0) {
			return num;
		}
		int len = num.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (num[i] > num[j]) {
					swap(num, i, j);
				}
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
