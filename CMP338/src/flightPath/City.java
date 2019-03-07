package flightPath;

import java.util.Stack;

public class City {
	
	String name;
	Stack<City> cities;
	

	public City(){
		name = "noname";
		cities = new Stack<City>();
	}
	
	public City(String name){
		this.name = name;
		cities = new Stack<City>();
	}

	public boolean equals(Object o){
		if(o instanceof City){
			City otherCity = (City)o;
			return (this.name.equalsIgnoreCase(otherCity.name));
		}
		return false;
	}
	public City getNextCity(){
		if(!cities.isEmpty()){
			return cities.pop();
		}
		return null;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", cities=" + cities + "]";
	}

	public Stack<City> getCities() {
		return cities;
	}

	public void setCities(Stack<City> cities) {
		this.cities = cities;
	}
	public void addCityToDest(City c){
		cities.push(c);
	}

}
