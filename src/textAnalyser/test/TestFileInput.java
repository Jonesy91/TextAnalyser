package textAnalyser.test;

import java.io.File;

import textAnalyser.*;

public class TestFileInput 
{
	public static void main(String[] args) 
	{
		System.out.println("Test 1 Create FileInput");
		
		FileInput testFile = null;
		
		try
		{
			testFile = new FileInput("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\FileInput\\Test1.txt");
			
			System.out.println("Test 1 Successful");
		}
		catch(Exception ex)
		{
			System.out.println("Test 1 Failed");
		}	
		
		System.out.println("Test 2 Create FileInput");
		
		try
		{
			FileInput test2File = new FileInput("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\FileInput\\Test2.txt");
			
			System.out.println("Test 2 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 2 Successful");
		}
		
		System.out.println("Test 3 getFile");
		
		File test3File = testFile.getFile();
		
		if(test3File != null)
		{
			System.out.println("Test 3 Successful");
		}
		else
		{
			System.out.println("Test 3 Failed");
		}
		
		System.out.println("Test 4 toString");
		
		String test4File = testFile.toString();
		
		if(test4File != null)
		{
			System.out.println(testFile);
			System.out.println("Test 4 Successful");
		}
		else
		{
			System.out.println("Test 4 Failed");
		}
		
	}
}
