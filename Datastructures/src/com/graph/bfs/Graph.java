package com.graph.bfs;

import com.graph.dfs.Vertex;

public class Graph {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Queue theQueue;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++){ // set adjacency
			for(int k=0; k<MAX_VERTS; k++){ // matrix to 0
				adjMat[j][k] = 0;
			}
		}
		theQueue = new Queue();
	}
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	
	public int getAdjUnvisited(int v){
		for(int i=0; i<nVerts; i++){
			if(adjMat[v][i] == 1 && !vertexList[i].wasVisited){
				return i;
			}
		}
		return -1;
	}
	
	public void bfs(){
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theQueue.insert(0);
		int v2;
		while(!theQueue.isEmpty()){
			int v1 = theQueue.remove();
			while((v2 = getAdjUnvisited(v1)) != -1){
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				theQueue.insert(v2);
			}
		}
		for(int j=0; j<nVerts; j++){// reset flags
			vertexList[j].wasVisited = false;
		}
	}
	
}
