package com.junzixiehui.dynamic;

/**
 * <p>Description:
 * 在数组中取出一个或多个不相邻数，使其和最大，即找到max(不相邻元素组成的子数组)。
 * </p>
 * @author: by qulibin
 * @date: 2021/3/14  11:46 AM
 * @version: 1.0
 */
public class SumMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,5,2,5,7,3};
		System.out.println(rec_opt(arr, 5));
		System.out.println(dp_opt(arr));
	}

	/**
	 * 递归解法
	 * @param arr
	 * @param i
	 * @return
	 */
	public static int rec_opt(int[] arr, int i) {
		if (i == 0)
			return arr[0];
		else if (i == 1)
			return Math.max(arr[0], arr[1]);
		else {
			int a = rec_opt(arr, i - 2) + arr[i];
			int b = rec_opt(arr, i - 1);
			return Math.max(a, b);
		}
	}

	public static int dp_opt(int[] arr) {
		int[] opt = new int[arr.length];
		opt[0] = arr[0];
		opt[1] = Math.max(arr[0], arr[1]);
		for(int i=2; i<arr.length; i++) {
			int a = opt[i-2] + arr[i];
			int b = opt[i-1];
			opt[i] = Math.max(a, b);
		}
		return opt[arr.length-1];
	}

}
