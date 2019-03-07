package PlayingWithManmmals;

public class person extends Mammal implements Greetings {
	//end of chapter 8
	private double height;
	
	public person()
	{
		super();
		height = 10;
		
	}
	public person(double h)
	{
		if(h>0)
		{
			height = h;
			
		}
	}
	public person(double h, String hc, double btf)
	{
		super(hc, btf);
		height = h;
		setHairColor(hc);
		setBodyTemp(btf);
		
	}
	
	@Override
	public String goodmorning()
	{
		return "rise and shine";
		
	}
	
	@Override
	public String goodeveing()
	{
		return "Buenas Tardes";
		
	}
	
	@Override
	public String goodnight()
	{
		return "I'm out";
	}
	
}
