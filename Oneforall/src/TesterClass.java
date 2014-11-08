
public class TesterClass {

	public static void main(String[] args) {
		float[][] cost1 = new float[][]{{0, 10, 9, 17}, {0, 0, 14, 7}, {1, 16, 0, 16}, {7, 2, 4, 0}};
		String[] cities = new String[]{"Aberdeen", "Bialystok", "Chicago", "Dresden"};
		
		ToTheStars.DepthFirstSearch(cities, cost1);
		ToTheStars.printAllResults();
	}
	
}
