package com.graph.dfs;

public class Graph {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // list of vertices
	private int adjMat[][]; // adjacency matrix
	private int nVerts; // current number of vertices
	private StackX theStack;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int [MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++) // set adjacency
			for(int k=0; k<MAX_VERTS; k++) // matrix to 0
				adjMat[j][k] = 0;
		theStack = new StackX();
		System.out.println(adjMat.length);
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
	
	public int getAdjUnvisitedVertex(int v){
		for(int i=0; i<nVerts; i++){
			if(adjMat[v][i] == 1 && !vertexList[i].wasVisited){
				return i;
			}
		}
		return -1;
	}
	
	public void dfs(){
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theStack.push(0);
		
		while(!theStack.isEmpty()){
			int v = getAdjUnvisitedVertex(theStack.peek());
			
			if(v == -1){
				theStack.pop();
			}else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		for(int j=0; j<nVerts; j++){ 
			vertexList[j].wasVisited = false;
		} 
	}
	
	public void mst(){
		vertexList[0].wasVisited = true;
		theStack.push(0);
		
		while(!theStack.isEmpty()){
			int currentVertex = theStack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			
			if(v == -1){
				theStack.pop();
			}else {
				vertexList[v].wasVisited = true;
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.print(" ");
			}
		}
	}
}
