
public class GenerateCatalan {

	public long catalanNumbers(int val){
		int res = 0;
		if(val <= 1){
			return 1;
		}
		
		for(int i=0; i<val; i++){
			res += catalanNumbers(i) * catalanNumbers(val - i - 1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		GenerateCatalan obj = new GenerateCatalan();
		for(int i=0; i<5; i++){
			System.out.print(obj.catalanNumbers(i) + " ");
		}
		
	}
}
