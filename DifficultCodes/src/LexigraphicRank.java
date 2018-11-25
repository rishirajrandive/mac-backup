
public class LexigraphicRank {
	
	int MAX_CHAR = 256;
	public int fact(int n){
		return (n <= 1)? 1 :n * fact(n-1);
	}
	
	// Construct a count array where value at every index
	// contains count of smaller characters in whole string
	public void populateAndIncreaseCount (int[] count, char[] str)
	{
	    int i;
	 
	    for( i = 0; i < str.length; ++i )
	        ++count[ str[i] ];
	 
	    for( i = 1; i < 256; ++i )
	        count[i] += count[i-1];
	}
	
	// Removes a character ch from count[] array
	// constructed by populateAndIncreaseCount()
	public void updatecount (int[] count, char ch)
	{
	    int i;
	    for( i = ch; i < MAX_CHAR; ++i )
	        --count[i];
	}
	
	// A function to find rank of a string in all permutations
	// of characters
	public int findRank (String str)
	{
	    int len = str.length();
	    int mul = fact(len);
	    int rank = 1, i;
	    int count[] = new int[MAX_CHAR];
	 
	    // Populate the count array such that count[i] contains count of 
	    // characters which are present in str and are smaller than i
	    populateAndIncreaseCount( count, str.toCharArray() );
	 
	    for (i = 0; i < len; ++i)
	    {
	        mul /= len - i;
	 
	        // count number of chars smaller than str[i]
	        // fron str[i+1] to str[len-1]
	        rank += count[ str.charAt(i) - 1] * mul;
	 
	        // Reduce count of characters greater than str[i]
	        updatecount (count, str.charAt(i));
	    }
	 
	    return rank;
	}
	
	public static void main(String[] args) {
		String str = "acb";
		LexigraphicRank obj = new LexigraphicRank();
		System.out.println(obj.findRank(str));
	}
}
