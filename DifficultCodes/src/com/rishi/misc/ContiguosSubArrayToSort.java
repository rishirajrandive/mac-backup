package com.rishi.misc;

public class ContiguosSubArrayToSort {

	public static int solution(int[] A) {
        // write your code in Java SE 8
        if(A == null || A.length == 0){
            return 0;
        }
        
        int min = 0, max = 0;
        int start = 0, end = 0;
        int len = A.length, i=0;
        
        for(start=0; start<len-1; start++){
            if(A[start] > A[start+1]){
                break;
            }
        }
        
        for(end=len-1; end>0; end--){
            if(A[end] <= A[end-1]){
                break;
            }
        }
        
        max = A[start];
        min = A[start];
        
        for(i=start+1; i<=end; i++){
            if(A[i] > max){
                max = A[i];
            }
            if(A[i] < min){
                min = A[i];
            }
        }
        
        for(i=0; i<start; i++){
            if(A[i] > min){
                start = i;
                break;
            }
        }
     
        for(i=len-1; i>end+1; i--){
            if(A[i] < max){
                end = i;
                break;
            }
        }
        return end-start;
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 6, 5, 5, 8, 9};
		solution(A);
	}
}
