
public class MultiplyStrings {
	
	public static void main(String[] args) {
		System.out.println(multiplyStrings("442", "13"));
	}
	
	public static String multiplyStrings(String num1, String num2){
		int m = num1.length();
		int n = num2.length();
		int[] result = new int[m+n];
		
		for(int i=m-1; i>=0; i--){
			for(int j=n-1; j>=0; j--){
				int pos1 = i+j;
				int pos2 = pos1 + 1;
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				
				int sum = result[pos2] + product;
				result[pos1] += sum / 10;
				result[pos2] = sum % 10;
			}
		}
		
		StringBuilder resultStr = new StringBuilder();
		for(int val : result){
			if(!(resultStr.length() == 0 && val == 0)){
				resultStr.append(val);
			}
		}
		
		return resultStr.length() == 0 ? "0" : resultStr.toString();
	}

}
