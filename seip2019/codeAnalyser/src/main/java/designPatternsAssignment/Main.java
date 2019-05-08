package designPatternsAssignment;

import designPatternsAssignment.CodeAnalyzerFacade;

public class Main {

	/**
	 * Main method getting 2 args ([Java file], [analyze method]) 
	 * and then calls facade's methods to generate a csv file 
	 * showing loc, noc and nom
	 * @param filePath, anMethod
	 */
	public static void main(String[] args) {
		
		// User input path of file to analyse
		String filePath = args[0];
		// User input method of analysis [regex | string]
		String anMethod = args[1];
		
		// Declares Facade object
		CodeAnalyzerFacade facade = new CodeAnalyzerFacade();
		
		/*
		 * Reads source file calculates 3 metrics loc,
		 *  noc, nom and writes a CSV file with these 
		 *  results using facade's methods
		 */
		facade.writeCSV(facade.calculateMetrics(anMethod, 
				facade.readSourceCode(filePath)));
	}

}
