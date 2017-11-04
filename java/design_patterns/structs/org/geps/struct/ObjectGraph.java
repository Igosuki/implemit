package org.geps.struct;

//Just using object pointers, complexity depends on the underlying layout
public class ObjectGraph<V, E> {
	
	//Vertex Object
	V vertex;
	
	//Edges
	Map<E, V> edges;

}