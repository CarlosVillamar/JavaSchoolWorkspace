package PlayingWithManmmals;

	public class Tester {

		public static void printoutgreetings(Mammal[] ma)
		{
			for(int i =0; i<ma.length;i++)
			{
			System.out.println("Index" +i +"" +ma[i].goodmorning());
			}
		}
		
		public static void main(String[]args){
			Mammal m1 = new Mammal();
			Mammal m2 = new Mammal();
			Mammal hotMammal = new Mammal(102.5);
			Dog d1 = new Dog();
			Dog d2 = new Dog("green", 7, 107);
			Dog d3 = new Dog();
			//Object myObj = new Object();	
			person p1 = new person(36.5);
			Mammal [] mamArr = new Mammal[7];
			mamArr[0] = m1;
			
			
			
			/*System.out.println("THE m1 mammal has: "+ m1.toString());
			System.out.println("THE d1 dog has: "+ d1.toString());
			//System.out.println("The d1 dog also has weight of : "+d1.weight);
			System.out.println("THE hot mammal has: "+ hotMammal.toString());
			System.out.println("m1 vs hotMammal" + m1.compareTo(hotMammal));
			System.out.println("m1 vs generic Object" + m1.compareTo(myObj));
		
			
			System.out.println("THE m1 mammal has: "+ m1.toString());
			System.out.println("THE d1 dog has: "+ d3.toString());
			System.out.println("the p1 person has" + p1.toString());
			System.out.println("THE SUN IS OUT"+d3.goodmorning());
			System.out.println("THE SUN IS OUT"+p1.goodmorning());
			
			
			mamArr[0] = m1;
			mamArr[1] = m2;
			mamArr[2] = hotMammal;
			mamArr[3] = d1;
			mamArr[4] = d2;
			mamArr[5] = d3;
			mamArr[6] = p1;
			*/
			System.out.println("We have an array!!");
			printoutgreetings(mamArr);
			
		}


	}
