
public class PrintHash {

	public static void main(String[] args) {
		int n = 15;
		
		for(int i=0; i<n; i++){
			for(int x=n-1-i; x>0; x--){
				System.out.print(" ");
			}
			for(int j=0; j<i+1; j++){
				System.out.print("#");
			}
			System.out.println("");
		}
	}
}
