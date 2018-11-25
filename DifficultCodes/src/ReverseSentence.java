import java.util.Stack;

public class ReverseSentence {

	public String reverse(char[] array){
		StringBuffer strBuffer = new StringBuffer();
		StringBuffer resultBuffer = new StringBuffer();
		//char[] array = orig.toCharArray();
		for(int i=array.length-1; i>=0; i--){
			if(array[i] == ' '){
				resultBuffer.append(strBuffer.reverse());
				resultBuffer.append(' ');
				strBuffer = new StringBuffer();
			}
			if(array[i] != ' ') {
				strBuffer.append(array[i]);
			}
		}
		resultBuffer.append(strBuffer.reverse());
		return resultBuffer.toString();
	}
	
	public static void main(String[] args) {
		ReverseSentence obj = new ReverseSentence();
		char[] arr = {'W', 'o', 'r', 'l', 'd', ' ', 'H', 'e', 'l', 'l', 'o'};
		System.out.println("Result "+ obj.reverse(arr));
	}
}
