package flightPath;

public class FlightPath {
	
	//page 387 push pop
	//page 390 recursive
	public static boolean isPath(City orCity, City destCity){
		City nextCity;
		boolean done = false;
		if(orCity.equals(destCity)){
			System.out.println("\n "+ orCity.toString());
			return true;
		}
		else{
			done = false;
			nextCity = orCity.getNextCity(); // go to next city from here
			while ((nextCity !=null) &&( !done)){
				System.out.println("\n "+ orCity.toString()+"\n ");
				done = isPath(nextCity, destCity);
				if(!done){
					nextCity = orCity.getNextCity();
				}
			}
		}
		return done;
	}

}
