package com.junzixiehui.sort;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2021/3/14  1:24 PM
 * @version: 1.0
 */
public class TwoArraySort {

	public static void main(String[] args) {
		int num1[] = {1,2,5,8,9,0,0,0,0,0};
		int num2[] = {1,3,6,66,78};

		merge(num1,5,num2,5);
		System.out.println(num1);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		// 确定指针位置
		int p1 = m - 1;
		int p2 = n - 1;
		int p = m + n - 1;

		while ((p1 >= 0) && (p2 >= 0)) {
			if (nums1[p1] > nums2[p2]){
				nums1[p] = nums1[p1];
			} else {
				nums1[p] = nums2[p2];
			}

			p--;
			p1--;
			p2--;

			//nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
		}
	}

}
