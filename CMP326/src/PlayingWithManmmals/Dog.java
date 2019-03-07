package PlayingWithManmmals;

public class Dog extends Mammal implements Greetings {
private double weight;
	
	public Dog(){
		super();//invokes the Mammal default constructor
		weight= 0.2;
	}
	public Dog(double w){
		super(6);
		weight = w; //this.weight=w;
		
	}

	public Dog(String hcol, int litSz, double btf){
		super(hcol,litSz,btf);
	}
	public String toString(){
		return super.toString() + " weight: "+weight;
	}
	
	@Override
	public String goodmorning()
	{
		return "I'm gonna lick your face";
		
	}
	@Override
	public String goodeveing()
	
	{
		return "I will get your slippers master";
		
	}
	
	@Override
	public String goodnight()
	{
		return "flop on your face";
	}
	
	
	/**
	public static void main(String[]args){
		Mammal m1 = new Mammal();
		Dog d1 = new Dog();
		System.out.println("THE m1 mammal has: "+ m1.toString());
		System.out.println("THE d1 dog has: "+ d1.toString());
		//System.out.println("The d1 dog also has weight of : "+d1.weight);
		
	}*/

}

