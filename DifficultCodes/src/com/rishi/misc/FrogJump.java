package com.rishi.misc;

/**
 * This is one very confusing problem. Pasting the link for future reference
 * https://codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 * @author rishi
 *
 */
public class FrogJump {

	public static int getSecondsToJump(int[] A, int X){
		int[] leaves = new int[X];
		
		for(int i=0; i<X; i++){
			leaves[i] = -1;
		}
		for(int i=0; i<A.length; i++){
			if(leaves[A[i]-1] != -1){
				continue;
			}else {
				leaves[A[i]-1] = i;
				X--;
				if(X == 0){
					return i;
				}
			}
		}
		System.out.println(leaves[0]);
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
		int X = 5;
		System.out.println(getSecondsToJump(A, X));
	}
}
