package textAnalyser.test;

import textAnalyser.Demo;

public class TestDemo 
{
	public static void main(String[] args) 
	{
		Demo demo = new Demo();
		
		System.out.println("Test 1 getDemoInput");
		
		String test1Result = demo.getDemoInput();
		
		if(test1Result.equals("This is a demonstration of the text analyser.\nThis text is used to demonstrate the application!\n "))
		{
			System.out.println("Test 1 Successful");
		}
		else
		{
			System.out.println("Test 1 Failed");
		}
		
		System.out.println("Test 2 toString");
		
		String test2Result = demo.toString();
		
		try 
		{
			if(test2Result != null)
			{
				System.out.println(demo);
				System.out.println("Test 1 Successful");
			}
			else
			{
				System.out.println("Test 1 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Test 1 Failed");
		}
	}

}
