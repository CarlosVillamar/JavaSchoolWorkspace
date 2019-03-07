package flightPath;



public class flightTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		City W = new City("W");
		City U = new City("U");
		City V = new City("V");
		City X = new City("X");
		City Y = new City("Y");
		City Z = new City("Z");
		City M = new City("M");
		City A = new City("A");
		City B = new City("B");
		City C = new City("C");
		
		//page 390 picture  w goes to u,v,x    x goes to y,z
		W.addCityToDest(U);
		W.addCityToDest(V);
		W.addCityToDest(X);
		X.addCityToDest(Y);
		X.addCityToDest(Z);
		
		//more tests
		W.addCityToDest(U);
		W.addCityToDest(X);
		W.addCityToDest(V);
		X.addCityToDest(Y);
		X.addCityToDest(Z);
		V.addCityToDest(A);
		V.addCityToDest(B);
		V.addCityToDest(C);
		C.addCityToDest(M);
		X.addCityToDest(Y);
		X.addCityToDest(Z);
		
		System.out.println(FlightPath.isPath(W, Z));
		
	}
	

}
