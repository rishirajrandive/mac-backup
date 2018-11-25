
/**
 * KMP - Knuth Morris Pratt alogrithm works in O(m) + O(n)
 * 1. Create prefix array of pattern
 * 		a. Take j=0 and i=1, start comparing, if match put value j+1 at i. Increment both j and i.
 * 		b. If mismatch put 0 at i and increment i
 * 		c. In case of mismatch and j>0, go to j=j-1 and start matching again
 * 2. Use prefix array to compare the string and get the result. 
 * 		a. Use same method as for prefix with j=0 and i=0
 * @author rishi
 *
 */
public class KMPPatternMatching {

	public int isPatternPresent(String str, String pattern){
		if(str.length() == 0){
			return -1;
		}
		if(str.equalsIgnoreCase(pattern)){
			return 0;
		}

		char[] inputArr = str.toCharArray();
		char[] patternArr = pattern.toCharArray();
		int[] prefix = getPrefixArray(patternArr);
    
	    int j=0;
	    int i=0;
	    
	    for(i=0; i<inputArr.length; i++){
	        if(patternArr[j] == inputArr[i]){
	            j++;
	        }else if(j>0){
	            j = prefix[j-1];
	            i--;
	        }
	        
	        if(j == prefix.length){
	            return i-j+1;
	        }
	    }

    
		return -1;
	}
	
	public int[] getPrefixArray(char[] patternArr){
		int[] prefixArr = new int[patternArr.length];
		int j=0;
		for(int i=1; i< patternArr.length; i++){
		    if(patternArr[i] == patternArr[j]){
		        prefixArr[i] = j+1;
		        j++;
		    }else if(j > 0){
		        j = prefixArr[j-1];
		        i--;
		    }else {
		        prefixArr[i] = 0;
		    }
		}
    return prefixArr;
	}
	
	public static void main(String[] args) {
		KMPPatternMatching obj = new KMPPatternMatching();
		String str = "abxabcabcaby";
		String pattern = "abcaby";
		int index = obj.isPatternPresent(str, pattern);
		if(index != -1){
			System.out.println("Yes there is match, starting at "+ index );
		}
	}
}
