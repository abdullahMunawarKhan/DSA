import java.lang.*;
public class MethodOverloading
{
	
	print(int n)
	{
		System.out.println("int : "+n);	
	}
	
	print(String s)
	{
		System.out.print("String :"+s);
	}
	
	public static void main(String args[])
	{
		print(25);
		print("hello");
	}
}
ṇ