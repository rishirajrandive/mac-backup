import java.util.ArrayList;
import java.util.List;

public class GoodNode {

	static int[] list=null;
    static int count=0;
    static public int getMinNodes(int[] nodes){
        int N=nodes.length;
        count=N;
        list=new int[N+1];
        for (int i=1; i<=N; i++){
        	list[i]=i;
        }
        int flag=0;
        for (int i=1; i<=N; i++){
            if (nodes[i-1]==1){
            	flag=1;
            }
            combine (i, nodes[i-1]);
        }
        System.out.print(count);
        return count - flag;
    }  
    static public void combine(int i, int j){
        int rootI=root(i);
        int rootJ=root(j);
        if (rootI==rootJ) return;
        list[rootJ]=rootI;
        count--;
    }
    static public int root(int elem){
        while (list[elem]!=elem){
            int temp=list[elem];
            list[elem]=list[temp];
            elem=temp;            
        }
        return elem;
    }
    
    public static void main(String[] args) {
    	
//		GoodNode obj = new GoodNode();
//		
//		int[] nodes1 = {1, 2, 3, 4, 5};
//		int[] nodes2 = {5, 5, 5, 5, 5, 5};
//		List<int[]> nodes = new ArrayList<>();
//		nodes.add(nodes1);
//		nodes.add(nodes2);
//		
//		for(int i=0; i<nodes.size(); i++){
//			System.out.println("Min nodes required "+GoodNode.getMinNodes(nodes.get(i)));
//		}
				
		
		
	}
}
