package InClassGUI_Interface;

public class MyMath {
	public static int myadd(int a, int b)
	{ return a+b;
	}
	public static int myadd1(int a, int b,int c)//overloading original
	{ return a+b+c;
	}
	public static double myadd(int a, int b,int c)//overloading original
	{ return (double) a+b+c;
	}
	
	public static int mysub(int x, int y)
	{  return x-y;
	}
	public static int myproduct(int a, int b)
	{
		return a*b;
	}
	public static int myQuo(int a , int b)
	{
		return a/b;
	}
	public static double myPow(int a, int b )
	{
		return Math.pow( a, b);
	}
}
