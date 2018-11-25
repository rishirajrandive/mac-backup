package com.djiktras.shortest.path;

import java.util.HashMap;
import java.util.Set;

public class Graph {

	private HashMap<String, Vertex> vertices;
	private HashMap<Integer, Edge> edges;

	public Graph() {
		vertices = new HashMap<>();
		edges = new HashMap<>();
	}

	public boolean hasVertex(String label){
		return vertices.containsKey(label);
	}
	
	public int getTotalVertices(){
		return vertices.size();
	}
	
	public Set<String> getVertexKeys(){
		return vertices.keySet();
	}
	
	public boolean addEdge(Vertex one, Vertex two, int weight) {
		if (one.equals(two)) {
			return false;
		}
		// ensures the Edge is not in the Graph
		Edge e = new Edge(one, two, weight);
		if (edges.containsKey(e.hashCode())) {
			return false;
		}

		// and that the Edge isn't already incident to one of the vertices
		else if (one.containsEdge(e) || two.containsEdge(e)) {
			return false;
		}

		edges.put(e.hashCode(), e);
		one.addEdge(e);
		two.addEdge(e);
		return true;
	}

	public boolean addVertex(Vertex vertex) {
		vertices.put(vertex.getLabel(), vertex);
		return true;
	}
	
	public Vertex getVertex(String label){
		return vertices.get(label);
	}

}
