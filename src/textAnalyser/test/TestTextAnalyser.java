package textAnalyser.test;

import textAnalyser.*;
import java.util.*;

public class TestTextAnalyser 
{
	public static void main(String[] args) 
	{
		System.out.println("Test 1 constructor");
		
		try
		{
			TextAnalyser textAnalyser1 = new TextAnalyser(1, "C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\Test1.txt");
			
			FileInput test1Result = textAnalyser1.getFileInput();
			
			if(test1Result != null)
			{
				System.out.println("Test 1 Successful");
			}
			else
			{
				System.out.println("Test 1 Failed");
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		try
		{
			System.out.println("Test 2 Constructor");
			
			TextAnalyser textAnalyser2 = new TextAnalyser(1, "C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\Test.txt");
			
			System.out.println("Test 2 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 2 Successful");
		}
		
		try
		{
			System.out.println("Test 3 Constructor");
			
			TextAnalyser textAnalyser3 = new TextAnalyser(2, "Test");
			
			DynamicInput test3Result = textAnalyser3.getDynamicInput();
			
			if(test3Result != null)
			{
				System.out.println("Test 3 Successfull");
			}
			else
			{
				System.out.println("Test 3 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		try
		{
			System.out.println("Test 4 Constructor");
			
			TextAnalyser textAnalyser4 = new TextAnalyser(3, "Test");
			
			Demo test4Result = textAnalyser4.getDemo();
			
			if(test4Result != null)
			{
				System.out.println("Test 4 Successfull");
			}
			else
			{
				System.out.println("Test 4 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		try
		{
			System.out.println("Test 5 Constructor");
			
			TextAnalyser textAnalyser5 = new TextAnalyser(4, "Test");
			
			Demo test5Result = textAnalyser5.getDemo();
			
			System.out.println("Test 5 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 5 Successful");
		}

		System.out.println("Test 6 getCharFrequency");
		
		try 
		{
			TextAnalyser test6Obj = new TextAnalyser(2,"a");
			
			HashMap<Character,Integer> test6Result = test6Obj.getCharFrequency(0);
			
			boolean test6Success = true;
			
			for(char character : test6Result.keySet())
			{
				if(character == 'a')
				{
					if(test6Result.get(character ) != 1)
					{
						test6Success = false;
						break;
					}
				}
				else
				{
					if(test6Result.get(character) != 0)
					{
						test6Success = false;
						break;
					}
				}
			}
			
			if(test6Success == true)
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
		
		System.out.println("Test 7 getCharFrequency");
		
		try 
		{
			TextAnalyser test7Obj = new TextAnalyser(1, "C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\TEst2.txt");
			
			HashMap<Character,Integer> test7Result = test7Obj.getCharFrequency(0);
			
			boolean test7Success = true;
			
			for(char character : test7Result.keySet())
			{
				if(character == 'a')
				{
					if(test7Result.get(character ) != 1)
					{
						test7Success = false;
						break;
					}
				}
				else
				{
					if(test7Result.get(character) != 0)
					{
						test7Success = false;
						break;
					}
				}
			}
			
			if(test7Success == true)
			{
				System.out.println("Test 7 Successful");
			}
			else
			{
				System.out.println("Test 7 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 8 getCharFrequency");
		
		try 
		{
			TextAnalyser test8Obj = new TextAnalyser(3,null);
			
			HashMap<Character,Integer> test8Result = test8Obj.getCharFrequency(0);
			
			System.out.println(test8Result);
			
			/*boolean test8Success = true;
			
			for(char character : test8Result.keySet())
			{
				if(character == 'a')
				{
					if(test8Result.get(character ) != 1)
					{
						test8Success = false;
						break;
					}
				}
				else
				{
					if(test8Result.get(character) != 0)
					{
						test8Success = false;
						break;
					}
				}
			}
			
			if(test8Success == true)
			{
				System.out.println("Test 8 Successful");
			}
			else
			{
				System.out.println("Test 8 Failed");
			}*/
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 9 getCharFrequency");
		
		try 
		{
			TextAnalyser test9Obj = new TextAnalyser(2, "!");
			
			HashMap<Character,Integer> test9Result = test9Obj.getCharFrequency(1);
			
			boolean test9Success = true;
			
			for(char character : test9Result.keySet())
			{
				if(character == '!')
				{
					if(test9Result.get(character ) != 1)
					{
						test9Success = false;
						break;
					}
				}
				else
				{
					if(test9Result.get(character) != 0)
					{
						test9Success = false;
						break;
					}
				}
			}
			
			if(test9Success == true)
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
		
		System.out.println("Test 10 getCharFrequency");
		
		try 
		{
			TextAnalyser test10Obj = new TextAnalyser(1, "C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\Test3.txt");
			
			HashMap<Character,Integer> test10Result = test10Obj.getCharFrequency(0);
			
			boolean test10Success = true;
			
			for(char character : test10Result.keySet())
			{
				if(character == '!')
				{
					if(test10Result.get(character ) != 1)
					{
						test10Success = false;
						break;
					}
				}
				else
				{
					if(test10Result.get(character) != 0)
					{
						test10Success = false;
						break;
					}
				}
			}
			
			if(test10Success == true)
			{
				System.out.println("Test 10 Successful");
			}
			else
			{
				System.out.println("Test 10 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 11 getCharFrequency");
		
		try 
		{
			TextAnalyser test11Obj = new TextAnalyser(3,null);
			
			HashMap<Character,Integer> test11Result = test11Obj.getCharFrequency(1);
			
			System.out.println(test11Result);
			
			/*boolean test11Success = true;
			
			for(char character : test11Result.keySet())
			{
				if(character == '!')
				{
					if(test11Result.get(character ) != 1)
					{
						test11Success = false;
						break;
					}
				}
				else
				{
					if(test11Result.get(character) != 0)
					{
						test11Success = false;
						break;
					}
				}
			}
			
			if(test11Success == true)
			{
				System.out.println("Test 11 Successful");
			}
			else
			{
				System.out.println("Test 11 Failed");
			}*/
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 12 getCharFrequency");
		
		try 
		{
			TextAnalyser test12Obj = new TextAnalyser(3,null);
			
			HashMap<Character,Integer> test12Result = test12Obj.getCharFrequency(2);
			
			System.out.println("Test 12 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 12 Successful");
		}
		
		System.out.println("Test 13 getRelFrequency");
		
		try 
		{
			TextAnalyser test13Obj = new TextAnalyser(2,"ab");
			
			HashMap<Character, Integer> test13Map = new HashMap<Character, Integer>();
			test13Map.put('a', 1);
			test13Map.put('b', 0);
			
			HashMap<Character,Double> test13Result = test13Obj.getRelFrequency(test13Map);
			
			boolean test13Success = true;
			
			for(char character : test13Result.keySet())
			{
				if(character == 'a')	
				{
					if(test13Result.get(character) != 0.5)
					{
						test13Success = false;
						break; 
					}
				}
				if(character == 'b')
				{
					if(test13Result.get(character) != 0)
					{
						test13Success = false;
						break;
					}
				}
			}
			
			if(test13Success == true)
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
		
		System.out.println("Test 14 getRelFrequency");
		
		try 
		{
			TextAnalyser test13Obj = new TextAnalyser(3,null);
			
			HashMap<Character, Integer> test14Map = test13Obj.getCharFrequency(0);
			
			HashMap<Character,Double> test14Result = test13Obj.getRelFrequency(test14Map);
			
			System.out.println(test14Result);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 15 getRelFrequency");
		
		try 
		{
			TextAnalyser test15Obj = new TextAnalyser(1,"C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\Test4.txt");
			
			HashMap<Character, Integer> test15Map = test15Obj.getCharFrequency(0);
			
			HashMap<Character,Double> test15Result = test15Obj.getRelFrequency(test15Map);
			
			boolean test15Success = true;
			
			for(char character : test15Result.keySet())
			{
				if(character == 'a')	
				{
					if(test15Result.get(character) != 0.5)
					{
						test15Success = false;
						break; 
					}
				}
				if(character == 'b')
				{
					if(test15Result.get(character) != 0.5)
					{
						test15Success = false;
						break;
					}
				}
			}
			
			if(test15Success == true)
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

		System.out.println("Test 16 getWordCount");
		
		try
		{
			TextAnalyser test16Obj = new TextAnalyser(1,"C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\Test5.txt");
			
			int test16Result = test16Obj.getWordCount(1);
			
			if(test16Result == 1)
			{
				System.out.println("Test 16 Successful");
			}
			else
			{
				System.out.println("Test 16 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 17 getWordCount");
		
		try
		{
			TextAnalyser test17Obj = new TextAnalyser(2,"Test");
			
			int test17Result = test17Obj.getWordCount(2);
			
			if(test17Result == 1)
			{
				System.out.println("Test 17 Successful");
			}
			else
			{
				System.out.println("Test 17 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 18 getWordCount");
		
		try
		{
			TextAnalyser test18Obj = new TextAnalyser(3,null);
			
			int test18Result = test18Obj.getWordCount(3);
			
			if(test18Result == 16)
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

		System.out.println("Test 19 getWordCount");
		try
		{
			TextAnalyser test19Obj = new TextAnalyser(3,null);
			
			int test19Result = test19Obj.getWordCount(0);
			
			System.out.println("Test 19 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 19 Successful");
		}

		System.out.println("Test 20 getWordCount");
		
		try
		{
			TextAnalyser test20Obj = new TextAnalyser(3,null);
			
			int test20Result = test20Obj.getWordCount(4);
			
			System.out.println("Test 20 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 20 Successful");
		}

		System.out.println("Test 21 getCharacters");
		
		try
		{
			TextAnalyser test21Obj = new TextAnalyser(3,null);
			
			char [] test21Char = test21Obj.getCharacters(1);
			
			if(test21Char.length == 34)
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
		
		System.out.println("Test 22 getCharacters");
		
		try
		{
			TextAnalyser test22Obj = new TextAnalyser(3,null);
			
			char [] test22Char = test22Obj.getCharacters(0);
			
			if(test22Char.length == 26)
			{
				System.out.println("Test 22 Successful");
			}
			else
			{
				System.out.println("Test 22 Failed");
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 23 getCharacters");
		
		try
		{
			TextAnalyser test23Obj = new TextAnalyser(3,null);
			
			char [] test23Char = test23Obj.getCharacters(-1);
			
			System.out.println("Test 23 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 23 Successful");
		}
		
		System.out.println("Test 24 getMaxWordLength");
		
		try
		{
			TextAnalyser test24Obj = new TextAnalyser(1,"C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\Test6.txt");
			
			int test24Result = test24Obj.getMaxWordLength(1);
			
			if(test24Result == 4)
			{
				System.out.println("Test 24 Successful");
			}
			else
			{
				System.out.print("Test 24 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 25 getMaxWordLength");
		
		try
		{
			TextAnalyser test25Obj = new TextAnalyser(2,"Test ab");
			
			int test25Result = test25Obj.getMaxWordLength(2);
			
			if(test25Result == 4)
			{
				System.out.println("Test 25 Successful");
			}
			else
			{
				System.out.print("Test 25 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 26 getMaxWordLength");
		
		try
		{
			TextAnalyser test26Obj = new TextAnalyser(3,null);
			
			int test26Result = test26Obj.getMaxWordLength(3);
			
			if(test26Result == 13)
			{
				System.out.println("Test 26 Successful");
			}
			else
			{
				System.out.print("Test 26 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 27 getMaxWordLength");
		
		try
		{
			TextAnalyser test27Obj = new TextAnalyser(3,null);
			
			int test27Result = test27Obj.getMaxWordLength(0);
			
			System.out.print("Test 27 Failed");
			
		}
		catch(Exception ex)
		{
			System.out.println("Test 27 Successful");
		}
		
		System.out.println("Test 28 getMaxWordLength");
		
		try
		{
			TextAnalyser test28Obj = new TextAnalyser(3,null);
			
			int test28Result = test28Obj.getMaxWordLength(4);
			
			System.out.print("Test 28 Failed");
			
		}
		catch(Exception ex)
		{
			System.out.println("Test 28 Successful");
		}

		System.out.println("Test 29 getMinWordLength");
		
		try
		{
			TextAnalyser test29Obj = new TextAnalyser(1,"C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\Test7.txt");
			
			int test29Result = test29Obj.getMinWordLength(1);
			
			if(test29Result == 1)
			{
				System.out.println("Test 29 Successful");
			}
			else
			{
				System.out.print("Test 29 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 30 getMinWordLength");
		
		try
		{
			TextAnalyser test30Obj = new TextAnalyser(2,"Test a");
			
			int test30Result = test30Obj.getMinWordLength(2);
			
			if(test30Result == 1)
			{
				System.out.println("Test 30 Successful");
			}
			else
			{
				System.out.print("Test 30 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 31 getMinWordLength");
		
		try
		{
			TextAnalyser test31Obj = new TextAnalyser(3,null);
			
			int test31Result = test31Obj.getMinWordLength(3);
			
			if(test31Result == 1)
			{
				System.out.println("Test 31 Successful");
			}
			else
			{
				System.out.print("Test 31 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 32 getMinWordLength");
		
		try
		{
			TextAnalyser test32Obj = new TextAnalyser(3,null);
			
			int test32Result = test32Obj.getMinWordLength(0);
		
			System.out.print("Test 32 Failed");
	
		}
		catch(Exception ex)
		{
			System.out.println("Test 32 Successful");
		}
		
		System.out.println("Test 33 getMinWordLength");
		
		try
		{
			TextAnalyser test33Obj = new TextAnalyser(3,null);
			
			int test33Result = test33Obj.getMinWordLength(4);
		
			System.out.print("Test 33 Failed");
	
		}
		catch(Exception ex)
		{
			System.out.println("Test 33 Successful");
		}

		System.out.println("Test 34 getSentenceCount");
		
		try
		{
			TextAnalyser test34Obj = new TextAnalyser(1,"C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\Test8.txt");
			
			int test34Result = test34Obj.getSentenceCount(1);
			
			if(test34Result == 1)
			{
				System.out.println("Test 34 Successful");
			}
			else
			{
				System.out.print("Test 34 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 35 getSentenceCount");
		
		try
		{
			TextAnalyser test35Obj = new TextAnalyser(2,"Test.");
			
			int test35Result = test35Obj.getSentenceCount(2);
			
			if(test35Result == 1)
			{
				System.out.println("Test 35 Successful");
			}
			else
			{
				System.out.println("Test 35 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 36 getSentenceCount");
		
		try
		{
			TextAnalyser test36Obj = new TextAnalyser(2,"Test.");
			
			int test36Result = test36Obj.getSentenceCount(2);
			
			if(test36Result == 1)
			{
				System.out.println("Test 36 Successful");
			}
			else
			{
				System.out.println("Test 36 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 37 getSentenceCount");
		
		try
		{
			TextAnalyser test37Obj = new TextAnalyser(3,null);
			
			int test37Result = test37Obj.getSentenceCount(3);
			
			if(test37Result == 2)
			{
				System.out.println("Test 37 Successful");
			}
			else
			{
				System.out.println("Test 37 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 38 getSentenceCount");
		
		try
		{
			TextAnalyser test38Obj = new TextAnalyser(3,null);
			
			int test38Result = test38Obj.getSentenceCount(0);
			
			System.out.println("Test 38 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 38 Successful");
		}

		System.out.println("Test 39 getSentenceCount");
		
		try
		{
			TextAnalyser test39Obj = new TextAnalyser(3,null);
			
			int test39Result = test39Obj.getSentenceCount(4);
			
			System.out.println("Test 39 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 39 Successful");
		}

		System.out.println("Test 40 getLineCount");
		
		try
		{
			TextAnalyser test40Obj = new TextAnalyser(1,"C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\TextAnalyser\\TEst9.txt");
			
			int test40Result = test40Obj.getLineCount(1);
			
			if(test40Result == 1)
			{
				System.out.println("Test 40 Successful");
			}
			else
			{
				System.out.println("Test 40 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 41 getLineCount");
		
		try
		{
			TextAnalyser test41Obj = new TextAnalyser(2,"Test.");
			
			int test41Result = test41Obj.getLineCount(2);
			
			if(test41Result == 1)
			{
				System.out.println("Test 41 Successful");
			}
			else
			{
				System.out.println("Test 41 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 42 getLineCount");
		
		try
		{
			TextAnalyser test42Obj = new TextAnalyser(3,null);
			
			int test42Result = test42Obj.getLineCount(3);
			
			if(test42Result == 3)
			{
				System.out.println("Test 42 Successful");
			}
			else
			{
				System.out.println("Test 42 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 43 getLineCount");
		
		try
		{
			TextAnalyser test43Obj = new TextAnalyser(3,null);
			
			int test43Result = test43Obj.getLineCount(0);
			
			System.out.println("Test 43 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 43 Successful");
		}

		System.out.println("Test 44 getLineCount");
		
		try
		{
			TextAnalyser test44Obj = new TextAnalyser(3,null);
			
			int test44Result = test44Obj.getLineCount(4);
			
			System.out.println("Test 44 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 44 Successful");
		}

	}
}
