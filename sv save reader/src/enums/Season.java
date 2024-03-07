package enums;

public enum Season {
	
	SPRING, SUMMER, FALL, WINTER;
	
	public static Season[] getSeasonsFromString(String description) {
		
		Season[] seasons = new Season[description.length() - description.replace(" ", "").length() + 1];
		int indice = 0;
		while (description.contains(" ")){
			String seasonString = description.substring(0, description.indexOf(" "));
			Season s = Season.valueOf(seasonString.toUpperCase());
			description = description.substring(description.indexOf(" ")+1);
			seasons[indice] = s; indice++;
		}
		seasons[indice] = Season.valueOf(description.toUpperCase());
		
		return seasons;
		
	}

}
