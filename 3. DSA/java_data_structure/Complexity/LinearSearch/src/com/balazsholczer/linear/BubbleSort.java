package com.balazsholczer.linear;

import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {

		Random random = new Random();

		int[] nums = new int[30000];
		for (int i = 0; i < 30000; i++)
			nums[i] = random.nextInt(100);

		long start = System.currentTimeMillis();

		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < (nums.length - i); j++) {

				if (nums[j - 1] > nums[j]) {
					// swap the elements!
					int temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
				}

			}
		}

		// O(N*N)  N = 10 000		2 -> 2*2 = 4    3 -> 3*3=9
		// 
		
		long end = System.currentTimeMillis();
		System.out.println("Algorithm takes time to finish: " + (end - start) + "ms");

	}
}
