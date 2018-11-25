package com.rishi.arrays;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
        int buyIndex = -1;
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        
        for(int i=0; i<prices.length; i++){
            if(buy > prices[i]){
            	buy = prices[i];
            	buyIndex = i;
            }
        }
        
        for(int i=buyIndex; i<prices.length; i++){
            if(sell < prices[i]){
            	sell = prices[i];
            }
        }
        System.out.println(sell + " " + buy);
        return (sell == Integer.MIN_VALUE) ? 0 : (sell - buy);
    }
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
//		int[] prices = {2, 1, 2, 0, 1};
//		int[] prices = {7, 1, 5, 3, 6, 4};
//		int[] prices = {7, 6, 4, 3, 1};
//		int[] prices = {1, 2, 4};
		int[] prices = {2,4,1};
		System.out.println("Result " + obj.maxProfit(prices));
	}
}
