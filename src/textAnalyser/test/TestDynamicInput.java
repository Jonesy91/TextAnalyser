package textAnalyser.test;

import textAnalyser.DynamicInput;

public class TestDynamicInput 
{
	public static void main(String[] args) 
	{
		DynamicInput dynamicInput = new DynamicInput("Testing");
		
		System.out.println("Test 1 getDynamicInput");
		
		String test1Result = dynamicInput.getDynamicInput();
		
		if(test1Result.equals("Testing"))
		{
			System.out.println("Test 1 Succesfful");
		}
		else
		{
			System.out.println("Test 1 Failed");
		}

		System.out.println("Test 2 toString");
		
		String test2Result = dynamicInput.toString();
		
		try
		{
			if(test2Result.equals("Testing"))
			{
				System.out.println(dynamicInput);
				System.out.println("Test 2 Succesfful");
			}
			else
			{
				System.out.println("Test 2 Failed");
			}

		}
		catch(Exception ex)
		{
			System.out.println("Test 2 Failed");
		}
				
	}

}
