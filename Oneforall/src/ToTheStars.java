import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

public class ToTheStars {

	public static final long FLIGHT_TIME = 86400000L/10; // (1000 * 60 * 60 * 24);

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
		float[] cityValues = new float[cities.length - 1];
		int city1_index, city0_index;
		for (int i = 0; i < cities.length; i++) {
			city1_index = n.getCityTrace().get(i);
			cityNames[i] = cities[city1_index];
			if (i != 0) {
				city0_index = n.getCityTrace().get(i - 1);
				cityValues[i - 1] = cost[city0_index][city1_index];
			}
		}
		results.add(new Route(cityNames, cityValues));
	}

	public static void DepthFirstSearch(String[] cities, float[][] cost, String[][] departure_dates,
			String starting_date) throws ParseException {

		// I assume that all live requests will have at least one output
		// I assume that traveling cost from one city to another will never be
		// free (0)
		// starting_date must have format "2011-01-18 00:00:00"

		boolean[] visited0 = new boolean[cities.length];
		visited0[0] = true;
		ArrayList<Integer> cityTrace0 = new ArrayList<Integer>(cities.length);
		cityTrace0.add(0);
		ArrayList<Integer> depthTrace0 = new ArrayList<Integer>(cities.length);
		depthTrace0.add(0);
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(new GraphNode(0, visited0, 0, cityTrace0, starting_date, depthTrace0));
		while (!stack.empty()) {
			GraphNode n = stack.pop();
			if (n.getPos() == cities.length - 1) {
				if (allVisited(n.getVisited())) {
					parseResult(n, cities, cost);
				} else
					continue;
			}
			for (int i = 1; i < cities.length; i++) {
				if (!n.getVisited()[i] && cost[n.getPos()][i] != 0
						&& stringLaterThan(departure_dates[n.getPos()][i], n.getDate())) {
					boolean[] new_visited = n.getVisited().clone();
					new_visited[i] = true;
					ArrayList<Integer> new_cityTrace = (ArrayList<Integer>) n.getCityTrace().clone();
					new_cityTrace.add(i);
					long dep_time_long;
					dep_time_long = parseTime(departure_dates[n.getPos()][i]).getTime();
					String new_date = dateToString(new Date(dep_time_long + FLIGHT_TIME));
					ArrayList<Integer> new_depthTrace = (ArrayList<Integer>) n.getDepthTrace().clone();
					new_depthTrace.add(0);
					stack.push(new GraphNode(i, new_visited, n.getValue() + cost[n.getPos()][i], new_cityTrace,
							new_date, new_depthTrace));
				}
			}
		}
	}

	public static void DepthFirstSearch3D(String[] cities, float[][][] cost, String[][][] departure_dates,
			String starting_date) throws ParseException {

		// I assume that all live requests will have at least one output
		// I assume that traveling cost from one city to another will never be
		// free (0)
		// starting_date must have format "2011-01-18 00:00:00"

		boolean[] visited0 = new boolean[cities.length];
		visited0[0] = true;
		ArrayList<Integer> cityTrace0 = new ArrayList<Integer>(cities.length);
		ArrayList<Integer> depthTrace0 = new ArrayList<Integer>(cities.length);
		cityTrace0.add(0);
		depthTrace0.add(0);
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(new GraphNode(0, visited0, 0, cityTrace0, starting_date, depthTrace0));
		while (!stack.empty()) {
			GraphNode n = stack.pop();
			if (n.getPos() == cities.length - 1) {
				if (allVisited(n.getVisited())) {
					parseResult3D(n, cities, cost);
				} else
					continue;
			}
			for (int depth = 0; depth < cost.length; depth++) {
				for (int i = 1; i < cities.length; i++) {
					if (!n.getVisited()[i] && cost[depth][n.getPos()][i] != 0
							&& stringLaterThan(departure_dates[depth][n.getPos()][i], n.getDate())) {
						boolean[] new_visited = n.getVisited().clone();
						new_visited[i] = true;
						ArrayList<Integer> new_cityTrace = (ArrayList<Integer>) n.getCityTrace().clone();
						new_cityTrace.add(i);
						long dep_time_long;
						dep_time_long = parseTime(departure_dates[depth][n.getPos()][i]).getTime();
						String new_date = dateToString(new Date(dep_time_long + FLIGHT_TIME));
						ArrayList<Integer> new_depthTrace = (ArrayList<Integer>) n.getDepthTrace().clone();
						new_depthTrace.add(depth);
						stack.push(new GraphNode(i, new_visited, n.getValue() + cost[depth][n.getPos()][i], new_cityTrace, new_date, new_depthTrace));
					}
				}
			}
		}
	}

	private static void parseResult3D(GraphNode n, String[] cities, float[][][] cost) {
		String[] cityNames = new String[cities.length];
		float[] cityValues = new float[cities.length - 1];
		int city1_index, city0_index;
		for (int i = 0; i < cities.length; i++) {
			city1_index = n.getCityTrace().get(i);
			cityNames[i] = cities[city1_index];
			if (i != 0) {
				city0_index = n.getCityTrace().get(i - 1);
				cityValues[i - 1] = cost[n.getDepthTrace().get(i)][city0_index][city1_index];
			}
		}
		results.add(new Route(cityNames, cityValues));
	}

	public static ArrayList<Route> getResults() {
		return results;
	}

	// TODO handle exception
	public static Date parseTime(String time) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		cal.setTime(dt.parse(time));
		return cal.getTime();
	}

	public static String dateToString(Date date) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return dt.format(date);
	}

	public static boolean dateLaterThan(Date date1, Date date2) {
		return date1.after(date2);
	}

	public static boolean stringLaterThan(String date1, String date2) throws ParseException {
		return parseTime(date1).getTime() > parseTime(date2).getTime();
	}

	// TODO: remove this method
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public static void printAllResults() {
		if (results.isEmpty()) {
			System.out.println("No results today, sry -_-");
		} else {
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
