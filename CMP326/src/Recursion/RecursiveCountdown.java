package Recursion;

public class RecursiveCountdown
{
public static void main(String[] args)
{
countDown(3);
}
public static void countDown(int num)
{
if (num <= 0)
{
System.out.println();
}
else
{
//countDown(num - 1);// OUTCOME is 123
System.out.print(num);
countDown(num - 1); // outcome is 321 it matters where you print within the else function
}
}
}