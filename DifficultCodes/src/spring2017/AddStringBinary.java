package spring2017;

public class AddStringBinary {

	public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return a;
        if(b == null || b.length() == 0) return b;
        
        int lastA = a.length() - 1;
        int lastB = b.length() - 1;
        int carry = 0;
        StringBuffer str = new StringBuffer();
        
        while(lastA >= 0 || lastB >= 0 || carry != 0){
            if(lastA >= 0){
                carry += a.charAt(lastA) - '0';
            }
            
            if(lastB >= 0){
                carry += b.charAt(lastB) - '0';
            }
            
            str.insert(0, carry%2);
            
            carry /= 2;
            lastA--;
            lastB--;
        }
        return str.toString();
    }
	
	public static void main(String[] args) {
		AddStringBinary obj = new AddStringBinary();
		String a = "19";
		String b = "";
		System.out.println("Result is "+ obj.addBinary(a, b));
	}
}
