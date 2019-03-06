package textAnalyser;

import java.io.*;
import java.util.*;

public class Analysis implements IAnalysis
{
	// char array for the alphabet
	final char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	// char array for the non-letter characters
	final char [] characters = {' ','!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<','=','>','?','@','[','\\',']','_','`','¬','{','|','}','~','\''};
	
	// Before : the method doesn't take in any parameters
	// After : returns the array for the alphabet
	public char [] getAlphabet()
	{
		return alphabet;
	}
	
	// Before : the method doesn't take in any parameters 
	// After : returns the array of characters
	public char [] getCharacters() 
	{
		return characters;
	}
	
	// Before : Takes in a String which is the text being analysed and the array of character, either
	//          the alphabet or non-letter characters
	// After : returns a hashmap which contains an entry for each character in the char array and an 
	//		   integer the number of times the letter occurs
	public HashMap<Character, Integer> letterFrequency(String input, char [] testCharacters)
	{
		// hashmap for the frequency of each letter in the array parameter
		HashMap<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
		
		// converting the string parameter into a char arrays
		char [] charArray = input.toLowerCase().toCharArray();
		
		// looping through each character in the testCharacters array and checking how many times
		// it occurs in the String parameter
		for(int i = 0; i < testCharacters.length; i++)
		{
			int frequency = timesCharOccurs(testCharacters[i], charArray);
			
			letterFrequency.put(testCharacters[i], frequency);
		}
		
		return letterFrequency;
	}
	
	// Before : Takes in a File or a char [] which is either the alphabet or non-letter characters
	// After : returns a hashmap which contains an entry for each character in the char array and an 
	//		   integer the number of times the letter occurs	
	public HashMap<Character, Integer> letterFrequency(File inputFile, char [] testCharacters) throws FileNotFoundException
	{
		// creating a connection to the file
		Scanner inputStream = new Scanner(new FileInputStream(inputFile));
		
		// creating a hahsmap to populate the character frequency
		HashMap<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
		
		// reading the first line of the file
		String fileString = inputStream.nextLine();
		
		// counter to count how many lines have been read.
		int counter = 0;
		
		// looping through the file while there are lines available
		while(inputStream.hasNextLine() || fileString.length() > 0)
		{			
			// loops until 50 lines of the file had been read building a string
			while(counter <= 50 && inputStream.hasNextLine())
			{
				fileString = fileString + '\n' + inputStream.nextLine();
				counter++;
			}
			
			// converting the string which was built into a char array
			char [] charArray = fileString.toLowerCase().toCharArray();
			
			// looping theough each character in char array parameter to check
			// if the character occurs in the string
			for(int i = 0; i < testCharacters.length; i++)
			{
				int frequency = timesCharOccurs(testCharacters[i], charArray);
				
				if(letterFrequency.containsKey(testCharacters[i]))
				{
					frequency = frequency + letterFrequency.get(testCharacters[i]);
					letterFrequency.put(testCharacters[i], frequency);
				}
				else
				{
					letterFrequency.put(testCharacters[i], frequency);
				}
			}
			
			// resetting the counter and the string variable to read in another 50 lines
			counter = 0;
			fileString = "";
		}
		
		return letterFrequency;
	}
	
	// Before : Takes in a character and an array of characters which is the text being processed 
	// After : returns an integer for the number of times the character occurs in the array
	public int timesCharOccurs(char charToCheck, char [] arrayOfChars)
	{
		int result = 0;
		
		for(char character : arrayOfChars)
		{
			if(charToCheck == character)
			{
				result++;
			}
		}
		
		return result;
	}
	
	// Before : Takes in a character and integer hashmap for the frequency of characters 
	// After : returns a hashmap with the relative frequency for each character
	public HashMap<Character, Double> getRelFrequency(HashMap<Character, Integer> frequency, String input)
	{
		// hashmap for the relative frequency
		HashMap<Character, Double> relative = new HashMap<Character, Double>();
		
		// looping through each key within the hashmap parameter
		for(char character : frequency.keySet())
		{
			// calculating the relative frequency 
			double relValue = ((double)frequency.get(character) / (double)input.length());
			
			// adding the relative frequency to the hashmap created earlier 
			relative.put(character, relValue);
		}
		
		return relative;
	}
	
	// Before : Takes in a character and integer hashmap for the frequency of characters 
		// After : returns a hashmap with the relative frequency for each character
		public HashMap<Character, Double> getRelFrequency(HashMap<Character, Integer> frequency, File inputFile) throws Exception
		{
			
			Scanner stream = null;
			try
			{
				stream = new Scanner(new FileInputStream(inputFile));
			}
			catch(FileNotFoundException ex)
			{
				throw ex;
			}
			
			// hashmap for the relative frequency
			HashMap<Character, Double> relative = new HashMap<Character, Double>();
			
			try
			{
				int characterCount = 0;
				int lineCount = 0;
				String contents = "";
				
				while(stream.hasNextLine())
				{
					contents = stream.nextLine();
					
					while(lineCount <= 50)
					{
						if(stream.hasNextLine())
						{
							contents = contents + stream.nextLine();
							lineCount++;
						}
						else
						{
							lineCount = 51;
						}
						
						
					}
					
					characterCount = characterCount + contents.length();
				
					// looping through each key within the hashmap parameter
					for(char character : frequency.keySet())
					{
						// calculating the relative frequency 
						double relValue = ((double)frequency.get(character) / (double)characterCount);
						
						// adding the relative frequency to the hashmap created earlier 
						relative.put(character, relValue);
					}
					
					lineCount = 0;
					contents = "";
				}
			}
			catch(Exception ex)
			{
				throw ex;
			}
			finally
			{
				stream.close();
			}
			
			return relative;
		}
	// Before : Takes in a File parameter 
	// After : returns an integer for the word count
	public int wordCount(File inputFile) throws FileNotFoundException
	{
		int wordCount = 0;
		
		Scanner stream = null;
		
		try 
		{
			// opening a connection to the file
			stream = new Scanner(new FileInputStream(inputFile));
						
			// a counter to count how many lines have been read
			int counter = 0;
			
			// loops through the file why their are lines are available 
			while(stream.hasNextLine())
			{
				// creating a string variable using the first line of the file
				String contents = stream.nextLine();
				
				// loops through 50 lines at a time
				while(counter <= 50 && stream.hasNextLine())
				{
					// adds each line to the string
					contents = contents + '\n' +stream.nextLine();
					counter++;
				}
				
				// splits the the string into an array where there are non-letter characters
				String [] wordList = contents.split("[\\W+]");
				
				// resetting the counter and the string variable to read in further lines
				counter = 0;
				contents = "";
				
				for(String word : wordList)
				{
					if(!(word.equals(" ") || word.equals("") || word.equals(null)))
					{
						wordCount++;
					}
				}
			}
		}
		catch(FileNotFoundException ex)
		{
			throw ex;
		}
		finally 
		{
			// closing the connection to the file
			stream.close();
		}

		return wordCount;
	}
	
	// Before : Takes in a String which is the input entered by the user
	// After : Returns an integer for the word count
	public int wordCount(String inputText)
	{
		// integer for the word count
		int wordCount = 0;
			
		// Splitting the String parameter into a String array
		String [] wordList = inputText.split("[\\W+]");
			
		for(String word : wordList)
		{
			if(!(word.equals(" ") || word.equals("") || word.equals(null)))
			{
				wordCount++;
			}
		}
		
		return wordCount;
	}
	
	// Before : Takes in a String parameter which is the text entered by the user
	// After : Returns a integer which is the length of the longest word
	public int maxWordLength(String inputText)
	{
		// Integer for the length of the longest word
		int maxLength = 0;
		
		// Splitting the string parameter into a string array
		String [] wordList = inputText.split("[\\W+]");
		
		// Looping through the String array of words checking if each
		// word is bigger than the last
		for(String word : wordList)
		{
			if(word.length() > maxLength)
			{
				maxLength = word.length();
			}
		}
		
		return maxLength;
	}
	
	// Before : Takes in a file parameter
	// After : returns an integer for the length of the longest word.
	public int maxWordLength(File inputFile) throws FileNotFoundException
	{
		int maxLength = 0;
		
		//Creating a Scanner variable to connect to the file
		Scanner stream = null;
		
		try 
		{
			// initialising the Scanner variable, creating a connection to the file
			stream = new Scanner(new FileInputStream(inputFile));
					
			// creating a counter to count how many lines have been read
			int counter = 0;
			
			// looping through the file where there are lines available
			while(stream.hasNextLine())
			{
				// reading the first line of the file
				String contents = stream.nextLine();
				
				// looping through 50 lines of the file at a time
				while(counter <= 50 && stream.hasNextLine())
				{
					// building the sting variable with the 50 lines being read
					contents = contents + '\n' +stream.nextLine();
					counter++;
				}
				
				// Splitting the lines read by each word 
				String [] wordList = contents.split("[\\W+]");
				
				// looping through the array and checking the length of each word
				for(String word : wordList)
				{
					if(word.length() > maxLength)
					{
						maxLength = word.length();
					}
				}
				
				// resetting the counter and the String variable to read the next 50 lines
				counter = 0;
				contents = "";
			}
		}
		catch(FileNotFoundException ex)
		{
			throw ex;
		}
		finally 
		{
			// closing the connection to the file
			stream.close();
		}

		return maxLength;
	}
	
	// Before : Takes in a File parameter
	// After : returns an integer for the length of the smallest word
	public int minWordLength(File inputFile) throws FileNotFoundException
	{
		// int variable to be used for the length of the smallest word
		int minLength = 0;
		
		// Scanner variable which will be used to create a connection to the file
		Scanner stream = null;
		
		try 
		{
			// initialising the Scanner variable
			stream = new Scanner(new FileInputStream(inputFile));
						
			// int variable for a counter to count the number of lines read
			int counter = 0;
			
			// looping through the lines of the file while they are available
			while(stream.hasNextLine())
			{
				// reading the first line of the file
				String contents = stream.nextLine();
				
				// reading 50 lines of the file at a time
				while(counter <= 50 && stream.hasNextLine())
				{
					// building a string variable for the lines read
					contents = contents + '\n' +stream.nextLine();
					counter++;
				}
				
				
				if(!(contents.equals("") || contents.equals(" ") || contents.equals(null)))
				{
					// splitting the lines read into individual words
					String [] wordList = contents.split("[\\W+]");
					
					
					// setting the minLength variable to the length of the first word
					if(minLength == 0)
					{
						minLength = wordList[minLength].length();
					}
					
					// looping through each word and checking if its the smallest word
					for(String word : wordList)
					{
						
						if(word.length() < minLength)
						{
							minLength = word.length();
						}
					}
									
					// resetting the counter and the String variable to read 50 more lines				
					counter = 0;
					contents = "";
				}	
			}
		}
		catch(FileNotFoundException ex)
		{
			throw ex;
		}
		finally 
		{
			// closing the connection to the file
			stream.close();
		}
		
		return minLength;
	}
	
	// Before : Takes in a String which is the text entered by the user
	// After : Returns an int for the length of the smallest word
	public int minWordLength(String inputText)
	{
		// int variable for the length of the word
		int minLength = 0;
		
		if(!(inputText.equals("") || inputText.equals(" ") || inputText.equals(null)))
		{
			// Splitting the String parameter into individual words
			String [] wordList = inputText.split("[\\W+]");
			
			// Setting int variable to the length of the first word
			if(minLength == 0)
			{
				minLength = wordList[minLength].length();
			}
			
			// Looping through the array of words checking their length
			for(String word : wordList)
			{
				if(!(word.equals("") || word.equals(" ") || word.equals(null)))	
				{
					if(word.length() < minLength)
					{
						minLength = word.length();
					}
				}
			}
		}
				
		return minLength;
	}
	
	// Before : Takes in a file parameter
	// After : Returns an integer the number of sentences
	public int sentenceCount(File inputFile) throws FileNotFoundException
	{
		// Variable to count the number of lines read from the file
		int count = 0;
		
		// Scanner variable to be used to open a connection to the file
		Scanner stream = null;
		
		try 
		{
			// Creating a connection to the file
			stream = new Scanner(new FileInputStream(inputFile));
						
			// int variable which will be used to count the number of sentences
			int counter = 0;
			
			// Looping through each line in the file
			while(stream.hasNextLine())
			{
				// Reading the first line of the file
				String contents = stream.nextLine();
				
				// Looping through 50 lines of the file at a time
				while(counter <= 50 && stream.hasNextLine())
				{
					// Building a string using the lines being read
					contents = contents + '\n' +stream.nextLine();
					counter++;
				}
				
				// Splitting the string into individual sentences
				String [] sentenceList = contents.split("[\\.\\?\\!]");
				
				// Looping through the array of sentences and checking they are valid
				// before incrementing the count
				for(String sentence : sentenceList)
				{
					if(!(sentence.equals(null) || sentence.equals(" ") || sentence.equals("")))
					{
						count++;
					}
				}
					
				// Resetting the counter and string variable to read another 50 lines
				counter = 0;
				contents = "";
			}
		}
		catch(FileNotFoundException ex)
		{
			// Throwing an exception if one is caught
			throw ex;
		}
		finally 
		{
			// Closing the connection to the file
			stream.close();
		}
		
		return count;
	}
	
	// Before : Takes in a string parameter which is the input from the user
	// After :  returns an int representing the sentence count
	public int sentenceCount(String inputText)
	{
		// int variable for the sentence count.
		int count = 0;
				
		// Splitting the string into sentences and putting them into an array
		String [] sentenceList = inputText.split("[\\.\\?\\!]");
				
		// Looping through the array and checking if it its a valid sentence, if it is
		// the counter is incremented
		for(String sentence : sentenceList)
		{
			if(!(sentence.equals(null) || sentence.equals(" ") || sentence.equals("")))
			{
				if(!(sentence.startsWith("\n ") && sentence.length() <= 2))
				{
					count++;
				}
			}
		}
	
		return count;
	}
	
	// Before : Takes in a File parameter
	// After : returns an int representing the line count
	public int lineCount(File inputFile) throws FileNotFoundException
	{
		// int variable for the line count
		int count = 0;
		
		// Scanner variable which will be used to open a connection to the file
		Scanner stream = null;
		
		try 
		{
			// Creating a connection to the file
			stream = new Scanner(new FileInputStream(inputFile));
						
			// a counter to count how many lines of the file have been read
			int counter = 0;
			
			// an array list for each line f 
			ArrayList<String> lineList = new ArrayList<String>();
			
			String contents = stream.nextLine();
			
			lineList.add(contents);
			
			// Looping through each line of the file and incrementing the counter
			while(stream.hasNextLine())
			{
				while(counter <= 50 && stream.hasNextLine())
				{
					lineList.add(stream.nextLine());
					counter++;
				}
								
				counter = 0;
				contents = "";
			}
			
			count = count + lineList.size();
		}
		catch(FileNotFoundException ex)
		{
			// throwing exception
			throw ex;
		}
		finally 
		{
			// closing the connection to the file
			stream.close();
		}
		
		return count;
	}
	
	// Before : Takes in a  String paramter which is the text entered by the user
	// After : Returns an int which represents the number of lines.
	public int lineCount(String inputText)
	{ 
		// int variable for the line count
		int count = 0;
		
		if(!(inputText.equals("") || inputText.equals(null)))
		{
			// splitting the string by the new line character
			String [] lineArray = inputText.split("\n");
					
			// setting the line count based on the length of the array
			count = lineArray.length;

		}
				
		// returning the count
		return count;
	}
}
