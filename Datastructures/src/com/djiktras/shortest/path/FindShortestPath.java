package com.djiktras.shortest.path;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindShortestPath {

	private Graph graph;
	private String initialVertexLabel;
	private HashMap<String, String> predecessors;
	private HashMap<String, Integer> distances;
	private PriorityQueue<Vertex> availableVertices;
	private HashSet<Vertex> visitedVertex;

	public FindShortestPath(Graph g, String initLable) {
		graph = g;
		if (!graph.hasVertex(initLable)) {
			System.err.println("The vertex not found in graph, returning");
			return;
		}
		initialVertexLabel = initLable;

		predecessors = new HashMap<>();
		distances = new HashMap<>();
		availableVertices = new PriorityQueue<>(graph.getTotalVertices(), new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				int weightOne = distances.get(o1.getLabel());
				int weightTwo = distances.get(o2.getLabel());
				return weightOne - weightTwo;
			}
		});

		visitedVertex = new HashSet<>();

		for (String vertex : graph.getVertexKeys()) {
			predecessors.put(vertex, null);
			distances.put(vertex, Integer.MAX_VALUE);
		}

		distances.put(initialVertexLabel, 0);

		Vertex initialVertex = graph.getVertex(initialVertexLabel);
		ArrayList<Edge> edges = initialVertex.getEdges();

		for (Edge e : edges) {
			Vertex other = e.getNeighbor(initialVertex);
			predecessors.put(other.getLabel(), initialVertex.getLabel());
			distances.put(other.getLabel(), e.getWeight());
			availableVertices.add(other);
		}

		visitedVertex.add(initialVertex);

		processGraph();
	}

	private void processGraph() {
		while (!availableVertices.isEmpty()) {
			Vertex next = availableVertices.poll();
			int distanceNext = distances.get(next.getLabel());

			ArrayList<Edge> edges = next.getEdges();

			for (Edge e : edges) {
				Vertex other = e.getNeighbor(next);
				if (visitedVertex.contains(other)) {
					continue;
				}

				int currentDist = distances.get(other.getLabel());
				int netDist = distanceNext + e.getWeight();

				if (netDist < currentDist) {
					predecessors.put(other.getLabel(), next.getLabel());
					distances.put(other.getLabel(), netDist);
					availableVertices.remove(other);
					availableVertices.add(other);
				}
			}
			visitedVertex.add(next);
		}
	}

	public int getDistanceTo(String label) {
		return distances.get(label);
	}

	public String getPathTo(String label) {
		StringBuffer path = new StringBuffer();
		path.append(label + "->");
		while (!label.equals(this.initialVertexLabel)) {
			Vertex predecessor = graph.getVertex(this.predecessors.get(label));
			label = predecessor.getLabel();
			path.insert(0, predecessor.getLabel()+ "->");
		}
		return path.toString();

	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		Vertex[] vertices = new Vertex[6];

		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex(i + "");
			graph.addVertex(vertices[i]);
		}

		Edge[] edges = new Edge[9];
		edges[0] = new Edge(vertices[0], vertices[1], 7);
		edges[1] = new Edge(vertices[0], vertices[2], 9);
		edges[2] = new Edge(vertices[0], vertices[5], 14);
		edges[3] = new Edge(vertices[1], vertices[2], 10);
		edges[4] = new Edge(vertices[1], vertices[3], 15);
		edges[5] = new Edge(vertices[2], vertices[3], 11);
		edges[6] = new Edge(vertices[2], vertices[5], 2);
		edges[7] = new Edge(vertices[3], vertices[4], 6);
		edges[8] = new Edge(vertices[4], vertices[5], 9);

		for (Edge e : edges) {
			graph.addEdge(e.getOne(), e.getTwo(), e.getWeight());
		}

		FindShortestPath dijkstra = new FindShortestPath(graph, vertices[0].getLabel());
		System.out.println(dijkstra.getDistanceTo("5"));
		System.out.println(dijkstra.getPathTo("5"));

	}
}
