import java.util.ArrayList;


public class GraphNode {
	
	private int pos; // The number of the city
	private boolean[] visited;
	private float value;
	private ArrayList<Integer> cityTrace;
	
	public GraphNode(int pos, boolean[] visited, float value, ArrayList<Integer> cityTrace) {
		this.pos = pos;
		this.visited = visited;
		this.value = value;
		this.cityTrace = cityTrace;
	}

	public int getPos() {
		return pos;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public float getValue() {
		return value;
	}	
	
	public ArrayList<Integer> getCityTrace() {
		return cityTrace;
	}
	
	// TODO: remove this method      <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String getStringRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append("cityPos: " + pos + "\n");
		sb.append("visited: [");
		for (boolean b : visited) {
			if (b) {
				sb.append(1);
			}
			else {
				sb.append(0);
			}
			sb.append(" ");
		}
		sb.append("]\nvalue" + value + "\ncity trace: [");
		for (int c : cityTrace) {
			sb.append(c + " ");
		}
		sb.append("]\n");
		
		return sb.toString();
	}
}
