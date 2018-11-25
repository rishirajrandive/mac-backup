package com.djiktras.shortest.path;

import java.util.ArrayList;

public class Vertex {

	private String label;
	private ArrayList<Edge> edges;
	
	public Vertex(String str) {
		label = str;
		edges = new ArrayList<>();
	}
	
	public void addEdge(Edge edge){
		if(edges.contains(edge)){
			return;
		}
		edges.add(edge);
	}
	
	public boolean containsEdge(Edge edge){
		return edges.contains(edge);
	}
	
	public void removeEdge(Edge edge){
		if(edges.contains(edge)){
			edges.remove(edge);
		}
	}
	
	public String getLabel(){
		return label;
	}
	
	public ArrayList<Edge> getEdges(){
		return edges;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return label.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Vertex)){
			return false;
		}
		Vertex vertex = (Vertex) obj;
		return this.label.equals(vertex.getLabel());
	}
	
	

	
}
