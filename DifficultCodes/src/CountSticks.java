
public class CountSticks {
	public static void main(String[] args) {
		int[] lengths = {5, 4, 4, 2, 2, 8};
		System.out.println(cutSticks(lengths).length);
	}
	 static int[] cutSticks(int[] lengths) {
	        int min;
	        int nElem = lengths.length;
			for(int out=0; out<nElem; out++){
				min = out;
				for(int in=out+1; in<nElem; in++){
					if(lengths[in] < lengths[min]){
						min = in;
					}
					swap(min, out, lengths);
				}
			}
	        int[] counts = new int[nElem];
	        for(int i=0; i<nElem; i++){
	            if(lengths[i] > 0){
	                int subtract = lengths[i];
	                int count = 0;
	                for(int j=0; j<nElem; j++){
	                    if(lengths[i] >= subtract){
	                        count++;
	                        lengths[i] = lengths[i] - subtract;                           }
	                }
	                counts[i] = count;
	            }
	        }
	        return counts;
	    }

	    static void swap(int one, int two, int[] lengths){
			int temp = lengths[one];
			lengths[one] = lengths[two];
			lengths[two] = temp;
		}

}
