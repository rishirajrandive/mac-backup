package com.stack.and.queues;

public class InfixToPostfix {

	private StackX stack;
	private String input;
	private String output = "";
	
	public InfixToPostfix(String in){
		input = in;
		stack = new StackX();
		stack.initCharArray(input.length());
	}
	
	public String doTrans(){
		for(int i=0; i<input.length(); i++){
			char ch = input.charAt(i);
			switch(ch){
			case '(':
				stack.pushChar(ch);
				break;
			case '+':
			case '-':
				getOpt(ch, 1);
				break;
			case '*':
			case '/':
				getOpt(ch, 2);
				break;
			case ')':
				gotClosingPara(ch);
				break;
				default:
					output = output + ch;
			}
		}
		
		while(!stack.isEmptyChar()){
			output = output + stack.popChar();
		}
		return output;
	}
	
	public void gotClosingPara(char ch){
		while(!stack.isEmptyChar()){
			char chx = stack.popChar();
			if(chx == '('){
				break;
			}else{
				output = output + chx;
			}
		}
	}
	
	/**
	 * If Precedence of existing operator in stack or optTop is less than 
	 * we push it back to stack and push optThis as well.
	 * However, if optTop is of higher precedence then it will be shown in output.
	 * And optThis pushed to stack.
	 * @param optThis
	 * @param precThis
	 */
	public void getOpt(char optThis, int precThis){
		while(!stack.isEmptyChar()){
			char optTop = stack.popChar();
			if(optTop == '('){
				stack.pushChar(optTop);
				break;
			}else{
				int precTop;
				if(optTop == '+' || optTop == '-'){
					precTop = 1;
				}else{
					precTop = 2;
				}
				if(precTop < precThis){
					stack.pushChar(optTop);
					break;
				}else{
					output = output + optTop;
				}
			}
		}
		stack.pushChar(optThis);
	}
	
	public long doParse(String output){
		StackX parseStack = new StackX();
		parseStack.initArray(20);
		long answer = 0;
		for(int i=0; i<output.length(); i++){
			char ch = output.charAt(i);
			if(ch >= '0' && ch <= '9'){
				parseStack.push((long) ch - '0');
			}else {
				long num2 = parseStack.pop();
				long num1 = parseStack.pop();
				
				switch(ch){
				case '+':
					answer = num1 + num2;
					break;
				case '-':
					answer = num1 - num2;
					break;
				case '*':
					answer = num1 * num2;
					break;
				case '/':
					answer = num1 / num2;
					break;
					default:
						answer = 0;
						break;
				}
				parseStack.push(answer);
			}
		}
		
		return parseStack.pop();
	}
}
