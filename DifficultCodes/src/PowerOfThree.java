
public class PowerOfThree {

	public boolean isPowerOfThree(int n) {
		if(n == 0){
			return false;
		}
		if(n == 1){
			return true;
		}
        if(n%3 != 0){
        	return false;
        }else if(n/3 == 1){
        	return true;
        }
        return isPowerOfThree(n/3);
    }
	
	public boolean isPowerOfThree1(int n){
		System.out.println(Math.log10(n));
		System.out.println(Math.log10(3));
		System.out.println((Math.log10(n) / Math.log10(3)) % 1 == 0);
		return false;
	}
	
	public static void main(String[] args) {
		PowerOfThree obj = new PowerOfThree();
		System.out.println(obj.isPowerOfThree1(9));
	}
}
