package designPatternsAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * This class is the regex analysis method implementation 
 * for our Strategy Interface Analyzer 
 * @author thanos-pakou
 *
 */
public class RegexAnalyzer implements Analyzer{
	
	/**
	 * Gets a string list with non-empty code lines and 
	 * calculates loc, noc, nom using regular expressions
	 * @param srcLines
	 * @return listForCsv
	 */
	public List<String> codeAnalyse(List<String> srcLines) {
		// Initializes the return List
		List<String> listForCsv = new ArrayList<String>();
		
		// Declares main comment pattern
		Pattern patComments = Pattern.compile("^\\*.*|//.*|/\\*.*");
		
		/*
		 * Initializes our metrics loc(Lines of code),
		 * noc(Number of classes), nom(Number of methods)
		 */
		int loc = 0;
		int noc = 0;
		int nom = 0;
		
		// Variable to check if the loop is inside a multiple line comment
		boolean multLine = false;
		
		// Looping through the lines of code
		for (String line: srcLines) {
			Matcher matcher = patComments.matcher(line);
			// If line is not a comment
			if (!matcher.matches()) {
				if (multLine == false) {
					// Regex for checking if line represents the beginning of a class
					if (line.matches("(?:\\s*(public|private|native|abstract|strictfp|abstract"
							+ "|protected|final)\\s+)?(?:static\\s+)?class.*")) {
						// If true then increases noc by 1
						noc ++;
					}
					// Regex for checking if line represents the beginning of a method
					if (line.matches("((public|private|native|static|final|protected"
							+ "|abstract|transient)+\\s)+[\\$_\\w\\<\\>\\[\\]]*\\s+[\\$_\\w]+\\([^"
							+ "\\)]*\\)?\\s*\\{?[^\\}]*\\}?")) {
						// If true then increases nom by 1
						nom ++;
					}
					/*
					 * Line is not a comment neither a blank line(insured while
					 * reading the file) so we add 1 to the loc variable
					 */ 
					loc ++;
				}
			}
			// Potential multiple line comment starter
			if (line.matches("/\\*.*")) {
				multLine = true;
			}
			// Potential multiple line comment ender
			if (line.matches(".*\\*/.*$")) {
				multLine = false;
			}
		}
		// Adds metrics to the return list
		listForCsv.add(String.valueOf(loc));
		listForCsv.add(String.valueOf(noc));
		listForCsv.add(String.valueOf(nom));
		
		// Returns the list
		return listForCsv;
	}
}
