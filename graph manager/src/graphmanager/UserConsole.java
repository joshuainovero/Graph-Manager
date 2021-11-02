package graphmanager;
import java.util.Scanner;

public class UserConsole {
	public static void run() {
		Scanner sc = new Scanner(System.in);
		Graph<String> graph = new Graph<String>();
		Search<String> search = new Search<String>();
		
		while (true) {
			System.out.println("Print Graph [0]\nAdd Edge[1]\nPathfind[2]");
			System.out.print(": ");
			int c = sc.nextInt();
				
			if (c == 0) {
				if (!graph.isGraphEmpty()) {
					graph.printAdjList();
				}
				else {
					System.out.println("Graph is empty!");
				}
			}
			else if (c == 1) {
				System.out.print("Enter node 1: ");
				String node1 = (sc.next()).toUpperCase();
				System.out.print("Enter node 2: ");
				String node2 = (sc.next()).toUpperCase();
				System.out.print("Enter weight: " );
				int weight = sc.nextInt();
				System.out.print("Do you want this edge to be bidirectional? [y/n]: ");
				boolean yorn = ((sc.next()).toLowerCase().equals("y")) ? true : false ;
				graph.addEdge(node1, node2, yorn, weight);
				System.out.println("Sucessfully added an edge to the graph");
			}
			else if (c == 2) {
				if (!graph.isGraphEmpty()) {
					System.out.println("Choose Dijkstra [0]\nChoose Breadth-First Search[1]");
					int c2 = sc.nextInt();
					System.out.print("Enter starting node: ");
					String start = (sc.next()).toUpperCase();
					System.out.print("Enter target node: " );
					String end = (sc.next()).toUpperCase();
					
					if (c2 == 0) {
						search.dijkstra(graph.getGraph(), start, end);
					}
					else if (c2 == 1) {
						search.bfs(graph.getGraph(), start, end);
					}
					
				}
			}
		}
	}
}
