import java.util.ArrayList;
import java.util.Stack;

public class ToTheStars {

	private static ArrayList<Route> results = new ArrayList<Route>();

	private static boolean allVisited(boolean[] array) {
		for (boolean b : array) {
			if (!b)
				return false;
		}
		return true;
	}

	private static void parseResult(GraphNode n, String[] cities, float[][] cost) {
		String[] cityNames = new String[cities.length];
		float[] cityValues = new float[cities.length-1];
		int city1_index, city0_index; 
		for (int i = 0; i < cities.length; i++) {
			city1_index = n.getCityTrace().get(i);
			cityNames[i] = cities[city1_index];
			if (i != 0) {
				city0_index = n.getCityTrace().get(i-1);
				cityValues[i-1] = cost[city0_index][city1_index];
			}
		}
		results.add(new Route(cityNames, cityValues));
	}

	public static void DepthFirstSearch(String[] cities, float[][] cost) {

		// The cost of traveling from city to itself should be -1
		// I assume that all live requests will have at least one output
		// I assume that traveling cost from one city to another will never be
		// free
		// I assume (for printing test outputs) that there will always eb at least 2 cities
		// TODO: fix: I assume that no city is mentioned twice

		boolean[] visited0 = new boolean[cities.length];
		visited0[0] = true;
		ArrayList<Integer> cityTrace0 = new ArrayList<Integer>(cities.length);
		cityTrace0.add(0);
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(new GraphNode(0, visited0, 0, cityTrace0));
		while (!stack.empty()) {
			GraphNode n = stack.pop();
			if (n.getPos() == cities.length - 1) {
				if (allVisited(n.getVisited())) {
					parseResult(n, cities, cost);
				} else
					continue;
			}
			for (int i = 1; i < cities.length; i++) {
				if (!n.getVisited()[i] && cost[n.getPos()][i] != 0) {
					boolean[] new_visited = n.getVisited().clone();
					new_visited[i] = true;
					ArrayList<Integer> new_cityTrace = (ArrayList<Integer>) n.getCityTrace().clone();
					new_cityTrace.add(i);
					stack.add(new GraphNode(i, new_visited, n.getValue() + cost[n.getPos()][i], new_cityTrace));
				}
			}
		}
	}

	public static ArrayList<Route> getResults() {
		return results;
	}
	
	// TODO: remove this method      <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public static void printAllResults() {
		if (results.isEmpty()) {
			System.out.println("No results today, sry -_-");
		}
		else {
			int i = 0;
			for (Route r : results) {
				System.out.print(r.testOutput());
				System.out.println("   In total: " + r.getTotal());
				i++;
			}
			System.out.println("total number of outputs: " + i);
		}
	}
}
