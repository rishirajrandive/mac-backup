
public class RollingString {

	public static void main(String[] args) {
		String s = "abc";
		
		String[] operations = new String[8];
		
		operations[0] = "0 0 L";
		operations[1] = "2 2 L";
		operations[2] = "0 2 R";
		operations[3] = "0 2 R";
		operations[4] = "0 2 R";
		operations[5] = "0 2 R";
		operations[6] = "0 2 R";
		operations[7] = "0 1 L";
		//System.out.println("Testing "+ r.setCharAt(s.indexOf('c'), 'b'));
		System.out.println("Output is " +rollingString(s, operations));
	}
	
	public static String rollingString(String s, String[] operations){
		
		StringBuffer r = new StringBuffer(s);
		  
		for(int i=0; i<operations.length; i++){
			System.out.println(operations[i]);
			String[] values = operations[i].split(" ");
			
			for(int low=Integer.parseInt(values[0]); low<= Integer.parseInt(values[1]); low++){
				char ch = r.charAt(low);
				if(values[2].equalsIgnoreCase("R")){
					if(ch == 'z'){
						//s = s.replace(ch, 'a');
						r.setCharAt(low, 'a');
					}else {
						//s = s.replace(ch, (char)(((ch - 'a' + 1) % 26) + 'a'));
						r.setCharAt(low, (char)(((ch - 'a' + 1) % 26) + 'a'));
					}
				}else{
					if(ch == 'a'){
						//s = s.replace(ch, 'z');
						r.setCharAt(low, 'z');
					}else {
						//s = s.replace(ch, (char)(((ch - 'a' - 1) % 26) + 'a'));
						r.setCharAt(low, (char)(((ch - 'a' - 1) % 26) + 'a'));
					}
				}
			}
		}
		return r.toString();
	}
}
