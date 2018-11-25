
public class PossiblePaths {

	public static void main(String[] args) {
        int totalInputs = 10;
        int[] a = {3299, 2584, 968, 7545, 5564, 1595, 3144, 3627, 8375, 7913};
        int[] b = {7314, 2065, 1238, 2436, 1059, 4472, 2372, 4710, 5848, 5387};
        int[] x = {6015, 5206, 91, 3299, 4129, 8536, 1788, 9834, 182, 3397};
        int[] y = {6906, 6088, 9293, 4059, 3475, 7035, 1197, 6925, 958, 8880};
//        int[] a = {1, 2, 3, 2};
//        int[] b = {1, 1, 3, 1};
//        int[] x = {2, 2, 1, 2};
//        int[] y = {3, 3, 1, 3};        
//        for(int i=0; i<totalInputs; i++){
//        	while(true){
//        		if(a[i] > x[i] && b[i] > y[i]){
//                    System.out.println("NO");
//                    break;
//                }
//            	if(a[i] < x[i] && a[i] != x[i]){
//            		a[i] = a[i] + b[i];
//            	}
//            	if(b[i] < y[i] && b[i] != y[i]){
//            		b[i] = a[i] + b[i];
//            	}
//                if(a[i] == x[i] && b[i] == y[i]){
//                    System.out.println("YES");
//                    break;
//                }
//            }
//        }
        for(int i=0; i<totalInputs; i++){
        	if (gcd(Math.abs(a[i]), Math.abs(b[i])) == gcd(Math.abs(x[i]), Math.abs(y[i]))){
                System.out.println("YES");
            } else {
            	System.out.println("NO");
            }
        }
	}
	
	private static int gcd(int a, int b) {	
		return b == 0 ? a : gcd(b, a % b);
	}
}
