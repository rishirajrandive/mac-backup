import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FactorialAndFibonacci {

	public int getFactorial(int a){
		//return factorial(a, a);
		int fact = 1;
		for(int i=a; i>=1; i--){
			fact = fact * i;
		}
		return fact;
	}
	
	public int factorial(int fact, int a){
		if(a == 1){
			return fact;
		}
		
		return factorial((fact * (a-1)), a-1);
	}
	
	public void printFactorial(int a, int b, int count){
		if(count > 0){
			int n = a+b;
			a = b;
			b = n;
			System.out.print(n + " ");
			printFactorial(a, b, count-1);
		}
	}
	
	public int getFibonacci(int a){
		
		if(a <= 2){
			return 1;
		}
		
		return getFibonacci(a-1) + getFibonacci(a-2);
	}
	
	
	
	public static void main(String[] args) {
		FactorialAndFibonacci obj = new FactorialAndFibonacci();
		
		System.out.println("Factorial "+ obj.getFactorial(5));
		System.out.println("Print fibonacci ");
		for(int i=1; i<=15; i++){
			System.out.print(obj.getFibonacci(i) + " ");
		}
		System.out.println("");
		System.out.println("Print fibonacci ");
		obj.printFactorial(0, 1, 5);
	}
	
}


