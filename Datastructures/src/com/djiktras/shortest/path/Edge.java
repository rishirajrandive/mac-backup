package com.djiktras.shortest.path;

public class Edge {

	private Vertex one, two;
	private int weight;
	
	public Edge(Vertex o, Vertex t, int w) {
		one = o;
		two = t;
		weight = w;
	}
	
	public void setWeight(int val){
		weight = val;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public Vertex getNeighbor(Vertex v){
		if(v.equals(one)){
			return two;
		}else if(v.equals(two)){
			return one;
		}
		return null;
	}
	
	public Vertex getOne(){
		return one;
	}

	public Vertex getTwo(){
		return two;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (one.getLabel() + two.getLabel()).hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Edge)){
			return false;
		}
		Edge edge = (Edge) obj;
		
		return (edge.one.equals(this.one) && edge.two.equals(this.two));
	}
	
	
}
