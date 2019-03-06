package textAnalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public interface IAnalysis 
{
	public char [] getAlphabet();
	
	public char [] getCharacters();
	
	public HashMap<Character, Integer> letterFrequency(String input, char [] testCharacters);
	
	public HashMap<Character, Integer> letterFrequency(File inputFile, char [] testCharacters) throws FileNotFoundException;
	
	public HashMap<Character, Double> getRelFrequency(HashMap<Character, Integer> frequency, String input);
	
	public HashMap<Character, Double> getRelFrequency(HashMap<Character, Integer> frequency, File inputFile)throws Exception;
	
	public int wordCount(File inputFile) throws FileNotFoundException;
	
	public int wordCount(String inputText);
	
	public int maxWordLength(String inputText);
	
	public int maxWordLength(File inputFile) throws FileNotFoundException;
	
	public int minWordLength(File inputFile) throws FileNotFoundException;
	
	public int minWordLength(String inputText);
	
	public int sentenceCount(File inputFile) throws FileNotFoundException;
	
	public int sentenceCount(String inputText);
	
	public int lineCount(File inputFile) throws FileNotFoundException;
	
	public int lineCount(String inputText);
}
