package com.stack.and.queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixPostfixApp {

	public static void main(String[] args) throws IOException {
		String input;
		String output;
		
		System.out.print("Enter postfix: ");
		System.out.flush();
		input = getString(); // read a string from kbd
		InfixToPostfix theTrans = new InfixToPostfix(input);
		output = theTrans.doTrans(); // do the translation
		System.out.println("Postfix is " + output + "\n");
		System.out.println("Evaluation is "+ theTrans.doParse(output));
		
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
