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
	
	
	
	public Fish(int id, String name, Season[] seasons, Weather weather, 
				Location[] location, int startTime, int endTime, int timesCaught) 	{
		
		this.id = id;
		this.name = name;
		this.seasons = seasons;
		this.weather = weather;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.timesCaught = timesCaught;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Season[] getSeasons() {
		return seasons;
	}
	
	public void setSeasons(Season[] seasons) {
		this.seasons = seasons;
	}
	
	public Weather getWeather() {
		return weather;
	}
	
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	
	public Location[] getLocation() {
		return location;
	}
	
	public void setLocation(Location[] location) {
		this.location = location;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public int getTimesCaught() {
		return timesCaught;
	}
	
	public void setTimesCaught(int timesCaught) {
		this.timesCaught = timesCaught;
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
		
		return s;
	}
	
}