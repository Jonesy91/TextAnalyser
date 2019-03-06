package textAnalyser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class FileInput 
{
	// File variable to represent the file which the user specifies
	private File inputFile;
	
	// Class constructor to initialise the inputFile variable
	// takes in the path entered by the user
	public FileInput(String filePath) throws Exception
	{
		// initialising the inputFile variable
		inputFile = new File(filePath);		
		
		// Checking the file exists be opening and closing a connection to the file
		try
		{
			Scanner inputStream = new Scanner(new FileInputStream(inputFile));
			inputStream.close();
		}
		// Catching the FileNotFoundException if if the file isn't found
		catch(FileNotFoundException ex )
		{
			throw ex;
		}
	}
	
	// Method to get the representation of the file
	public File getFile()
	{
		return inputFile;
	}
	
	// toString method which returns the path of the file
	public String toString()
	{
		return inputFile.toString();
	}
}
