package org.geps.struct;

public interface Graph {

	public Object find(Object query);
	public Object findWithDijkstra(Object query);
	public Object findWithAStar(Object query);
	public void add(Object);
}