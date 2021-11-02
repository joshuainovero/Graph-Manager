package graphmanager;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Search <T> {
	public void reconstructPath(Map<T, T> parent, T start, T end) {
		ArrayList<T> path = new ArrayList<T>();
		for (T curr = end; curr != start; curr = parent.get(curr)) {
			path.add(curr);
		}
		path.add(start);
		Collections.reverse(path);
		System.out.print("Path in order: ");
		System.out.println(path);
	}
	
	public void dijkstra(Map<T, LinkedList<CPair<T, Integer>>> adjacencyList, T start, T end) {
		PriorityQueue<CPair<Integer, T>> pQueue = new PriorityQueue<CPair<Integer, T>>();
		Map<T, Integer> dist = new HashMap<T, Integer>();
		Map<T, T> parent = new HashMap<T, T>();
		
		for (Map.Entry<T, LinkedList<CPair<T, Integer>>> set : adjacencyList.entrySet()) {
			dist.put(set.getKey(), Integer.MAX_VALUE);
		}
		
		dist.put(start, 0);
		
		pQueue.add(CPair.makePair(dist.get(start), start));
		
		while (!pQueue.isEmpty()) {
			CPair<Integer, T> currentPair = pQueue.poll();
			T currentNode = currentPair.second;
			int nodeDist = currentPair.first;
			
			for (CPair<T, Integer> neighbor : adjacencyList.get(currentNode)) {
				if (nodeDist + neighbor.second < dist.get(neighbor.first)) {
					T dest = neighbor.first;
					if (pQueue.contains(CPair.makePair(dist.get(dest), dest))) {
						pQueue.remove(CPair.makePair(dist.get(dest), dest));
					}
					dist.put(dest, nodeDist + neighbor.second);
					pQueue.add(CPair.makePair(dist.get(dest), dest));
					parent.put(dest, currentNode);
				}
			}
		}
		
		this.reconstructPath(parent, start, end);
	
	}
	
	public void bfs(Map<T, LinkedList<CPair<T, Integer>>> adjacencyList, T start, T end) {
		Queue<T> q = new LinkedList<T>();
		Map<T, Integer> visited = new HashMap<T, Integer>();
		Map<T, T> parent = new HashMap<T,T>();
		q.add(start);
		visited.put(start, 1);
		
		while (!q.isEmpty()) {
			T currentNode = q.poll();
			for (CPair<T, Integer> neighbor : adjacencyList.get(currentNode)) {
				if (visited.get(neighbor.first) == null) {
					q.add(neighbor.first);
					visited.put(neighbor.first, 1);
					parent.put(neighbor.first, currentNode);
				}
			}
		}
		
		this.reconstructPath(parent, start, end);
	}
}
