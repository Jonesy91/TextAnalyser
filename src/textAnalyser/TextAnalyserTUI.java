package textAnalyser;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class TextAnalyserTUI 
{	
	public static void main(String[] args) throws FileNotFoundException
	{
		// Creating a null variable for a text analyser
		TextAnalyser analyser = null;
		
		// int variable for the function to be selected by the user
		int selectedFunction = 0;
		
		// int variable for the analysis to be selected by the user
		int selectedAnalysis = 0;
		
		// String variable which will be used to decide if a user would like a new input
		String furtherInput = "Y";
		
		// int variable for the type of output selected by the user 
		int outputType = 0;
		
		// Boolean variable to check if the user would like more analysis
		boolean moreAnalysis = true;
		
		// Creating a scanner to get user input
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("+-----------------------------------------------+");
   	    System.out.println("|                  Welcome                      |");
   	    System.out.println("|             Text Analyser v1.0                |");
   	    System.out.println("+-----------------------------------------------+");
		
		// Loops while the user wants to process an input 
		while(furtherInput.equals("Y"))
		{
			// Asking the user to select a function
			System.out.println("+-----------------------------------------------+");
			System.out.println("| Please select a function from the menu below  |");
			System.out.println("+-----------------------------------------------+");
			System.out.println("(1) Analyse File\t(2) Analyse Keyboard Input\t(3) Demo\t(4) Quit"); 
			
			try 
			{
				// Variable for the chosen function
				selectedFunction = Integer.parseInt(keyboard.next());
				keyboard.nextLine();
				
				if(!(selectedFunction >= 1 && selectedFunction <= 4))
				{
					System.out.println("Invalid option " + selectedFunction );
					moreAnalysis = false;
				}	
			
				// Checking which function was selected
				if(selectedFunction == 1)
				{
					System.out.println("+-----------------------------------------------+");
					System.out.println("|    Please enter the full path to the file     |");
					System.out.println("+-----------------------------------------------+");
					String filePath = keyboard.next();
					analyser = new TextAnalyser(selectedFunction,filePath);
				}
				if(selectedFunction == 2)
				{
					System.out.println("+-----------------------------------------------+");
					System.out.println("|     Please enter the text to be processed     |");
					System.out.println("+-----------------------------------------------+");
					String text = keyboard.nextLine();
					// Creating a TextAnalyser to analyse the user input
					analyser = new TextAnalyser(selectedFunction,text);
				}
				if(selectedFunction == 3)
				{
					System.out.println("+-----------------------------------------------+");
					System.out.println("|                Starting Demo                  |");
					System.out.println("+-----------------------------------------------+");
			        analyser = new TextAnalyser(selectedFunction,null);
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.toString());
				furtherInput = "Y";
			}
			
			if(selectedFunction == 1 || selectedFunction == 2)
			{
				// Loop to ask the user which analysis they would like while
				// moreAnalysis variable is equal to true
				while(moreAnalysis)
				{
					boolean validInput = false;
					
					int counter = 1;
										
					while(!(validInput))
					{
						// Asking the user to select an analysis type
						System.out.println("+-----------------------------------------------+");
						System.out.println("|       Please select a type of analysis        |");
						System.out.println("+-----------------------------------------------+");
						System.out.print("(1) Word Count\t\t");
						System.out.print("(2) Max Word Length\t");
						System.out.println("(3) Min Word Length");
						System.out.print("(4) Sentence Count\t");
						System.out.print("(5) Letter Frequency\t");
						System.out.println("(6) Non-letter Frequency");		
						System.out.println("(7) Line Count");		
						
						try
						{
							// Getting input from the user 
							selectedAnalysis = Integer.parseInt(keyboard.next());  
							keyboard.nextLine();
							
							if(selectedAnalysis < 1 || selectedAnalysis > 7)
							{
								throw new Exception();
							}
							else
							{
								validInput = true;
							}
						}
						catch(Exception ex)
						{
							
							validInput = false;
							
							if(counter > 2)
							{
								System.out.println("Too many incorrect entries, closing application");
								System.exit(1);
							}
							else
							{
								System.out.println("Please enter a number between 1 & 7");
								System.out.println("Attempt " + counter + " of 3");
								counter++;
							}
							
						}
					}
					
					counter = 1;
					boolean validOutput = false;
					
					// loops 4 times until there is a valid input entered
					while(!(validOutput))
					{

						// Asking the user how they would like to view the results
						System.out.println("+-----------------------------------------------+");
						System.out.println("|    How would you like to view the results?    |");
						System.out.println("+-----------------------------------------------+");
						System.out.print("(1) Table\t");
						System.out.println("(2) Bar Chart");
						
						try 
						{
							// Getting the input and getting the integer 
							outputType =  Integer.parseInt(keyboard.next());
							keyboard.nextLine();
							
							if(outputType < 1 || outputType > 2 )
							{
								throw new Exception();
							}
							else
							{
								validOutput = true;
							}
							
						}
						catch(Exception ex)
						{
							// Giving the user 3 attempts to enter a valid input before closing 
							// the application
							if(counter == 3)
							{
								System.out.println("Too many incorrect inputs, ending application");
								System.exit(1);
							}
							else
							{
								System.out.println("Please enter either 1 or 2");
								counter++;
								System.out.println("Attempt " + counter + " of 3");
							}
						}
						
					}
					
						try 
						{
						
						switch(selectedAnalysis)
						{
						// Getting the word count and displaying the results in a table or bar chart
							case 1 : System.out.println("\nCalculating word count");
									 int count = analyser.getWordCount(selectedFunction);
									 if(outputType == 1)
									 {
										 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|                Word Count Table               |");
									   	 System.out.println("+-----------------------------------------------+");
										 singleRowTable("Word Count", count);
									 }
									 else if(outputType == 2)
									 {
										 HashMap<String, Integer> wordCountMap = new HashMap<String,Integer>();
										 wordCountMap.put("Word Count", count);
										 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|             Word Count Bar Chart              |");
									   	 System.out.println("+-----------------------------------------------+");
										 strBarChart(wordCountMap);
									 }
							break;
							// Getting the length of the biggest word  and displaying the results in a table or bar chart
							case 2 :System.out.println("\nCalculating max word length"); 
									int maxLength = analyser.getMaxWordLength(selectedFunction);
									 if(outputType == 1)
									 {
									   	 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|             Max Word Length Table             |");
									   	 System.out.println("+-----------------------------------------------+");
										 singleRowTable("Max Word Length", maxLength);
									 }
									 else if(outputType == 2)
									 {
										 HashMap<String, Integer> maxLengthMap = new HashMap<String,Integer>();
										 maxLengthMap.put("Max Word Length", maxLength);
									   	 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|          Max Word Length Bar Chart            |");
									   	 System.out.println("+-----------------------------------------------+");
										 strBarChart(maxLengthMap);
									 }
							break;
							// Getting the length of the smallest word and displaying the results in a table or bar chart
							case 3 : System.out.println("\nCalculating min word length");
									 int minLength = analyser.getMinWordLength(selectedFunction);
									 if(outputType == 1)
									 {
										 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|             Min Word Length Table             |");
									   	 System.out.println("+-----------------------------------------------+");
										 singleRowTable("Min Word Length", minLength);
									 }
									 else if(outputType == 2)
									 {
										 HashMap<String, Integer> minLengthMap = new HashMap<String,Integer>();
										 minLengthMap.put("Max Word Length", minLength);
										 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|          Min Word Length Bar Chart            |");
									   	 System.out.println("+-----------------------------------------------+");
										 strBarChart(minLengthMap);
									 }
							break;
							// Getting the sentence count and displaying the results in a table or a bar chart
							case 4 : System.out.println("\nCalculating sentence count");
									 int sentenceCount = analyser.getSentenceCount(selectedFunction);
									 if(outputType == 1)
									 {
										 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|             Sentence Count Table              |");
									   	 System.out.println("+-----------------------------------------------+");
										 singleRowTable("Sentence Count", sentenceCount);
									 }
									 else if(outputType == 2)
									 {
										 HashMap<String, Integer> sentenceCountMap = new HashMap<String,Integer>();
										 sentenceCountMap.put("Max Word Length", sentenceCount);
										 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|              Sentence Bar Chart               |");
									   	 System.out.println("+-----------------------------------------------+");
										 strBarChart(sentenceCountMap);
									 }
							break;
							// Getting the letter freuquencies and printing out the results in a table or
							// a bar chart
							case 5 : System.out.println("\nCalculating letter frequencies");
							  	     HashMap<Character, Integer> letterFrequency = analyser.getCharFrequency(0);
							   	     HashMap<Character, Double> ltrRelFrequency = analyser.getRelFrequency(letterFrequency);
							   	     if(outputType == 1)
							   	     {
							   	    	System.out.println("+-----------------------------------------------+");
									   	System.out.println("|            Letter Frequency Table             |");
									   	System.out.println("+-----------------------------------------------+");
							   	    	characterTable(letterFrequency, ltrRelFrequency);
							   	     }
							   	     else if (outputType == 2)
							   	     {
							   	    	 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|          Letter Frequency Bar Chart           |");
									   	 System.out.println("+-----------------------------------------------+");
							   	    	 charBarChart(letterFrequency);
							   	     }
							break;
							// Getting non-letter frequencies and printing out the results in a table or 
							// bar chart
							case 6 : System.out.println("\nCalculating non-letter frequencies");
									 HashMap<Character, Integer> charFrequency = analyser.getCharFrequency(1);
									 HashMap<Character, Double> charRelFrequency = analyser.getRelFrequency(charFrequency);
							      	if(outputType == 1)
							   	     {
							      		System.out.println("+-----------------------------------------------+");
									   	System.out.println("|          Non-Letter Frequency Table           |");
									   	System.out.println("+-----------------------------------------------+");
							   	    	characterTable(charFrequency, charRelFrequency);
							   	     }
							   	     else if (outputType == 2)
							   	     {
							   	    	 System.out.println("+-----------------------------------------------+");
									   	 System.out.println("|        Non-Letter Frequeny Bar Chart          |");
									   	 System.out.println("+-----------------------------------------------+");
							   	    	 charBarChart(charFrequency);
							   	     }
							break;
							
							// Getting non-letter frequencies and printing out the results in a table or 
							// bar chart
							case 7 : System.out.println("\nCalculating line count");
									 int lineCount = analyser.getLineCount(selectedFunction);
							      	if(outputType == 1)
							   	     {
							      		System.out.println("+-----------------------------------------------+");
									   	System.out.println("|                Line Count Table               |");
									   	System.out.println("+-----------------------------------------------+");
							   	    	singleRowTable("Line Count", lineCount);
							   	     }
							   	     else if (outputType == 2)
							   	     {
							   	    	 System.out.println("+-----------------------------------------------+");
							   	    	 System.out.println("|                Line Count Table               |");
									   	 System.out.println("+-----------------------------------------------+");
							   	    	 HashMap<String,Integer> lineCountResult = new HashMap<String,Integer>();
							   	    	 lineCountResult.put("Line Count", lineCount);
									   	 strBarChart(lineCountResult);
							   	     }
							break;
							}
						}
						catch(Exception ex)
						{
							// Writing out the exception 
							System.out.println(ex.toString());
							System.out.println(ex.getCause());
						}
						finally
						{
							String furtherAnalysis = "";
							while(!(furtherAnalysis.equals("Y") || furtherAnalysis.equals("N")))
							{
								// Asking the user if they would like more analysis
								System.out.println("+-----------------------------------------------+");
								System.out.println("|      Would like further analysis? (Y/N)       |");
								System.out.println("+-----------------------------------------------+");
								furtherAnalysis = keyboard.next().toUpperCase();
										
								//Checking whether the user entered Y or N
								if(!(furtherAnalysis.equals("Y") || furtherAnalysis.equals("N")))
								{
									System.out.println("Please enter Y for further analysis or N to quit");
								}
								if(furtherAnalysis.equals("Y"))
								{
									moreAnalysis = true;
								}
								else if (furtherAnalysis.equals("N"))
								{
									moreAnalysis = false;							
								}
							}
						}
					}
			}
			// Running through each function available for the demo
			if(selectedFunction == 3)
			{	
	      	    moreAnalysis = false;
				
				try
				{
	      	    // Getting the letter frequency and displaying in a table and bar chart
	      	    System.out.println("Calculating letter frequencies...");
		   	    HashMap<Character, Integer> letterFrequency = analyser.getCharFrequency(0);
		   	    HashMap<Character, Double> ltrRelFrequency = analyser.getRelFrequency(letterFrequency);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|             Letter Frequency Table            |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    characterTable(letterFrequency, ltrRelFrequency);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|           Letter Frequency Bar Chart          |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    charBarChart(letterFrequency);
		   	    
		   	    // Getting non-letter frequency and displaying the results in a table and bar chart
		   	    System.out.println("\nCalculating non-letter frequencies...");
		   	    HashMap<Character, Integer> charFrequency = analyser.getCharFrequency(1);
		   	    HashMap<Character, Double> charRelFrequency = analyser.getRelFrequency(charFrequency);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|          Non-Letter Frequency Table           |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    characterTable(charFrequency, charRelFrequency);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|        Non-Letter Frequency Bar Chart         |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    charBarChart(charFrequency);
		   	    
		   	    // Getting the word count and displaying the result in a table and bar chart
		   	    System.out.println("\nCalculating word count...");
		   	    int count = analyser.getWordCount(selectedFunction);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|               Word Count Table                |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    singleRowTable("Word Count", count);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|             Word Count Bar Chart              |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    HashMap<String, Integer> wordCountMap = new HashMap<String,Integer>();
		   	    wordCountMap.put("Word Count", count);
		   	    strBarChart(wordCountMap);
		   	    
		   	    // Getting the length of the longest word and displaying the results in a 
		   	    // table and bar chart
		   	    System.out.println("\nCalculating the length of the longest word...");
		   	    int maxLength = analyser.getMaxWordLength(selectedFunction);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|             Max Word Length Table             |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    singleRowTable("Max Word Length", maxLength);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|           Max Word Length Bar Chart           |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    HashMap<String, Integer> maxLengthMap = new HashMap<String,Integer>();
		   	    maxLengthMap.put("Max Word Length", maxLength);
		   	    strBarChart(maxLengthMap);

		   	    // Getting the length of the smallest word and displaying the results in 
		   	    // a table and a bar chart
		   	    System.out.println("\nCalculating the length of the shortest word...");
		   	    int minLength = analyser.getMinWordLength(selectedFunction);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|             Min Word Length Table             |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    singleRowTable("Min Word Length", minLength);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|           Min Word Length Bar Chart           |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    HashMap<String, Integer> minLengthMap = new HashMap<String,Integer>();
		   	    minLengthMap.put("Max Word Length", minLength);
		   	    strBarChart(minLengthMap);

		   	    // Getting the number of sentences and displaying the results in a table
		   	    // or a bar chart
		   	    System.out.println("\nCalculating sentence count...");
		   	    int sentenceCount = analyser.getSentenceCount(selectedFunction);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|             Sentence Count Table              |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    singleRowTable("Sentence Count", sentenceCount);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|            Sentence Count Bar Chart           |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    HashMap<String, Integer> sentenceCountMap = new HashMap<String,Integer>();
		   	    sentenceCountMap.put("Sentence Count", sentenceCount);
		   	    strBarChart(sentenceCountMap);
		   	    
		   	    // Getting the number of lines and displaying the results in a table
		   	    // or a bar chart
		   	    System.out.println("\nCalculating line count...");
		   	    int lineCount = analyser.getLineCount(selectedFunction);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|                Line Count Table               |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    singleRowTable("Sentence Count", lineCount);
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|               Line Count Bar Chart            |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    HashMap<String, Integer> lineCountMap = new HashMap<String,Integer>();
		   	    lineCountMap.put("Sentence Count", lineCount);
		   	    strBarChart(lineCountMap);
				}
				catch(Exception ex)
				{
					System.out.println(ex.toString());
				}
			}
			// Exiting the application
			if(selectedFunction == 4)
			{
				System.out.println("+-----------------------------------------------+");
		   	    System.out.println("|               Closing application             |");
		   	    System.out.println("+-----------------------------------------------+");
		   	    System.exit(0);
			}
			
			// Asking the user if they would like to process another input
			System.out.println("+-----------------------------------------------+");
			System.out.println("|Would you like to process another input? (Y/N) |");
			System.out.println("+-----------------------------------------------+");
			furtherInput = keyboard.next().toUpperCase();
			
			if(furtherInput.equals("Y"))
			{
				moreAnalysis = true;
			}
			
			// Creating a counter
			int count = 0;
			
			//Checking whether the user entered Y or N, user has 3 attempts to enter 
			// a valid input or the application will end
			while(!(furtherInput.equals("Y") || furtherInput.equals("N")))
			{
				System.out.println("Please enter Y to select another input or N to quit...");
				furtherInput = keyboard.next().toUpperCase();
				count++;
				
				if(count > 2)
				{
					System.out.println("Too many incorrect entries closing application");
					furtherInput = "N";
					break;
				}
			}
			
		}
		
		System.out.println("+-----------------------------------------------+");
   	    System.out.println("|               Closing application             |");
   	    System.out.println("+-----------------------------------------------+");
   	    System.exit(0);
	}

	// Before: takes in a a string for the table heading and and integer for the result
	// After: Displays a single row table, one column with the heading and the other with the result
	public static void singleRowTable(String heading, int output)
	{	
		// Converting the integer parameter to a string to get the character length
		String strIntLength = Integer.toString(output);
		int printCount = heading.length() + 2;
		
		// String variable for the horizontal line of the table
		String horizontal = "+";

		// Building the horizontal line depending on the length of the heading and value
		for(int a = 0; a <= printCount - 1; a++)
		{
			horizontal = horizontal + "-";
		}
			
		horizontal = horizontal + "+";
		
		for(int b = 0; b <= strIntLength.length() + 1; b++)
		{
			horizontal = horizontal + "-";
		}
		
		horizontal = horizontal + "+";
		
		// Displaying the length of the table
		System.out.println(horizontal);
		System.out.println("| " + heading + " | " + output + " |" );
		System.out.println(horizontal);
	}
	
	// Before : Takes in a a hashmap with the letter frequency and another with the relative frequency
	// After : Displays a table with the frequency and relative frequency of characters
	public static void characterTable(HashMap <Character, Integer> frequency,  HashMap<Character, Double> relFrequency)
	{
		// Setting variables for the structure of the table
		String horizontal = "+------------+-----------+--------------------+";
		String vertical = "|";
		
		// Setting variables for the headers
		String heading1 = " Character  ";
		String heading2 = " Frequency ";
		String heading3 = " Relative Frequency ";
		
		// Printing the header row to the console
		System.out.println(horizontal);
		System.out.println(vertical + heading1 + vertical + heading2 + vertical + heading3 + vertical);
		System.out.println(horizontal);
				
		// Looping through the hashmap
		for(char character : frequency.keySet())
		{	
			// String variables for each column value
			String column1 = "|" + " " + character + "          " + "|";
			String column2 = " " + frequency.get(character) + " ";
			String column3 = " " + relFrequency.get(character) + " ";
			
			// printing out a row for the first column
			System.out.print(column1);
			
			// Calculating the number of white spaces needed to for the column width
			// for column 2 and printing out a value
			if(heading2.length() > column2.length())
			{
				int dif = heading2.length() - column2.length();
				
				System.out.print(column2);
				
				for(int i = dif; i != 0; i--)
				{
					System.out.print(" ");
				}
				
				System.out.print(vertical);
			}
			else
			{
				System.out.print(vertical);
			}
			
			// Calculating the number of white spaces needed to for the column width
			// for column 3 and printing out a value
			if(heading3.length() > column3.length())
			{
				int dif = heading3.length() - column3.length();
				
				System.out.print(column3);
				
				for(int i = dif; i != 0; i--)
				{
					System.out.print(" ");
				}
				
				System.out.println(vertical);
			}
			else
			{
				System.out.print(vertical);
			}
			
			// Printing out the horizontal line of the table
			System.out.println(horizontal);
		}	
	}
	
	// Before : Takes in a hashmap with a character key and an integer value 
	// After : displays  a bar chart showing the results passed in
	public static void charBarChart(HashMap <Character, Integer> results)
	{
		// Loops through the hashmap to print out the heading and 
		// asterix's depending on the integer value
		for(char character : results.keySet())
		{
			System.out.print(character + " | ");
			
			for(int i = results.get(character); i > 0; i--)
			{
				System.out.print("*");
			}
		
			System.out.println(" ");
		}
	}
	
	// Before : Takes in a hashmap with a string and an integer 
	// After : Displays a bar char using the hashmap passed in
	public static void strBarChart(HashMap <String, Integer> results)
	{
		// Loops through the hashmap to print out the heading and 
		// asterix's depending on the integer value
		for(String string : results.keySet())
		{
			System.out.print(string + " | ");
			
			for(int i = results.get(string); i > 0; i--)
			{
				System.out.print("*");
			}
		
			System.out.println(" ");
		}
	}
}
