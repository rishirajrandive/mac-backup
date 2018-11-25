package ccti.rishi.arrays;

/**
 * Question is to replace space in the string with %20 which is generally used in URLs.
 * We will be provided with array of chars and true length of the string (i.e. without trailing spaces)
 * Idea is to:
 * 1. Based on the true length get the total space count.
 * 2. Get the index using true length + space count * 2 (space count * 2 because 1 is already considered of the space)
 * 3. Then based on the true length start from the end and if the char is:
 * 		1. Space, put %20 by subtracting 3, 2, 1 from index respectively.
 * 		2. Char, put this char at index-1
 * 
 * @author rishi
 *
 */
public class URLifyString {

	private void replaceSpaces(char[] chars, int trueLength) {
		int spaceCount = 0;
		int index = 0;
		
		for(int i=0; i<trueLength; i++) {
			if(chars[i] == ' ') {
				spaceCount++;
			}
		}
		
		index = trueLength + spaceCount * 2;
		
		if(trueLength < chars.length) {
			chars[trueLength] = '\0';
		}
		
		for(int i=trueLength-1; i >= 0; i--) {
			if(chars[i] == ' ') {
				chars[index - 1] = '0';
				chars[index - 2] = '2';
				chars[index - 3] = '%';
				index -= 3;
			}else {
				chars[index-1] = chars[i];
				index -= 1;
			}
		}
	}
	
	public static void main(String[] args) {
		char[] chars = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
		int trueLength = 13;
		System.out.println(chars.length);
		
		URLifyString obj = new URLifyString();
		obj.replaceSpaces(chars, trueLength);
		
		System.out.println(chars);
	}
}
