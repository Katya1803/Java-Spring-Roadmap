package com.balazsholczer.linear;

public class App {

	public static void main(String[] args) {
		
		int[] nums = {1,4,5,6,10,-4,67,100};
		
		System.out.println(nums[2]); // O(1) WE KNOW THE INDEX !!!
		
		for(int i=0;i<nums.length;++i) 
			if( nums[i] == 10)
				System.out.println("Index of the item we arelooking for is: "+i);
		
		// O(N)
		
	//	for i=0 to N:   ---> O(N) !!!
		//	O(1)
		
	}
}
