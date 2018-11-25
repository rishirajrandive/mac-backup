package com.stack.and.queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseStringApp {

	public static void main(String[] args) throws IOException {
		String input, output;
		System.out.println("Enter a string to reverse ");
		System.out.flush();
		input = getString();
		
		StackX charStack = new StackX();
		charStack.initCharArray(input.length());
		for(int i=0; i<input.length(); i++){
			char ch = input.charAt(i);
			charStack.push(ch);
		}
		output = "";
		while(!charStack.isEmpty()){
			output = output + charStack.popChar();
		}
		
		System.out.println("Reversed string "+ output);
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
