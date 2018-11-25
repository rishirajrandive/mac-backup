package com.recurrsion;

// Works with formula (n^2 + n)/2
public class TriangleSumApp {

	private int triangle(int n){
		if(n == 1){
			return 1;
		}else{
			return (n + triangle(n-1));
		}
	}
	
	private int factorial(int n){
		if(n == 0){
			return 1;
		}else{
			return (n * factorial(n - 1));
		}
	}
	
	public static void main(String[] args) {
		TriangleSumApp obj = new TriangleSumApp();
		System.out.println("Final value of triangle sum "+ obj.triangle(6));
		System.out.println("Final value of facotrial "+ obj.factorial(6));
	}
}
