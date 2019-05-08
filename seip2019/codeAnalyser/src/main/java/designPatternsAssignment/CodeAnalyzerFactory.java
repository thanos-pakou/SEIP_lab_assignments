package designPatternsAssignment;

import java.util.Objects;

/**
 * The factory class responsible for selecting 
 * analysis method
 * @author thanos-pakou
 *
 */
public class CodeAnalyzerFactory {
	
	/**
	 * Is responsible for the implementation in the Analyzer interface
	 * depending on the user's params
	 * @param analysisMethod
	 * @return analyzer
	 */
	public static Analyzer selectAnalysisMethod(String analysisMethod) {
		// Declares analyzer as null
		Analyzer analyzer = null;
		if (Objects.equals(analysisMethod, "regex")) {
			// Implementing regex analysis method
			analyzer = new RegexAnalyzer();
		} else if (Objects.equals(analysisMethod, "string")) {
			// Implementing string comparison analysis method
			analyzer = new StringAnalyzer();
		} 
		return analyzer;
	}
}
