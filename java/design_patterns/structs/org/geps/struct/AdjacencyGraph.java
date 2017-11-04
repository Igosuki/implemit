package org.geps.struct;

//O(log n) access time if no hashtable is used for vertices
//T is the type of the vertex value, E is the type of the edges
public class AdjacencyGraph<T, E> {

	//A list of nodes, every node has a hashtable of vertices
	ArrayList<AdjacencyNode<T>> nodeList;
	
	public class AdjacencyNode<T, E> {
		//Value of the node
		T value;
		//Key : index of the node which is linked to by this edge, E type of the edge's weight
		Hashtable<Integer, E> edges;
	}
	
	//public class Vertice<E> {
	//	//Value associated to the vertice
	//	E value;
	//	//Index of the node it points to, could be an object pointer
	//	AdjacencyNode to;
	//}
}