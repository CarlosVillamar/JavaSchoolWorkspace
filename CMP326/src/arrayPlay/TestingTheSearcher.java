package arrayPlay;

public class TestingTheSearcher {
	private static double[] blah = {33, 45, 63, 62.5, 77, 111, 23, 34, 45, 55};
	private static int[] someval ={33,45,63,23};
	
	private static int[] biggerarr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("looking for she" + SearchingArray.getLocationOfMatch("she"));
		//System.out.println("looking for She" + SearchingArray.getLocationOfMatch("She"));
		//System.out.println("looking for sHe" + SearchingArray.getLocationOfMatch("sHe"));
		System.out.println("the avg is " +SearchingArray.getAverageOfNumbersInArray(blah));
		System.out.println("the avg is " +SearchingArray.getAverageOfTemperatures());
		
		//SearchingArray.printContentsOFarr(someval);
		//System.out.println("we will double the size of the array...blahh");
		
		biggerarr = SearchingArray.doublethesize(someval);
		
		SearchingArray.printContentsOFarr(biggerarr);
		//SearchingArray.printContentsOFarr(SearchingArray.doublethesize);
		
		someval=biggerarr;
		//SearchingArray.printContentsOFarr(someval);
		//System.out.println("The length of someval is" + someval.length);
		
		//someval[4]=99;
		//biggerarr[2]=193;
	
		
		
		
		
	
	}
}