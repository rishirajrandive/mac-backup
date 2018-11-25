import java.math.BigInteger;

public class LCMAndGCD {

	public int GCD(int a, int b){
		if(a == 0 && b == 0){
			return 0;
		}
		
		if(b == 0){
			return a;
		}
		return GCD(Math.min(a, b), Math.max(a, b) % Math.min(a, b));
	}
	
	public int LCM(int a, int b){
		if(a == 0 && b == 0){
			return 0;
		}
		
		return a * b/GCD(a,b);
	}
	public static void main(String[] args) {
		LCMAndGCD obj = new LCMAndGCD();
		System.out.println("GCD is " + obj.GCD(6, 9));
		System.out.println("LCM is " + obj.LCM(6, 9));
		BigInteger a = new BigInteger("9");
		BigInteger b = new BigInteger("6");
		System.out.println("Using lib "+ a.gcd(b));
	}
}
