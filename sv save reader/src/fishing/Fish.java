package fishing;

import enums.*;

public class Fish {

	private int id;
	private String name;
	private Season[] seasons;
	private Weather weather;
	private Location[] location;
	private int startTime;
	private int endTime;
	private int timesCaught;
	private int pauseStart;
	private int pauseEnd;
	
	
	
	public Fish(int id, String name, Season[] seasons, Weather weather, 
				Location[] location, Integer[] availabilities, int timesCaught) 	{
		
		this.id = id;
		this.name = name;
		this.seasons = seasons;
		this.weather = weather;
		this.location = location;
		this.timesCaught = timesCaught;
		this.startTime = availabilities[0];
		this.endTime = availabilities[availabilities.length-1];
		
		if (availabilities.length > 2) {
			this.pauseStart = availabilities[1];
			this.pauseEnd = availabilities[2];
		} else {
			this.pauseEnd = 0; this.pauseStart = 0;
		}
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public Season[] getSeasons() {
		return seasons;
	}
	
	public Weather getWeathers() {
		return weather;
	}
	
	public Location[] getLocation() {
		return location;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public int getTimesCaught() {
		return timesCaught;
	}
	
	public int getPauseStart() {
		return pauseStart;
	}
	
	public int getPauseEnd() {
		return pauseEnd;
	}
	
	@Override
	public String toString() {
		
		//write the name
		String s = "This fish species is name "+this.name+"\n";
		
		//write the seasons
		if (seasons.length == 1) {
			s += ("It can only be caught during "+this.seasons[0].toString())+"\n";
		} else {
			s += "It can be caught during ";
			for (Season season : seasons) {
				s+= season+ ", ";
			}
			s = s.substring(0, s.length()-2);
			s+=".\n";
		}
		
		//write the weather
		if (!weather.equals(Weather.BOTH)) {
			s += ("But it has to be "+weather+"\n");
		} else {
			s += ("It can be caught no matter the weather.\n");
		}
		
		//write the time 
		s += "It can be caught from "+startTime+" to "+endTime;
		
		if (this.pauseEnd != 0) {
			s += "\nBut it takes a break from "+pauseStart+" to "+pauseEnd;
		}
		
		return s;
	}

	/**
	 * Indicates whether the fish described is catchable 
	 * with a fishing rod or with a trap
	 * 
	 * @param description the string describing the fish 
	 * @return true if the fish described is catchable with a rod
	 */
	public static boolean isThisAFish(String description) {
		
		String fish = description;
		
		//retrieves the 2nd section of the description which either
		//indicates if the fish is catchable with a TRAP or an indicator
		//of how difficult it is to catch it with the fishing rod
		fish = fish.substring(fish.indexOf("/")+1);
		fish = fish.substring(0, fish.indexOf("/"));
		
		//returns if the catching difficulty is different from "trap"
		return !fish.equals("trap");
		
	}

	/**
	 * Retrieves a fish according to a description 
	 * @param description the string describing the fish 
	 * @return the fish described 
	 */
	public static Fish getFishFromDescription(String description) {
		
		Fish fish;
		int id; String name;
		
		//fetching the fish id 
		
		//retrives the indexes of the beginning and end of the id section
		int begin = description.indexOf('"')+1; int end = description.indexOf('"', begin+1);
		//converts the index section to an integer corresponding to the id
		id = Integer.valueOf(description.substring(begin, end));
		//substrings the description to remove the id section
		description = description.substring(end+1);
		
		//fetching the fish name with the same system
		
		begin = description.indexOf('"')+1; end = description.indexOf("/");
		name = description.substring(begin, end);
		description = description.substring(end+1);
		
		//fetching the time when the fish is catchable with the same system 
		
		//skips all the fish type sections
		for (int i = 0; i<4; i++) {
			description = description.substring(description.indexOf("/")+1);
		}
		
		begin = 0; end = description.indexOf("/");
		String timeSection = description.substring(begin, end);
		Integer[] availabilites = new Integer[timeSection.length() - timeSection.replace(" ", "").length() + 1];
		if (availabilites.length > 2) {
			for (int i = 0; i<3; i++) {
				end = description.indexOf(" ", begin);
				availabilites[i] = Integer.valueOf(description.substring(begin,end));
				begin = end+1;
			}
		} else {
			end = description.indexOf(" ", begin);
			availabilites[0] = Integer.valueOf(description.substring(begin,end));
			begin = end+1;
		}
		end = description.indexOf("/",begin);
		availabilites[availabilites.length -1] = Integer.valueOf(description.substring(begin, end));
		
		//fetching all the seasons when the fish is catchable with the same system
		begin = description.indexOf("/")+1; end = description.indexOf("/", begin);
		String season = description.substring(begin, end);
		
		Season[] seasons = new Season[season.length() - season.replace(" ", "").length() + 1];
		int indice = 0;
		while (season.contains(" ")){
			String seasonString = season.substring(0, season.indexOf(" "));
			Season s = Season.valueOf(seasonString.toUpperCase());
			season = season.substring(season.indexOf(" ")+1);
			seasons[indice] = s; indice++;
		}
		seasons[indice] = Season.valueOf(season.toUpperCase());
		
		description = description.substring(description.indexOf('/')+1);
		
		//fetching all the weathers when the fish is catchable
		begin = description.indexOf("/")+1; end = description.indexOf("/", begin);
		String weatherString = description.substring(begin, end);
		Weather weather = Weather.valueOf(weatherString.toUpperCase());
		
		description = description.substring(description.indexOf('/')+1);
		
		fish = new Fish(id, name, seasons, weather, null, availabilites, 0);
		
		System.out.println(fish+"\n");
		return fish;
	}
	
}