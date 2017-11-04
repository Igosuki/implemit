package org.geps.struct;

//O(1) access time and put time
//T is the value type of vertices i.e : the weight function
//This is inconvenient to store more data on the nodes of the graph, though one could use an additionnal list of nodes and put that in the vertices
public class MatrixGraph<T>  {

	private T[][] matrix;
	
	private boolean isOriented;
	
	public MatrixGraph() {
		this(10, false);
	}
	
	public MatrixGraph(int size, boolean oriented) {
		this.matrix = new T[size][size];
	}
	
	public void addEdge(int from, int to, T weight) {
		this.matrix[from][to] = weight;
		if(!oriented) {
			this.matrix[to][from] = weight;
		} 
	}
	
	public int addVertex() {
		
	}
	
	public void removeEdge(int from, int to) {
		this.matrix[from][to] = null;
		if(!oriented) {
			this.matrix[to][from] = null;
		} 
	}
	
	public T findEdge(int from, int to) {
		if(!oriented) {
			if(this.matrix[to][from] == null || this.matrix[from][to] == null) 
				return null;
		} 
		return this.matrix[from][to];
	}

	public boolean hasHamiltonianPath() {
		
	}
	
	public int breadthFirstSearch() {
		int n = this.matrix.length;
		int[] visits = new int[n];
		int visitCount = 0;
		LinkedList<Integer> ll = new LinkedList();
		ll.add(0);
		while(ll.size() > 0) {
			LinkedList<Integer> next = new LinkedList<Integer>();
			for(Integer i : ll) {
				visits[i] = 1;
				visitCount++;
				//We are visiting, do something, find a value, w/e
				for(int j = 0; j < n; j++) {
					if(visits[j] == 0 && this.matrix[i][j] != null) {
						next.add(j);
					}
				}
			}
			ll.removeAll();
			ll = next;
		}
		return 0;
	}
	
	//Runs in O(V²) in a matrix graph
	public int depthFirstSearch(int val) {
		int n = matrix.length;
		int[] visits = new int[n];
		//Tree<Integer, List<Edge>>[] path = 
		//Need to also pass a tree around to have the spanning tree from the path
		return recursiveSearch(val, 0, visits);
	}
	
	//Recursive DFS, works both for oriented and non oriented
	private int recursiveSearch(int val, int vertex, int[] visits) {
		visits[vertex] =  1; //Gray vertex
		for(int i = 0; i < matrix[vertex].length; i++) {
			if(visits[i] == 0 && matrix[vertex][i] != null) { //Vertex is white and  there is an edge
				recursiveSearch(val, i, visits);
			}
		}
		visits[vertex] = 2; //Black vertex
		return vertex;
	}
	
	public List<Edge> getEdges(int vertex) {
		List<Edge> edges = new ArrayList<Edge>();
		for(int i = 0; i < this.matrix[vertex].length; i++) {
			if(this.matrix[vertex][i] != null) {
				edges.add(new Edge(this.matrix[vertex][i], i);
			}
		}
		return edges;
	}
	
	public List<Integer> getNeighbors(int vertex) {
		List<Integer> neighbors = new ArrayList<Integer>();
		for(int i = 0; i < this.matrix[vertex].length; i++) {
			if(this.matrix[vertex][i] != null) {
				neighbors.add(i);
			}
		}
		return neighbors;
	}
	
	public class Edge {
		T weight;
		int to;
		public Edge(T weight, int to) {
			this.weight = weight;
			this.to = to;
		}
	}
}