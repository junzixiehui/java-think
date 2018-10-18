package com.junzixiehui.array;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/8/12  下午3:24
 * @version: 1.0
 */
public class ArraySingle {

	static int[] nums = {1,2,3,2,1,5,6,4,4,5,3};

	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i : nums) {
			res ^= i;
		}
		return res;
	}


	public static void main(String[] args) {
		ArraySingle arraySingle = new ArraySingle();
		int result = arraySingle.singleNumber(nums);


		System.out.println(1^2);
	}
}
