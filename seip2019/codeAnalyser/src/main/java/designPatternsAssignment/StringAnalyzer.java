package designPatternsAssignment;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the string analysis method implementation 
 * for our Strategy Interface Analyzer 
 * @author thanos-pakou
 *
 */
public class StringAnalyzer implements Analyzer{

	/**
	 * Gets a string list with non-empty code lines and 
	 * calculates loc, noc, nom using string comparison 
	 * @param srcLines
	 * @return listForCsv
	 */
	public List<String> codeAnalyse(List<String> srcLines) {
		// Initializes the return List
		List<String> listForCsv = new ArrayList<String>();
				
		/*
		 * Initializes our metrics loc(Lines of code),
			* noc(Number of classes), nom(Number of methods)
		 */
		int loc = 0;
		int noc = 0;
		int nom = 0;
		// Variable to check if the loop \is inside a multiple line comment
		boolean multLine = false;
				
		// Looping through the lines of code
		for (String line: srcLines) {
			// Checks if line is a multi line comment
			if (multLine == false) {
				// If line is a multiple line comment starter
				if (line.startsWith("/*")) {
					multLine = true;
				} else if (line.startsWith("//")){
					continue;
				// If line is not a comment
				} else {
					// Adds 1 to the loc
					loc ++;
					// Checks if line starts with the word class
					if(line.startsWith("class")) {
						// If it is adds 1 to the noc
						noc ++;
					} 
					// Checks if line starts with potential class-method words
					else if (line.startsWith("public") || line.startsWith("final") || 
							line.startsWith("abstract") || line.startsWith("strictfp") ||
							line.startsWith("private") || line.startsWith("protected") ||
							line.startsWith("static")) {
						if (line.contains("class")) {
							noc ++;
						// Ensures that line is a method
						} else if ((line.contains("int") || line.contains("String") || 
								line.contains("boolean") || line.contains("List<") || 
								line.contains("ArrayList<") || line.contains("void") || 
								line.contains("[]")) && !line.contains("="))
						{
							nom ++;
						}
					}	
				}
			// If line belongs to a multiple line comment
			} else {
				// If comment ends somewhere in line
				if(line.contains("*/")) {
					multLine = false;
					// If comment ender is at the end of the line
					if (!line.endsWith("*/")) {
						// Potential line of code after comment
						loc++;
					}
				} 
			}
		}
		// Adds the metrics to the return list
		listForCsv.add(String.valueOf(loc));
		listForCsv.add(String.valueOf(noc));
		listForCsv.add(String.valueOf(nom));
		// Returns the list for the csv
		return listForCsv;
		
	}
	
}
