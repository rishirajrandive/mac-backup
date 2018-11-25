
public class Kangaroo {
	public static void main(String[] args) {
        int x1 = 43;
        int v1 =  2;
        int x2 =  70;
        int v2 =  2;
        
        //288 9679 9653 99
        //43 2 70 2
        
        if(x1>x2 && (v1>v2 || v1 == v2)){
            System.out.println("NO");
        }else if(x2>x1 && (v2>v1 || v2 ==v1)){
            System.out.println("NO");
        }else{
        	int i = 0;
        	while(true){
        		x1 = x1 + v1;
        		x2 = x2 + v2;
        		System.out.println(++i);
        		if(x1 == x2){
        			System.out.println("YES");
        			break;
        		}else if(x1>x2 && v1>v2){
        			System.out.println("NO");
        			break;
        		}else if(x2>x1 && v2>v1){
        			System.out.println("NO");
        			break;
        		}
        		
        	}
//            int lcm = getLCM(v1, v2);
//            if(x1 != 0){
//                lcm = getLCM(lcm, x1);
//            }
//            if(x2 != 0){
//                lcm = getLCM(lcm, x2);
//            }
//            if((lcm-x1)/v1 == (lcm-x2)/v2){
//                System.out.println("YES");
//            }else {
//                System.out.println("NO");
//            }
        }
    }
    
    private static int getLCM(int x, int y){
        int max;
        max = (x>y) ? x : y;
        while(true){
            if(max%x == 0 && max%y == 0){
                return max;
            }
            max++;
            System.out.println(max);
        }
    }
}
