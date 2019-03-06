package textAnalyser;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class TextAnalyser 
{
	// Demo variable to create an instance of the Demo class
	private Demo demoInput;
	
	// DynamicInput variable to create an instance of the DynamicInput class 
	private DynamicInput dynamicInput;
	
	// FileInpput variable to create an instance of the FileInput class
	private FileInput fileInput;
	
	// IAnalysis variable to create an instance of the interface IAnalysis
	private IAnalysis iAnalysis;
	
	// Before : the constructor takes in an integer for the selected function
	//			and a string for either the text input or a file path
	// After : Creates and instance of either the FileInput,DynamicInput or DemoInput classes
	public TextAnalyser(int function,String userInput) throws Exception
	{
		// Creating a Scanner variable 
		Scanner keyboard = new Scanner(System.in);
		
		// Initialising the iAnalysis variable to create an instance of the interface
		iAnalysis = new Analysis();
		
		try 
		{
			// A switch on the function variable to decide which class to create an instance of
			switch(function)
			{
				case 1 :  fileInput = new FileInput(userInput);	
				break;
				case 2 :  dynamicInput = new DynamicInput(userInput);
				break;
				case 3 : demoInput = new Demo();
				break;
			}
			
			if(function < 1 || function > 3)
			{
				throw new Exception("Invalid function selected " + function);
			}
		}
		catch(Exception ex) 
		{
			throw ex;
		}
	}
		
	// Before : Takes in an integer to identify whether to get letters or characters
	// After : returns a hashmap with the characters and their frequency
	public HashMap<Character, Integer> getCharFrequency(int identifier) throws Exception
	{
		try
		{
			if(identifier < 0 || identifier > 1)
			{
				throw new Exception("Invalid selection " + identifier);
			}
			else
			{
				// if identifier is 0 the method gets the alphabet
				if(identifier == 0)
				{
					char [] alphabet = iAnalysis.getAlphabet();
					
					// Checking which variable has been initialised to check which method to call
					if(dynamicInput != null)
					{
						return iAnalysis.letterFrequency(dynamicInput.getDynamicInput(), alphabet);
					}
					else if (fileInput != null)
					{
						return iAnalysis.letterFrequency(fileInput.getFile(), alphabet);
					}
					else
					{	
						return iAnalysis.letterFrequency(demoInput.getDemoInput(), alphabet);
					}
				}
				// Identifier was not 0 the method gets a list of characters
				else 
				{
					char [] characters = iAnalysis.getCharacters();
					
					// Checking which variable has been initialised to check which method to call
					if(dynamicInput != null)
					{
						return iAnalysis.letterFrequency(dynamicInput.getDynamicInput(), characters);
					}
					else if (fileInput != null)
					{
						return iAnalysis.letterFrequency(fileInput.getFile(), characters);
					}
					else
					{
						return iAnalysis.letterFrequency(demoInput.getDemoInput(), characters);
					}
				}
			}
		}
		catch(Exception ex)
		{
			throw ex;	
		}
	}
		
	// Before : Takes in a hashmap with characters and integers
	// After : returns a hashmap with characters and doubles which are relative frequencies
	public HashMap<Character, Double> getRelFrequency(HashMap<Character, Integer> reqFrequency) throws Exception
	{
		HashMap<Character,Double> relFrequency = new HashMap<Character,Double>();
		
		try
		{
			if(demoInput != null)
			{
				// Getting the relative frequency
				relFrequency = iAnalysis.getRelFrequency(reqFrequency, demoInput.getDemoInput());
			}
			else if (dynamicInput != null)
			{
				// Getting the relative frequency
				relFrequency = iAnalysis.getRelFrequency(reqFrequency, dynamicInput.getDynamicInput());
			}
			else
			{
				// Getting the relative frequency
				relFrequency = iAnalysis.getRelFrequency(reqFrequency, fileInput.getFile());
			}
			
			// formatting the relative frequency value to 4 decimal places
			for(char character : relFrequency.keySet())
			{
				double relFormatted = Double.parseDouble(new DecimalFormat("##.####").format(relFrequency.get(character)));
				
				relFrequency.put(character, relFormatted);
			}
			
			return relFrequency;

		}
		catch(Exception ex)
		{
			throw ex;
		}	
	}
	
	// Before : Takes in an integer to decide whether to get letters or characters
	// After : returns a char array of either the alphabet or characters
	public char [] getCharacters(int identifier) throws Exception
	{
		try
		{
			if(identifier < 0 || identifier > 1)
			{
				throw new Exception("Invalid identifier " + identifier);
			}
			else
			{
				if(identifier == 0)
				{
					return iAnalysis.getAlphabet();
				}
				else
				{
					return iAnalysis.getCharacters();
				}
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		
	}
	
	// Before : Takes in an integer which decides which method to call  
	// After : returns an integer representing the word count
	public int getWordCount(int inputType) throws Exception
	{
		int wordCount = 0;
		
		try 
		{
			if(inputType < 1 || inputType > 3)
			{
				throw new Exception("Invalid input type " + inputType);
			}
			else
			{
				// Checking which method to call depending on the parameter passed in
				switch(inputType)
				{
					case 1: wordCount = iAnalysis.wordCount(fileInput.getFile());
					break;
					case 2: wordCount = iAnalysis.wordCount(dynamicInput.getDynamicInput());
					break;
					case 3: wordCount = iAnalysis.wordCount(demoInput.getDemoInput());
					break;
				}
			}
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		return wordCount;
	}
	
	// Before : Takes in an integer to decide which method to call
	// After : Returns an integer for length of the longest word
	public int getMaxWordLength(int inputType) throws Exception
	{
		int maxLength = 0;
		
		try
		{
			if(inputType < 1 || inputType > 3)
			{
				throw new Exception("Invalid input type " + inputType);
			}
			else
			{
				// Deciding which method to call based on the parameter passed in
				switch(inputType)
				{
					case 1: maxLength = iAnalysis.maxWordLength(fileInput.getFile());
					break;
					case 2: maxLength = iAnalysis.maxWordLength(dynamicInput.getDynamicInput());
					break;
					case 3: maxLength = iAnalysis.maxWordLength(demoInput.getDemoInput());
					break;
				}
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}

		
		return maxLength;
	}
	
	// Before : Takes in an integer to decide which method to call
	// After : Returns an integer for the length of the smallest word
	public int getMinWordLength(int inputType) throws Exception
	{
		int minLength = 0;
		
		try 
		{
			if(inputType < 1 || inputType > 3)
			{
				throw new Exception("Invalid input type " + inputType);
			}
			else
			{
				// Deciding which method to call
				switch(inputType)
				{
					case 1: minLength = iAnalysis.minWordLength(fileInput.getFile());
					break;
					case 2: minLength = iAnalysis.minWordLength(dynamicInput.getDynamicInput());
					break;
					case 3: minLength = iAnalysis.minWordLength(demoInput.getDemoInput());
					break;
				}
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		return minLength;
	}
	
	// Before : Takes in an integer to decide which method to call
	// After : Returns an integer for the sentence count
	public int getLineCount(int inputType) throws Exception
	{
		int sentenceCount = 0;
		
		try
		{
			if(inputType < 1 || inputType > 3)
			{
				throw new Exception("Invalid input type " + inputType);
			}
			else
			{
				// Deciding which method to call
				switch(inputType)
				{
					case 1: sentenceCount = iAnalysis.lineCount(fileInput.getFile());
					break;
					case 2 : sentenceCount = iAnalysis.lineCount(dynamicInput.getDynamicInput());
					break;
					case 3 : sentenceCount = iAnalysis.lineCount(demoInput.getDemoInput());
					break;
				}
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return sentenceCount;
	}
	
	// Before : Takes in an integer to decide which method to call
		// After : Returns an integer for the sentence count
		public int getSentenceCount(int inputType) throws Exception
		{
			int sentenceCount = 0;
			
			try
			{
				if(inputType < 1 || inputType > 3)
				{
					throw new Exception("Invalid input type " + inputType);
				}
				else
				{
					// Deciding which method to call
					switch(inputType)
					{
						case 1: sentenceCount = iAnalysis.sentenceCount(fileInput.getFile());
						break;
						case 2 : sentenceCount = iAnalysis.sentenceCount(dynamicInput.getDynamicInput());
						break;
						case 3 : sentenceCount = iAnalysis.sentenceCount(demoInput.getDemoInput());
						break;
					}
				}
			}
			catch(Exception ex)
			{
				throw ex;
			}
			
			return sentenceCount;
		}
		
		public FileInput getFileInput()
		{
			return fileInput;
		}
		
		public Demo getDemo()
		{
			return demoInput;
		}
		
		public DynamicInput getDynamicInput()
		{
			return dynamicInput;
		}
}

