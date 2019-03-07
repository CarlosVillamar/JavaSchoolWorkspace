package shapes;

public class circle {
	 private double diameter;
	 
	 public circle()
	 {
		 diameter = 1;
		 
	 }
	 public circle(double w)
	 {
		 setwidth(w);
		 setheight(w);
		 
	 }
	 
	 public void setwidth(double w)
	 {
		 if(w>0)
		 {
			 diameter = w;
			 
		 }
	 }
	 public void setheight(double h)
	 {
		 if(h>0)
		 {
			 diameter = h;
		 }
	 }
	
	public double getraidus()
	{
		return diameter/2;
	}
	

}
