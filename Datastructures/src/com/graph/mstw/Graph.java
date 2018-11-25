package com.graph.mstw;

public class Graph {

	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;
	private Vertex vertexList[]; // list of vertices
	private int adjMat[][]; // adjacency matrix
	private int nVerts; // current number of vertices
	private int currentVert;
	private PriorityQ thePQ;
	private int nTree;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		// adjacency matrix
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++){ // set adjacency
			for(int k=0; k<MAX_VERTS; k++){ // matrix to 0
				adjMat[j][k] = INFINITY;
			}
		}
		thePQ = new PriorityQ();
	}
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end, int weight){
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	
	public void putInPQ(int newVert, int newDist){
		int queueIndex = thePQ.find(newVert);
		if(queueIndex != -1){
			Edge tempEdge = thePQ.peekN(queueIndex);
			int oldDist = tempEdge.distance;
			
			if(oldDist > newDist){
				thePQ.removeN(queueIndex);
				Edge newEdge = new Edge(currentVert, newVert, newDist);
				thePQ.insert(newEdge);
			}
		}else {
			Edge newEdge = new Edge(currentVert, newVert, newDist);
			thePQ.insert(newEdge);
		}
	}
	public void mstw(){
		currentVert = 0;
		
		while(nTree < nVerts -1){
			vertexList[currentVert].isInTree = true;
			nTree++;
			
			for(int i=0; i<nVerts; i++){
				if(i==currentVert){
					continue;
				}
				if(vertexList[i].isInTree){
					continue;
				}
				
				int distance = adjMat[currentVert][i];
				if(distance == INFINITY){
					continue;
				}
				putInPQ(i, distance);
			}
			if(thePQ.size() == 0){
				System.out.println("GRAPH NOT CONNECTED");
				return;
			}
			Edge theEdge = thePQ.removeMin();
			int sourceVert = theEdge.srcVert;
			currentVert = theEdge.destVert;
			
			System.out.print( vertexList[sourceVert].label );
			System.out.print( vertexList[currentVert].label );
			System.out.print(" ");
		}
		
		for(int j=0; j<nVerts; j++){ // unmark vertices
			vertexList[j].isInTree = false;
		}
	}
}
