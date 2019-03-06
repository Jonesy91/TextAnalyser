package textAnalyser.test;

import java.io.File;
import java.util.HashMap;

import textAnalyser.*;

public class TestAnalysis 
{
	public static void main(String[] args) 
	{
		Analysis analysis = new Analysis();
		
		System.out.println("Test 1 - getAlphabet");

		char [] alphabet = analysis.getAlphabet();
		
		int count = 0;
		int character = 97;
		
		for(char letter : alphabet)
		{
			if(letter == (char)character)
			{
				count++;
				character++;
			}
			else
			{
				break;
			}
		}
		
		if(count != 26)
		{
			System.out.println("Test 1 Failed");
			System.out.println(count);
			
		}
		else
		{
			System.out.println("Test 1 Success");
		}
		
		System.out.println("Test 2 - getCharacters");
		
		char [] characters = {' ','!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<','=','>','?','@','[','\\',']','_','`','¬','{','|','}','~'};

		char [] outputChars = analysis.getCharacters();
		
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
		
		System.out.println("Test 3 - letterFrequency");
		
		HashMap<Character, Integer> letterFrequency1 = analysis.letterFrequency("a", analysis.getAlphabet());
		
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
		
		HashMap<Character, Integer> letterFrequency2 = analysis.letterFrequency("abcdefghijklmnopqrstuvwxyz", analysis.getAlphabet());
		
		int test4 = 0;
		
		for(char letter2 : letterFrequency2.keySet())
		{
			if(letterFrequency2.get(letter2) != 1)
			{
				System.out.println("Test 4 Failed");
				break;
			}
			
			test4++;	
		}
		
		if(test4 == 26)
		{
			System.out.println("Test 4 Success");
		}
		
		System.out.println("Test 5 - letterFrequency");
		
		HashMap<Character, Integer> letterFrequency3 = analysis.letterFrequency("ABCDEFGHIJKLMNOPQRSTUVWXYZ", analysis.getAlphabet());
		
		int test5 = 0;
		
		for(char letter3 : letterFrequency3.keySet())
		{
			if(letterFrequency3.get(letter3) != 1)
			{
				System.out.println("Test 5 Failed");
				break;
			}
			
			test5++;	
		}
		
		if(test5 == 26)
		{
			System.out.println("Test 5 Success");
		}
		
		System.out.println("Test 6 - letterFrequency");
		
		HashMap<Character, Integer> letterFrequency4 = analysis.letterFrequency(" ", analysis.getCharacters());
	
		boolean success6 = true;
		
		for(char test6 : letterFrequency4.keySet())
		{
			if(letterFrequency4.get(' ') != 1)
			{
				success6 = false;
				break;
			}
			else if(test6 != ' ' &&  letterFrequency4.get(test6) != 0)
			{
				success6 = false;
				break;
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
		
		System.out.println("Test 7 - letterFrequency");
		
		boolean success7 = true;
		
		HashMap<Character, Integer> letterFrequency5 = analysis.letterFrequency("“ '!\"#$%&\\,()*+-./:;<=>?@[]_`¬{|}~”", analysis.getCharacters());
	
		for(char test7 : letterFrequency5.keySet())
		{
			if(letterFrequency5.get(test7) != 1)
			{
				success7= false;
				break;
			}
		}
		
		if(success6)
		{
			System.out.println("Test 7 Success");
		}
		else
		{
			System.out.println("Test 7 Failed");
		}
		
		System.out.println("Test 8 - letterFrequency");
		
		boolean success8 = true;
		
		HashMap<Character, Integer> letterFrequency6 = analysis.letterFrequency("a 'b!cd\"e#f$g%h&ij\\k,l(m)n*o+p-q.r/s:t;u<v=w>x?y@z[]_`¬{|}~", analysis.getAlphabet());
		
		for(char test8 : letterFrequency6.keySet())
		{
			if(letterFrequency6.get(test8) != 1)
			{
				success8= false;
				break;
			}
		}
		
		if(success6)
		{
			System.out.println("Test 8 Success");
		}
		else
		{
			System.out.println("Test 8 Failed");
		}
		
		System.out.println("Test 9 - letterFrequency");
		
		boolean success9 = true;
		
		HashMap<Character, Integer> letterFrequency7 = analysis.letterFrequency("a 'b!cd\"e#f$g%h&ij\\k,l(m)n*o+p-q.r/s:t;u<v=w>x?y@z[]_`¬{|}~", analysis.getCharacters());
		
		for(char test9: letterFrequency7.keySet())
		{
			if(letterFrequency7.get(test9) != 1)
			{
				success9 = false;
				break;
			}
		}
		
		if(success6)
		{
			System.out.println("Test 9 Success");
		}
		else
		{
			System.out.println("Test 9 Failed");
		}
		
		System.out.println("Test 10 - letterFrequency");
		
		File test10File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LetterFrequency\\test1.txt"); 
		
		boolean success10 = false;
		
		try
		{
			HashMap<Character, Integer> letterFrequency8 = analysis.letterFrequency(test10File, analysis.getAlphabet());
			
			for(char test10: letterFrequency8.keySet())
			{
				if(test10 == 'a')
				{
					if(letterFrequency8.get(test10) != 1)
					{
						break;
					}
				}
				else
				{
					if(letterFrequency8.get(test10) != 0)
					{
						break;
					}
					else
					{
						success10 = true;
					}
				}
			}
			
			if(success10)
			{
				System.out.println("Test 10 Success");
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
		
		System.out.println("Test 11 - letterFrequency");
		
		File test11File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LetterFrequency\\test2.txt"); 
		
		boolean success11 = false;
		
		try
		{
			HashMap<Character, Integer> letterFrequency9 = analysis.letterFrequency(test11File, analysis.getAlphabet());
			
			for(char test11: letterFrequency9.keySet())
			{
				if(letterFrequency9.get(test11) != 1)
				{
					break;
				}
				else
				{
					success11 = true;
				}
			}
			
			if(success11)
			{
				System.out.println("Test 11 Success");
			}
			else
			{
				System.out.println("Test 11 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 12 - letterFrequency");
		
		File test12File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LetterFrequency\\test3.txt"); 
		
		boolean success12 = false;
		
		try
		{
			HashMap<Character, Integer> letterFrequency10 = analysis.letterFrequency(test12File, analysis.getAlphabet());
			
			for(char test12 : letterFrequency10.keySet())
			{
				if(letterFrequency10.get(test12) != 1)
				{
					break;
				}
				else
				{
					success12 = true;
				}
			}
			
			if(success12)
			{
				System.out.println("Test 12 Success");
			}
			else
			{
				System.out.println("Test 12 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 13 - letterFrequency");
		
		File test13File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LetterFrequency\\test4.txt"); 
		
		boolean success13 = false;
		
		try
		{
			HashMap<Character, Integer> letterFrequency11 = analysis.letterFrequency(test13File, analysis.getCharacters());
			
			for(char test13 : letterFrequency11.keySet())
			{
				if(test13 == ' ')
				{
					if(letterFrequency11.get(test13) != 1)
					{
						success13 = false;
						break;
					}
				}
				else
				{
					if(letterFrequency11.get(test13) != 0)
					{
						success13 = false;
						break;
					}
					else
					{
						success13 = true;
					}
				}
			}
			
			if(success13)
			{
				System.out.println("Test 13 Success");
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
		
		System.out.println("Test 14 - letterFrequency");
		
		File test14File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LetterFrequency\\test5.txt"); 
		
		boolean success14 = false;
		
		try
		{
			HashMap<Character, Integer> letterFrequency12 = analysis.letterFrequency(test14File, analysis.getCharacters());
			
			for(char test14 : letterFrequency12.keySet())
			{
				if(letterFrequency12.get(test14) == 1)
				{
					success14 = true;
				}
				else
				{
					success14 = false;
					break;
				}
			}
			
			if(success14)
			{
				System.out.println("Test 14 Success");
			}
			else
			{
				System.out.println("Test 14 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 15 - letterFrequency");
		
		File test15File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LetterFrequency\\test6.txt"); 
		
		boolean success15 = false;
		
		try
		{
			HashMap<Character, Integer> letterFrequency13 = analysis.letterFrequency(test15File, analysis.getAlphabet());
			
			for(char test15 : letterFrequency13.keySet())
			{
				if(letterFrequency13.get(test15) == 1)
				{
					success15 = true;
				}
				else
				{
					success15 = false;
					break;
				}
			}
			
			if(success15)
			{
				System.out.println("Test 15 Success");
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
		
		System.out.println("Test 16 - letterFrequency");
		
		File test16File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LetterFrequency\\test7.txt"); 
		
		boolean success16 = false;
		
		try
		{
			HashMap<Character, Integer> letterFrequency14 = analysis.letterFrequency(test16File, analysis.getCharacters());
			
			for(char test16 : letterFrequency14.keySet())
			{
				if(letterFrequency14.get(test16) == 1)
				{
					success16 = true;
				}
				else
				{
					success16 = false;
					break;
				}
			}
			
			if(success16)
			{
				System.out.println("Test 16 Success");
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
		
		System.out.println("Test 17 - letterFrequency");
		
		File test17File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LetterFrequency\\test8.txt"); 
		
		boolean success17 = false;
		
		try
		{
			HashMap<Character, Integer> letterFrequency15 = analysis.letterFrequency(test17File, analysis.getAlphabet());
			
			for(char test17 : letterFrequency15.keySet())
			{
				if(letterFrequency15.get(test17) == 2)
				{
					success17 = true;
				}
				else
				{
					success17 = false;
					break;
				}
			}
			
			if(success17)
			{
				System.out.println("Test 17 Success");
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
		
		System.out.println("Test 18 - letterFrequency");
		
		File test18File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LetterFrequency\\test9.txt"); 
		
		try
		{
			HashMap<Character, Integer> letterFrequency15 = analysis.letterFrequency(test18File, analysis.getAlphabet());
			
			System.out.println("Test 18 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 18 Success");
		}
		
		System.out.println("Test 19 - timeCharOccurs");
		
		char [] test19Chars = {'a'};
		
		int test19result = analysis.timesCharOccurs('a',test19Chars);
		
		if(test19result == 1)
		{
			System.out.println("Test 19 Successful");
		}
		else
		{
			System.out.println("Test 19 Failed");
		}
		
		System.out.println("Test 20 - timeCharOccurs");
		
		char [] test20Chars = {'a','a'};
		
		int test20result = analysis.timesCharOccurs('a',test20Chars);
		
		if(test20result == 2)
		{
			System.out.println("Test 20 Successful");
		}
		else
		{
			System.out.println("Test 20 Failed");
		}
		
		System.out.println("Test 21 - timeCharOccurs");
		
		char [] test21Chars = {'a','b','a'};
		
		int test21result = analysis.timesCharOccurs('a',test21Chars);
		
		if(test21result == 2)
		{
			System.out.println("Test 21 Successful");
		}
		else
		{
			System.out.println("Test 21 Failed");
		}
		
		System.out.println("Test 22 - timeCharOccurs");
		
		char [] test22Chars = {'b'};
		
		int test22result = analysis.timesCharOccurs('a',test22Chars);
		
		if(test22result == 0)
		{
			System.out.println("Test 22 Successful");
		}
		else
		{
			System.out.println("Test 22 Failed");
		}
		
		System.out.println("Test 23 - getRelFrequency");
		
		HashMap<Character, Integer> frequency23 = new HashMap<Character, Integer>();
		frequency23.put('a', 1);
		frequency23.put('b', 0);
		
		HashMap<Character, Double> results23 = analysis.getRelFrequency(frequency23, "ab");
		
		if(results23.get('a') == 0.5 && results23.get('b') == 0)
		{
			System.out.println("Test 23 Success");
		}
		else
		{
			System.out.println("Test 23 Failed");
		}
		
		System.out.println("Test 24 - getRelFrequency");
		
		HashMap<Character, Integer> frequency24 = new HashMap<Character, Integer>();
		frequency24.put('a', 0);
		frequency24.put('b', 0);
		
		HashMap<Character, Double> results24 = analysis.getRelFrequency(frequency24, "ab");
		
		if(results24.get('a') == 0 && results24.get('b') == 0)
		{
			System.out.println("Test 24 Success");
		}
		else
		{
			System.out.println("Test 24 Failed");
		}

		System.out.println("Test 25 - getRelFrequency");
		
		HashMap<Character, Integer> frequency25 = new HashMap<Character, Integer>();
		frequency25.put('a', -1);
		
		
		HashMap<Character, Double> results25 = analysis.getRelFrequency(frequency25, "a");
		
		if(results25.get('a') == -1 )
		{
			System.out.println("Test 25 Success");
		}
		else
		{
			System.out.println("Test 25 Failed");
		}
		
		System.out.println("Test 26 - getRelFrequency");
		
		HashMap<Character, Integer> frequency26 = new HashMap<Character, Integer>();
		frequency26.put('a', 1);
		frequency26.put('b', 1);
		frequency26.put('c', 5);
		
		HashMap<Character, Double> results26 = analysis.getRelFrequency(frequency26, "abc");
		
		if(results26.get('a') == 0.3333333333333333 && results26.get('b') == 0.3333333333333333 && results26.get('c') == 1.6666666666666667)
		{
			System.out.println("Test 26 Success");
		}
		else
		{
			System.out.println("Test 26 Failed");
		}
		
		System.out.println("Test 27 - wordCount");
		
		File test27File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\WordCount\\Test1.txt");
		
		try 
		{
			int Test27Result = analysis.wordCount(test27File);
			
			if(Test27Result == 1)
			{
				System.out.println("Test 27 Successful");
			}
			else
			{
				System.out.println("Test 27 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
		
		System.out.println("Test 28 - wordCount");
		
		File test28File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\WordCount\\Test2.txt");
		
		try 
		{
			int Test28Result = analysis.wordCount(test28File);
			
			if(Test28Result == 2)
			{
				System.out.println("Test 28 Successful");
			}
			else
			{
				System.out.println("Test 28 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
		
		System.out.println("Test 29 - wordCount");
		
		File test29File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\WordCount\\Test3.txt");
		
		try 
		{
			int Test29Result = analysis.wordCount(test29File);
			
			if(Test29Result == 2)
			{
				System.out.println("Test 29 Successful");
			}
			else
			{
				System.out.println("Test 29 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}

		System.out.println("Test 30 - wordCount");
		
		File test30File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\WordCount\\Test4.txt");
		
		try 
		{
			int Test30Result = analysis.wordCount(test30File);
			
			if(Test30Result == 2)
			{
				System.out.println("Test 30 Successful");
			}
			else
			{
				System.out.println("Test 30 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
		
		System.out.println("Test 31 - wordCount");
		
		File test31File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\WordCount\\Test5.txt");
		
		try 
		{
			int Test31Result = analysis.wordCount(test31File);
			
			if(Test31Result == 52)
			{
				System.out.println("Test 31 Successful");
			}
			else
			{
				System.out.println("Test 31 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
		
		System.out.println("Test 32 - wordCount");
		
		File test32File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\WordCount\\Test6.txt");
		
		try 
		{
			int Test32Result = analysis.wordCount(test32File);
			
			if(Test32Result == 0)
			{
				System.out.println("Test 32 Successful");
			}
			else
			{
				System.out.println("Test 32 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
		
		System.out.println("Test 33 - wordCount");
		
		File test33File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\WordCount\\Test7.txt");
		
		try 
		{

			int Test33Result = analysis.wordCount(test33File);
			
			if(Test33Result == 22)
			{
				System.out.println("Test 33 Successful");
			}
			else
			{
				System.out.println("Test 33 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
		
		System.out.println("Test 34 - wordCount");
		
		File test34File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\WordCount\\Test8.txt");
		
		try 
		{
			int Test34Result = analysis.wordCount(test34File);
			
			System.out.println("Test 34 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 34 Successful");
		}

		System.out.println("Test 35 - wordCount");
		
		int test35Result = analysis.wordCount("test");
		
		if(test35Result == 1)
		{
			System.out.println("Test 35 Succesful");
		}
		else
		{
			System.out.print("Test 35 Failed");
		}
		
		System.out.println("Test 36 - wordCount");
		
		int test36Result = analysis.wordCount("Second test");
		
		if(test36Result == 2)
		{
			System.out.println("Test 36 Succesful");
		}
		else
		{
			System.out.print("Test 36 Failed");
		}

		System.out.println("Test 37 - wordCount");
		
		int test37Result = analysis.wordCount("Third/test");
		
		if(test37Result == 2)
		{
			System.out.println("Test 37 Succesful");
		}
		else
		{
			System.out.print("Test 37 Failed");
		}

		System.out.println("Test 38 - wordCount");
		
		int test38Result = analysis.wordCount(" ");
		
		if(test38Result == 0)
		{
			System.out.println("Test 38 Succesful");
		}
		else
		{
			System.out.print("Test 38 Failed");
		}
		
		System.out.println("Test 39 - maxWordLength");
		
		int test39Result = analysis.maxWordLength("a");
		
		if(test39Result == 1)
		{
			System.out.println("Test 39 Succesful");
		}
		else
		{
			System.out.print("Test 39 Failed");
		}
		
		System.out.println("Test 40 - maxWordLength");
		
		int test40Result = analysis.maxWordLength("a aa");
		
		if(test40Result == 2)
		{
			System.out.println("Test 40 Succesful");
		}
		else
		{
			System.out.print("Test 40 Failed");
		}

		System.out.println("Test 41 - maxWordLength");
		
		int test41Result = analysis.maxWordLength("a aa aaa");
		
		if(test41Result == 3)
		{
			System.out.println("Test 41 Succesful");
		}
		else
		{
			System.out.print("Test 41 Failed");
		}
		
		System.out.println("Test 42 - maxWordLength");
		
		int test42Result = analysis.maxWordLength(" ");
		
		if(test42Result == 0)
		{
			System.out.println("Test 42 Succesful");
		}
		else
		{
			System.out.print("Test 42 Failed");
		}
		
		System.out.println("Test 43 - maxWordLength");
		
		try 
		{
			File test43File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MaxWordLength\\Test1.txt");
			
			int test43Result = analysis.maxWordLength(test43File);
			
			if(test43Result == 1)
			{
				System.out.println("Test 43 Succesful");
			}
			else
			{
				System.out.print("Test 43 Failed");
			}

		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 44 - maxWordLength");
		
		try 
		{
			File test44File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MaxWordLength\\Test2.txt");
			
			int test44Result = analysis.maxWordLength(test44File);
			
			if(test44Result == 2)
			{
				System.out.println("Test 44 Succesful");
			}
			else
			{
				System.out.print("Test 44 Failed");
			}

		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 45 - maxWordLength");
		
		try 
		{
			File test45File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MaxWordLength\\Test3.txt");
			
			int test45Result = analysis.maxWordLength(test45File);
			
			if(test45Result == 3)
			{
				System.out.println("Test 45 Succesful");
			}
			else
			{
				System.out.print("Test 45 Failed");
			}

		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 46 - maxWordLength");
		
		try 
		{
			File test46File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MaxWordLength\\Test4.txt");
			
			int test46Result = analysis.maxWordLength(test46File);
			
			if(test46Result == 0)
			{
				System.out.println("Test 46 Succesful");
			}
			else
			{
				System.out.print("Test 46 Failed");
			}

		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 47 - maxWordLength");
		
		try 
		{
			File test47File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MaxWordLength\\Test5.txt");
			
			int test47Result = analysis.maxWordLength(test47File);
			
			if(test47Result == 5)
			{
				System.out.println("Test 47 Succesful");
			}
			else
			{
				System.out.print("Test 47 Failed");
			}

		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 48 - maxWordLength");
		
		try 
		{
			File test48File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MaxWordLength\\Test6.txt");
			
			int test48Result = analysis.maxWordLength(test48File);
			
			System.out.println("Test 48 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 48 Successful");
		}

		System.out.println("Test 49 - minWordLength");
		
		try 
		{
			File test49File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MinWordLength\\Test1.txt");
			
			int test49Result = analysis.minWordLength(test49File);
			
			if(test49Result == 1)
			{
				System.out.println("Test 49 Succesful");
			}
			else
			{
				System.out.print("Test 49 Failed");
			}

		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 50 - minWordLength");
		
		try 
		{
			File test50File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MinWordLength\\Test2.txt");
			
			int test50Result = analysis.minWordLength(test50File);
			
			if(test50Result == 1)
			{
				System.out.println("Test 50 Succesful");
			}
			else
			{
				System.out.print("Test 50 Failed");
			}

		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 51 - minWordLength");
		
		try 
		{
			File test51File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MinWordLength\\Test3.txt");
			
			int test51Result = analysis.minWordLength(test51File);
			
			if(test51Result == 1)
			{
				System.out.println("Test 51 Succesful");
			}
			else
			{
				System.out.println("Test 51 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 52 - minWordLength");
		
		try 
		{
			File test52File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MinWordLength\\Test4.txt");
			
			int test52Result = analysis.minWordLength(test52File);
			
			if(test52Result == 0)
			{
				System.out.println("Test 52 Succesful");
			}
			else
			{
				System.out.println("Test 52 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 53 - minWordLength");
		
		try 
		{
			File test53File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MinWordLength\\Test5.txt");
			
			int test53Result = analysis.minWordLength(test53File);
			
			if(test53Result == 2)
			{
				System.out.println("Test 53 Succesful");
			}
			else
			{
				System.out.println("Test 53 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 54 - minWordLength");
		
		try 
		{
			File test54File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MinWordLength\\Test6.txt");
			
			int test54Result = analysis.minWordLength(test54File);
			
			if(test54Result == 1)
			{
				System.out.println("Test 54 Succesful");
			}
			else
			{
				System.out.println("Test 54 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 55 - minWordLength");
		
		try 
		{
			File test55File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\MinWordLength\\Test7.txt");
			
			int test55Result = analysis.minWordLength(test55File);
			
			System.out.print("Test 55 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 55 Succesful");
		}

		System.out.println("Test 56 - minWordLength");
		
		try 
		{
			int test56Result = analysis.minWordLength("a");
			
			if(test56Result == 1)
			{
				System.out.println("Test 56 Succesful");
			}
			else
			{
				System.out.println("Test 56 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 57 - minWordLength");
		
		try 
		{
			int test57Result = analysis.minWordLength("a aa");
			
			if(test57Result == 1)
			{
				System.out.println("Test 57 Succesful");
			}
			else
			{
				System.out.println("Test 57 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 58 - minWordLength");
		
		try 
		{
			int test58Result = analysis.minWordLength("a aa aaa");
			
			if(test58Result == 1)
			{
				System.out.println("Test 58 Succesful");
			}
			else
			{
				System.out.println("Test 58 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 59 - minWordLength");
		
		try 
		{
			int test59Result = analysis.minWordLength(" ");
			
			if(test59Result == 0)
			{
				System.out.println("Test 59 Succesful");
			}
			else
			{
				System.out.println("Test 59 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 60 - minWordLength");
		
		try 
		{
			int test60Result = analysis.minWordLength("aa aaa");
			
			if(test60Result == 2)
			{
				System.out.println("Test 60 Succesful");
			}
			else
			{
				System.out.println("Test 60 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 61 - sentenceCount");
		
		try 
		{
			File test61File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\SentenceCount\\Test1.txt");
			
			int test61Result = analysis.sentenceCount(test61File);
			
			if(test61Result == 1)
			{
				System.out.println("Test 61 Succesful");
			}
			else
			{
				System.out.println("Test 61 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 62 - sentenceCount");
		
		try 
		{
			File test62File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\SentenceCount\\Test2.txt");
			
			int test62Result = analysis.sentenceCount(test62File);
			
			if(test62Result == 2)
			{
				System.out.println("Test 62 Succesful");
			}
			else
			{
				System.out.println("Test 62 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 63 - sentenceCount");
		
		try 
		{
			File test63File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\SentenceCount\\Test3.txt");
			
			int test63Result = analysis.sentenceCount(test63File);
			
			if(test63Result == 0)
			{
				System.out.println("Test 63 Succesful");
			}
			else
			{
				System.out.println("Test 63 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 64 - sentenceCount");
		
		try 
		{
			File test64File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\SentenceCount\\Test4.txt");
			
			int test64Result = analysis.sentenceCount(test64File);
			
			if(test64Result == 2)
			{
				System.out.println("Test 64 Succesful");
			}
			else
			{
				System.out.println("Test 64 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 65 - sentenceCount");
		
		try 
		{
			File test65File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\SentenceCount\\Test5.txt");
			
			int test65Result = analysis.sentenceCount(test65File);
			
			if(test65Result == 2)
			{
				System.out.println("Test 65 Succesful");
			}
			else
			{
				System.out.println("Test 65 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 66 - sentenceCount");
		
		try 
		{
			File test66File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\SentenceCount\\Test6.txt");
			
			int test66Result = analysis.sentenceCount(test66File);
			
			if(test66Result == 51)
			{
				System.out.println("Test 66 Succesful");
			}
			else
			{
				System.out.println("Test 66 Failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		System.out.println("Test 67 - sentenceCount");
		
		try 
		{
			File test67File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\SentenceCount\\Test7.txt");
			
			int test67Result = analysis.sentenceCount(test67File);
			
			System.out.println("Test 67 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 67 Succesful");
		}

		System.out.println("Test 68 - sentenceCount");
		
		int test68Result = analysis.sentenceCount("Test.");
		
		if(test68Result == 1)
		{
			System.out.println("Test 68 Successful");
		}
		else
		{
			System.out.println("Test 68 Failed");
		}
		
		System.out.println("Test 69 - sentenceCount");
		
		int test69Result = analysis.sentenceCount("Test. Test.");
		
		if(test69Result == 2)
		{
			System.out.println("Test 69 Successful");
		}
		else
		{
			System.out.println("Test 69 Failed");
		}

		System.out.println("Test 70 - sentenceCount");
		
		int test70Result = analysis.sentenceCount(" ");
		
		if(test70Result == 0)
		{
			System.out.println("Test 70 Successful");
		}
		else
		{
			System.out.println("Test 70 Failed");
		}

		System.out.println("Test 71 - sentenceCount");
		
		int test71Result = analysis.sentenceCount("Test! Test");
		
		if(test71Result == 2)
		{
			System.out.println("Test 71 Successful");
		}
		else
		{
			System.out.println("Test 71 Failed");
		}

		System.out.println("Test 72 - sentenceCount");
		
		int test72Result = analysis.sentenceCount("Test? Test");
		
		if(test72Result == 2)
		{
			System.out.println("Test 72 Successful");
		}
		else
		{
			System.out.println("Test 72 Failed");
		}

		System.out.println("Test 73 - sentenceCount");
		
		try
		{
			File test73File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LineCount\\Test1.txt");
			
			int test73Result = analysis.lineCount(test73File);
			
			if(test73Result == 1)
			{
				System.out.println("Test 73 Successful");
			}
			else
			{
				System.out.println("Test 73 Failed");
			} 
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 74 - sentenceCount");
		
		try
		{
			File test74File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LineCount\\Test2.txt");
			
			int test74Result = analysis.lineCount(test74File);
			
			if(test74Result == 2)
			{
				System.out.println("Test 74 Successful");
			}
			else
			{
				System.out.println("Test 74 Failed");
			} 
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 75 - sentenceCount");
		
		try
		{
			File test75File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LineCount\\Test3.txt");
			
			int test75Result = analysis.lineCount(test75File);
			
			if(test75Result == 5)
			{
				System.out.println("Test 75 Successful");
			}
			else
			{
				System.out.println("Test 75 Failed");
			} 
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 76 - sentenceCount");
		
		try
		{
			File test76File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LineCount\\Test4.txt");
			
			int test76Result = analysis.lineCount(test76File);
			
			if(test76Result == 51)
			{
				System.out.println("Test 76 Successful");
			}
			else
			{
				System.out.println("Test 76 Failed");
			} 
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		System.out.println("Test 77 - sentenceCount");
		
		try
		{
			File test77File = new File("C:\\Users\\fez76\\Documents\\Uni\\Year1\\Programming\\Jones_Nathan_17106270\\Docs\\Test_Cases\\testFiles\\LineCount\\Test5.txt");
			
			int test77Result = analysis.lineCount(test77File);
			
			System.out.println("Test 77 Failed");
		}
		catch(Exception ex)
		{
			System.out.println("Test 77 Successful");
		}
		
		System.out.println("Test 78 - sentenceCount");
		
		int test78Result = analysis.lineCount("a");
		
		if(test78Result == 1)
		{
			System.out.println("Test 78 Successful");
		}
		else
		{
			System.out.println("Test 78 Failed");	
		}
		
		System.out.println("Test 79 - sentenceCount");
		
		int test79Result = analysis.lineCount("a\nb");
		
		if(test79Result == 2)
		{
			System.out.println("Test 79 Successful");
		}
		else
		{
			System.out.println("Test 79 Failed");	
		}
		
		System.out.println("Test 80 - sentenceCount");
		
		int test80Result = analysis.lineCount("a\nb\n ");
		
		if(test80Result == 3)
		{
			System.out.println("Test 80 Successful");
		}
		else
		{
			System.out.println("Test 80 Failed");	
		}
		
		System.out.println("Test 81 - sentenceCount");
		
		int test81Result = analysis.lineCount(" \n \n \n \n ");
		
		if(test81Result == 5)
		{
			System.out.println("Test 81 Successful");
		}
		else
		{
			System.out.println("Test 81 Failed");	
		}
		
		System.out.println("Test 82 - sentenceCount");
		
		int test82Result = analysis.lineCount("");
		
		if(test82Result == 0)
		{
			System.out.println("Test 82 Successful");
		}
		else
		{
			System.out.println("Test 82 Failed");	
		}
	}
}
