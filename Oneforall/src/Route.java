
public class Route {
	
	String[] cityNames;
	float[] cityValues;
	
	public Route(String[] cityNames, float[] cityValues) {
		this.cityNames = cityNames;
		this.cityValues = cityValues;
	}

	public String[] getCityNames() {
		return cityNames;
	}

	public void setCityNames(String[] cityNames) {
		this.cityNames = cityNames;
	}

	public float[] getCityValues() {
		return cityValues;
	}

	public void setCityValues(float[] cityValues) {
		this.cityValues = cityValues;
	}
	
	public float getTotal(){
		float total = 0;
		for (float v : cityValues)
			total += v;
		return total;
	}
	// TODO: remove this method      <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String testOutput() {
		StringBuilder sb = new StringBuilder();
		sb.append(cityNames[0]);
		for (int i = 1; i < cityNames.length; i++) {
			sb.append(": " + cityValues[i-1] + " -> " + cityNames[i]);
		}
		return sb.toString();
	}
}
