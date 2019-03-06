package textAnalyser.test;

import java.io.File;
import java.util.HashMap;

import textAnalyser.Analysis;
import textAnalyser.IAnalysis;

public class TestIAnalysis 
{
	public static void main(String[] args) 
	{
		IAnalysis ianalysis = new Analysis();
	
		System.out.println("Test 1 getAlphabet");
		
		char [] test1Arr = ianalysis.getAlphabet();
		
		int counter = 0;
		
		for(int i = 97; i < 123; i++)
		{
			if((char)i == test1Arr[counter])
			{
				counter++;
			}
			else
			{
				break;
			}		
		}
		
		if(counter < 26)
		{
			System.out.print("Test 1 Failed");
		}
		else if(counter == 26)
		{
			System.out.println("Test 1 Successful");
		}
		
		System.out.println("Test 2 getCharacters");
		
		char [] characters = {' ','!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<','=','>','?','@','[','\\',']','_','`','¬','{','|','}','~'};

		char [] outputChars = ianalysis.getCharacters();
		
		int index = 0;
		
		for(char value : outputChars)
		{
			if(value == characters[index])
			{
				index++;
			}
			else
			{
				break;
			}
		}
		
		if(index-- != characters.length)
		{
			System.out.println("Test 2 Failed");
		}
		else
		{
			System.out.println("Test 2 Success");
		}

		System.out.println("Test 3 letterFrequency");
		
		HashMap<Character, Integer> letterFrequency1 = ianalysis.letterFrequency("a", ianalysis.getAlphabet());
		
		int test3 = 98;
	
		while(test3 < 123)
		{
			if(letterFrequency1.get('a') != 1)
			{
				break;
			}
			else if(letterFrequency1.get((char)test3) != 0)
			{
				break;
			}
			
			test3++;
		}
		
		if(test3 < 123)
		{
			System.out.println("Test 3 Failed");
		}
		else
		{
			System.out.println("Test 3 Success");
		}
		
		System.out.println("Test 4 - letterFrequency");
		
		HashMap<Character, Integer> letterFrequency2 = ianalysis.letterFrequency("!", ianalysis.getCharacters());
	
		boolean success4 = true;
		
		for(char test4 : letterFrequency2.keySet())
		{
			if(letterFrequency2.get('!') != 1)
			{
				success4 = false;
				break;
			}
			else if(test4 != '!' &&  letterFrequency2.get(test4) != 0)
			{
				success4 = false;
				break;
			}
		}
		
		if(success4)
		{
			System.out.println("Test 4 Success");
		}
		else
		{
			System.out.println("Test 4 Failed");
		}
		
		System.out.println("Test 5 - letterFrequency");
		
		File test5File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test1.txt");
		
		try
		{
			HashMap<Character, Integer> letterFrequency3 = ianalysis.letterFrequency(test5File, ianalysis.getAlphabet());
			
			int test5 = 98;
			
			while(test5 < 123)
			{
				if(letterFrequency3.get('a') != 1)
				{
					break;
				}
				else if(letterFrequency3.get((char)test5) != 0)
				{
					break;
				}
				
				test5++;
			}
			
			if(test5 < 123)
			{
				System.out.println("Test 5 Failed");
			}
			else
			{
				System.out.println("Test 5 Success");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 6 - letterFrequency");
		
		File test6File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\test2.txt"); 
		
		boolean success6 = false;
		
		try
		{
			HashMap<Character, Integer> letterFrequency6 = ianalysis.letterFrequency(test6File, ianalysis.getCharacters());
			
			for(char test6 : letterFrequency6.keySet())
			{
				if(test6 == '!')
				{
					if(letterFrequency6.get(test6) != 1)
					{
						success6 = false;
						break;
					}
				}
				else
				{
					if(letterFrequency6.get(test6) != 0)
					{
						success6 = false;
						break;
					}
					else
					{
						success6 = true;
					}
				}
			}
			
			if(success6)
			{
				System.out.println("Test 6 Success");
			}
			else
			{
				System.out.println("Test 6 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 7 getRelFrequency");
		
		HashMap<Character, Integer> frequency7 = new HashMap<Character, Integer>();
		frequency7.put('a', 1);
		frequency7.put('b', 1);
		frequency7.put('c', 1);
		
		HashMap<Character, Double> results7 = ianalysis.getRelFrequency(frequency7, "abc");
		
		if(results7.get('a') == 0.3333333333333333 && results7.get('b') == 0.3333333333333333 && results7.get('c') == 0.3333333333333333)
		{
			System.out.println("Test 7 Success");
		}
		else
		{
			System.out.println("Test 7 Failed");
		}
		
		System.out.println("Test 8 getRelFrequency");
		
		HashMap<Character, Integer> frequency8 = new HashMap<Character, Integer>();
		frequency8.put('a', 1);
		frequency8.put('b', 1);
		frequency8.put('c', 1);
		
		File test8File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test3.txt");
		
		try
		{
			HashMap<Character, Double> results8 = ianalysis.getRelFrequency(frequency8, test8File);
			
			if(results7.get('a') == 0.3333333333333333 && results7.get('b') == 0.3333333333333333 && results7.get('c') == 0.3333333333333333)
			{
				System.out.println("Test 8 Success");
			}
			else
			{
				System.out.println("Test 8 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 9 wordCount");
		
		File test9File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test4.txt");
		
		try
		{
			int test9Result = ianalysis.wordCount(test9File);
			
			if(test9Result == 5)
			{
				System.out.println("Test 9 Successful");
			}
			else
			{
				System.out.println("Test 9 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 10 wordCount");
		
		File test10File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test.txt");
		
		try
		{
			int test10Result = ianalysis.wordCount(test10File);
			
			System.out.println("Test 10 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 10 Successful");
		}
		
		System.out.println("Test 11 wordCount");
		
		int test11Result = ianalysis.wordCount("Test Test Test Test Test");
		
		if(test11Result == 5)
		{
			System.out.println("Test 11 Successful");
		}
		else
		{
			System.out.println("Test 11 Failed");
		}
		
		System.out.println("Test 12 maxWordLength");
		
		int test12Result = ianalysis.maxWordLength("Test ab");
		
		if(test12Result == 4)
		{
			System.out.println("Test 12 Successful");
		}
		else
		{
			System.out.println("Test 12 Failed");
		}
		
		System.out.println("Test 13 maxWordLength");
		
		File test13File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test5.txt");
		
		try
		{
			int test13Result = ianalysis.maxWordLength(test13File);
			
			if(test13Result == 4)
			{
				System.out.println("Test 13 Successful");
			}
			else
			{
				System.out.println("Test 13 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 14 maxWordLength");
		
		File test14File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test.txt");
		
		try
		{
			int test14Result = ianalysis.maxWordLength(test14File);
			
			System.out.println("Test 14 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 14 Successful");
		}
		
		System.out.println("Test 15 minWordLength");
		
		File test15File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test6.txt");
		
		try
		{
			int test15Result = ianalysis.minWordLength(test15File);
			
			if(test15Result == 1)
			{
				System.out.println("Test 15 Successful");
			}
			else
			{
				System.out.println("Test 15 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 16 minWordLength");
		
		File test16File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test.txt");
		
		try
		{
			int test16Result = ianalysis.minWordLength(test16File);
			
			System.out.println("Test 16 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 16 Successful");
		}
		
		System.out.println("Test 17 minWordLength");
		
		int test17Result = ianalysis.minWordLength("Test a");
		
		if(test17Result == 1)
		{
			System.out.println("Test 17 Successful");
		}
		else
		{
			System.out.println("Test 17 Failed");
		}
		
		System.out.println("Test 18 sentenceCount");
		
		File test18File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test7.txt");
		
		try 
		{
			int test18Result = ianalysis.sentenceCount(test18File);
			
			if(test18Result == 3)
			{
				System.out.println("Test 18 Successful");
			}
			else
			{
				System.out.println("Test 18 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 19 sentenceCount");
		
		File test19File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test.txt");
		
		try 
		{
			int test19Result = ianalysis.sentenceCount(test19File);
			
			System.out.println("Test 19 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 19 Successful");
		}
		
		System.out.println("Test 20 sentenceCount");
		
		try 
		{
			int test20Result = ianalysis.sentenceCount("Test. Test! Test?");
			
			if(test20Result == 3)
			{
				System.out.println("Test 20 Successful");
			}
			else
			{
				System.out.println("Test 20 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 21 lineCount");
		
		File test21File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test8.txt");
		
		try 
		{
			int test21Result = ianalysis.lineCount(test21File);
			
			if(test21Result == 3)
			{
				System.out.println("Test 21 Successful");
			}
			else
			{
				System.out.println("Test 21 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 22 lineCount");
		
		File test22File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\IAnalysis\\Test.txt");
		
		try 
		{
			int test22Result = ianalysis.lineCount(test22File);
			
			System.out.println("Test 22 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 22 Successful");
		}
		
		System.out.println("Test 23 lineCount");
		
		int test23Result = ianalysis.lineCount("Test\nTest\nTest");
		
		if(test23Result == 3)
		{
			System.out.println("Test 23 Successful");
		}
		else 
		{
			System.out.println("Test 23 Failed");
		}
		
	}
}
