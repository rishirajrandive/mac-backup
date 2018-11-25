package com.rishi.string;

/**
 * Look and say or count and say. Basically we need to generate sequence based on how many times the number
 * occurs. Example:
 * 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211
 * after 21 we have 1211, because in 21, 2 is one time and 1 is also one time, hence 1211
 * 
 * Method:
 * 1. Add a dummy char at start to start comparison from first char
 * 2. Else modify check to check 0th element as well
 * 
 * 2nd is preferred
 * @author rishi
 *
 */
public class CountAndSay {

	public static void main(String[] args) {
	    String num = "1"; 
	 
//	    for (int i=2; i<=10; i++) {
//	      System.out.print(num + " ");
//	      if(i == 2){
//	    	  num = "11";
//	      }else if(i>2){
//		      num = lookandsay(num);	    	  
//	      }
//	    }
	    int n = 10;
	    
	    while(n > 1){
	    	System.out.print(num + " ");
	    	num = getNext(num);
	    	n--;
	    }
	  }
	  
	  private static String lookandsay(String num){
	    StringBuffer op = new StringBuffer();
	    int len = num.length();
	    int count = 1;
	    num += '$';
	    
	    for(int i = 1; i <= len; i++){
	    	if(num.charAt(i) == num.charAt(i-1)){
	    		count++;
	    	}else {
	    		op.append(count);
	    		op.append(num.charAt(i-1));
	    		count = 1;
	    	}
	    }
	    return op.toString();
	  }
	  
	  public static String getNext(String num){
	        StringBuffer next = new StringBuffer();
	        int count = 0;
	        for(int i=0; i<num.length(); i++){
	            if(i == 0 || num.charAt(i) == num.charAt(i-1)){
	                count++;
	            }else {
	                next.append(count);
	                next.append(num.charAt(i-1));
	                count = 1;
	            }
	        }
	        next.append(count);
	        next.append(num.charAt(num.length()-1));
	        return next.toString();
	    }
}





