package designPatternsAssignment;

import java.util.List;

import Utilities.MyUtilities;

/**
 * Facade class which creates a much easier interface for
 * the main method. This class contains all methods needed 
 * for the program to function
 * @author thanos-pakou
 * 
 */
public class CodeAnalyzerFacade {
	
	/**
	 * Calls readFile from MyUtilities class to read the
	 * file from filePath and create a List with its lines
	 * @param filePath
	 * @return srcLines
	 */
	public List<String> readSourceCode(String filePath) {
		  return MyUtilities.readFile(filePath);
	}
	
	/**
	 * Analyzes the srcLines list based on the analysis method
	 * (anMethod) and returns the results in a list of strings
	 * @param anMethod
	 * @param srcLinesList
	 * @return
	 */
	public List<String> calculateMetrics(String anMethod, List<String> srcLines) {
		Analyzer analyser = CodeAnalyzerFactory.selectAnalysisMethod(anMethod);
		return analyser.codeAnalyse(srcLines);
	}
	
	/**
	 * Writes results to a CSV and saves it using the writeFile 
	 * from MyUtilities class
	 * @param metrics
	 */
	public void writeCSV(List<String> metrics) {
		MyUtilities.writeFile(metrics);;
	}
}
