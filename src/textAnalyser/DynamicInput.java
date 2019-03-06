package textAnalyser;

public class DynamicInput 
{
	// String variable for the text entered by the user
	private String dynamicInput;
	
	// Class constructor to initialise the dynamicInput variable with the text entered by the user
	public DynamicInput(String reqInput)
	{
		dynamicInput = reqInput;
	}
	
	// Method to return the text which the user entered
	public String getDynamicInput()
	{
		return dynamicInput;
	}
	
	// tostring method to return the user input
	public String toString()
	{
		return dynamicInput;
	}
}


