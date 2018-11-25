import java.util.ArrayList;

public class WordBreak {

	private String[] dictionary = {"i", "like", "samsung"};
	
	public boolean isInDictionary(String str){
		for(int i=0; i<dictionary.length; i++){
			if(str.equalsIgnoreCase(dictionary[i])){
				return true;
			}
		}
		return false;
	}
	
	public boolean recWordBreak(String str){
		System.out.println(str);
		int size = str.length();
		if(size == 0){
			return true;
		}
		
		for(int i=1; i<=size; i++){
			if(isInDictionary(str.substring(0, i)) && recWordBreak(str.substring(i, size))){
				return true;
			}
		}
		return false;
	}
	
	public boolean dpWordBreak(String str){
		int size = str.length();
		
		if(size == 0){
			return true;
		}
		
		boolean[] hist = new boolean[size+1];
		
		for(int i=1; i<=size; i++){
			if(!hist[i] && isInDictionary(str.substring(0, i))){
				hist[i] = true;
			}
			
			if(hist[i]){
				if(i == size){
					return true;
				}
				
				for(int j=i+1; j<=size; j++){
					if(!hist[j] && isInDictionary(str.substring(i, j))){
						hist[j] = true;
					}
					
					if(size == j && hist[j]){
						return true;
					}
				}
				
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		WordBreak obj = new WordBreak();
		System.out.println("Result "+ obj.recWordBreak("ilikesamsung"));
		System.out.println("Result "+ obj.dpWordBreak("ilikesamsun"));
	}
}
