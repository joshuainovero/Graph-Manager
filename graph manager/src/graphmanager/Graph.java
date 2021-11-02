package graphmanager;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class Graph <T> {
	
	private Map<T, LinkedList<CPair<T, Integer>>> adjacencyList;
	
	public Graph() {
		this.adjacencyList = new HashMap<T, LinkedList<CPair<T, Integer>>>();
	}
	
	public void addEdge(T x, T y, boolean bidir, int wt) {
		if (!this.adjacencyList.containsKey(x)) {
			this.adjacencyList.put(x, new LinkedList<CPair<T, Integer>>());
		}
		if (!this.adjacencyList.containsKey(y)) {
			this.adjacencyList.put(y, new LinkedList<CPair<T, Integer>>());
		}
		
		this.adjacencyList.get(x).add(CPair.makePair(y, wt));
		if (bidir) {
			this.adjacencyList.get(y).add(CPair.makePair(x, wt));
		}
	}
	
	public void printAdjList() {
		for (Map.Entry<T, LinkedList<CPair<T, Integer>>> set : this.adjacencyList.entrySet()) {
			T node = set.getKey();
			LinkedList<CPair<T, Integer>> nbrs = set.getValue();
			System.out.print(node + " -> ");
			for (CPair<T, Integer> nbr : nbrs) {
				T dest = nbr.first;
				int dist = nbr.second;
				System.out.print(dest + " " + dist + ", ");
			}
			System.out.println("");
		}
	}
	
	public boolean isGraphEmpty() {
		return this.adjacencyList.isEmpty();
	}
	
	public Map<T, LinkedList<CPair<T, Integer>>> getGraph(){
		return this.adjacencyList;
	}
	
}
