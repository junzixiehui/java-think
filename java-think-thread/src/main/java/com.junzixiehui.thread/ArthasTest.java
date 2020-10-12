package com.junzixiehui.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/2/20  6:54 PM
 * @version: 1.0
 */
public class ArthasTest {


	private static Random random = new Random();
	public int illegalArgumentCount = 0;

	public static void main(String[] args) throws Exception {
		ArthasTest arthasTest = new ArthasTest();
		int i = 0;
		boolean flag = true;
		while (flag) {

			i ++;
			PeopleVo peopleVo = new PeopleVo();
			peopleVo.setAge(i);
			peopleVo.setName(i + "qzt");
			try {
				arthasTest.add(i, peopleVo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			arthasTest.run();
			TimeUnit.SECONDS.sleep(1);
		}
	}

	private PeopleVo add(int i, PeopleVo peopleVo) {
		return peopleVo;
	}

	public void run() throws InterruptedException {
		try {
			int number = random.nextInt() / 10000;
			List<Integer> primeFactors = primeFactors(number);
			print(number, primeFactors);
		} catch (Exception e) {
			System.out.println(String.format("illegalArgumentCount:%3d, ", illegalArgumentCount) + e.getMessage());
		}
	}

	public static void print(int number, List<Integer> primeFactors) {
		StringBuffer sb = new StringBuffer(number + "=");
		for (int factor : primeFactors) {
			sb.append(factor).append('*');
		}
		if (sb.charAt(sb.length() - 1) == '*') {
			sb.deleteCharAt(sb.length() - 1);
		}
		System.out.println(sb);
	}

	public List<Integer> primeFactors(int number) {
		if (number < 2) {
			illegalArgumentCount++;
			throw new IllegalArgumentException("number is: " + number + ", need >= 2");
		}

		List<Integer> result = new ArrayList<Integer>();
		int i = 2;
		while (i <= number) {
			if (number % i == 0) {
				result.add(i);
				number = number / i;
				i = 2;
			} else {
				i++;
			}
		}

		return result;
	}
}
