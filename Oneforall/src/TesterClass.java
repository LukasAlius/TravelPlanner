import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TesterClass {

	public static void main(String[] args) throws ParseException {
		
		/*
		float[][] cost3 = new float[][]{{0, 10, 9}, {0, 0, 14}, {1, 16, 0}};
		String[] cities3 = new String[]{"Aberdeen", "Bialystok", "Chicago"};
		
		float[][] cost4 = new float[][]{{0, 10, 9, 17}, {0, 0, 14, 7}, {1, 16, 0, 18}, {7, 2, 4, 0}};
		String[] cities4 = new String[]{"Aberdeen", "Bialystok", "Chicago", "Dresden"};
		
		float[][] cost5 = new float[][]{{0, 10, 9, 17, 7}, {999, 0, 14, 7, 999}, {1, 16, 0, 18, 5},
				{7, 2, 4, 0, 2}, {1, 999, 999, 13, 0}};
		String[] cities5 = new String[]{"Aberdeen", "Bialystok", "Chicago", "Dresden", "Edinburgh"};
		
		float[][] cost6 = new float[][]{{0, 10, 9, 17, 7, 6}, {999, 0, 14, 7, 999, 4}, {1, 16, 0, 18, 5, 14},
				{7, 2, 4, 0, 2, 15}, {1, 999, 999, 13, 0, 20}, {37, 12, 23, 50, 41, 0}};
		String[] cities6 = new String[]{"Aberdeen", "Bialystok", "Chicago", "Dresden", "Edinburgh", "Frankfurt"};
		
		float[][] cost7 = new float[][]{{0, 10, 9, 17, 7, 6, 21}, {999, 0, 14, 7, 999, 4, 22}, {1, 16, 0, 18, 5, 14, 23},
				{7, 2, 4, 0, 2, 15, 24}, {1, 999, 999, 13, 0, 20, 25}, {37, 12, 23, 50, 41, 0, 26},
				{27, 28, 29, 30, 31, 32, 0}};
		String[] cities7 = new String[]{"Aberdeen", "Bialystok", "Chicago", "Dresden", "Edinburgh", "Frankfurt", "Geneva"};

		float[][] cost8 = new float[][]{{0, 10, 9, 17, 7, 6, 21, 33}, {999, 0, 14, 7, 999, 4, 22, 34}, {1, 16, 0, 18, 5, 14, 23, 35},
				{7, 2, 4, 0, 2, 15, 24, 36}, {1, 999, 999, 13, 0, 20, 25, 37}, {37, 12, 23, 50, 41, 0, 26, 38},
				{27, 28, 29, 30, 31, 32, 0, 39}, {40, 41, 42, 43, 44, 45, 46, 0}};
		String[] cities8 = new String[]{"Aberdeen", "Bialystok", "Chicago", "Dresden", "Edinburgh", "Frankfurt", "Geneva", "Hamburg"};
		
		float[][] cost5_repeatedCity = new float[][]{{0, 10, 9, 17, 7}, {999, 0, 14, 7, 999}, {1, 16, 0, 18, 5},
				{7, 2, 4, 0, 2}, {1, 999, 999, 13, 0}};
		String[] cities5_repeatedCity = new String[]{"Aberdeen", "Bialystok", "Chicago", "Dresden", "Aberdeen"};
		
		// All of these tests won't work unless proper departure_date matrixes are created.
		*/
		
		float[][] cost3 = new float[][]{{0, 10, 9}, {0, 0, 14}, {1, 16, 0}};
		String[] cities3 = new String[]{"Aberdeen", "Bialystok", "Chicago"};
		String[][] departure_dates3 = new String[][]{{"0", "2014-11-08 00:00:00", "2014-11-08 00:00:00"},
													 {"2014-12-08 00:00:00", "0", "2014-12-08 00:00:00"},
													 {"2015-01-08 00:00:00", "2015-01-08 00:00:00", "0"}};
		
		long startTime = System.nanoTime();
		
		ToTheStars.DepthFirstSearch(cities3, cost3, departure_dates3, "2014-10-08 00:00:00");
		ToTheStars.printAllResults();
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime)/1000000000.0 + " s"); 
		
		String date_test1 = "2014-11-08 01:00:00";
		
		/*
		try {
			System.out.println(ToTheStars.parseTime(date_test1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		*/
		

	}
	
}
