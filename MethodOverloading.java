
class Method
{
	
	public void prints(int n)
	{
		System.out.println("int : "+n);	
	}
	
	public void prints(String s)
	{
		System.out.print("String :"+s);
	}
	

}

public class MethodOverloading
{
	public static void main(String s[])
	{
		Method m1=new  Method();
		m1.prints(25);
		m1.prints("welcome to java");
	}
}
