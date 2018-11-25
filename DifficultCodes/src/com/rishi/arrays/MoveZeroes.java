package com.rishi.arrays;

public class MoveZeroes {

	private static int number = 0;
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
        	return;
        }
        
        for(int i=0; i<nums.length-1; i++){
        	if(nums[i] == 0){
        		int j = i+1;
        		
        		while(j < nums.length && nums[j] == 0){
        			j++;
        		}
        		
        		if(j < nums.length){
        			int temp = nums[i];
            		nums[i] = nums[j];
            		nums[j] = temp;
        		}
        	}
        }
    }
	
	public static void main(String[] args) {
		MoveZeroes obj = new MoveZeroes();
		
//		int[] nums = {0, 1, 0, 3, 12};
//		obj.moveZeroes(nums);
//		for(int i=0; i<nums.length; i++){
//			System.out.print(nums[i] + " ");
//		}
		int i;
		for(i=1; i<16; i*=2){}
		System.out.println(i);
		
		try{
			System.out.println("2");
			throw new Exception();
		}catch(Exception e){
			System.out.println("3");
			return;
		}finally{
			System.out.println("4");
		}
	}
	
	public static void test(){
		number = 0;
		for(int i=0; i<10; i++){
			Thread th = new Thread(new Runnable() {
				
				@Override
				public void run() {
					number++;
				}
			});
			th.start();
		}
		
		System.out.println(number);
	}
}
