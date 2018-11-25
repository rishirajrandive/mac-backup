package com.rishi.arrays;

public class TrappingRainWater {
	
	 public int trap(int[] height) {
	        if(height.length <= 2){
	            return 0;
	        }
	        
	        int totalBars = height.length;
	        int maxL[] = new int[totalBars];
	        int maxR[] = new int[totalBars];
	        
	        maxL[0] = height[0];
	        maxR[totalBars - 1] = height[totalBars - 1];
	        
	        for(int i=1; i<totalBars; i++){
	            maxL[i] = Math.max(maxL[i-1], height[i]);
	            maxR[totalBars - i - 1] = Math.max(maxR[totalBars - i], height[totalBars - i - 1]);
	        }
	        
	        int count = 0;
	        for(int j=1; j<totalBars-1; j++){
	            count += (Math.min(maxL[j], maxR[j]) - height[j]);
	        }
	        return count;
	    }
	 
	 public static void main(String[] args) {
		TrappingRainWater obj = new TrappingRainWater();
		//int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] height = {0, 2, 0};
		System.out.println("Total water capacity = "+ obj.trap(height));
	}

}
