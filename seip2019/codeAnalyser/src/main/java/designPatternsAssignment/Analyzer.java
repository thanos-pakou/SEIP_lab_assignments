package designPatternsAssignment;

import java.util.List;

/**
 * This is the Strategy interface for selecting an 
 * analysis method for calculating the metrics of the 
 * source Code
 * @author thanos-pakou
 *
 */
public interface Analyzer {
	/**
	 * The only method inside Analyzer which is 
	 * responsible for the whole calculation process
	 * @param srcLines
	 * @return listForCsv
	 */
	public List<String> codeAnalyse(List<String> srcLines);
	
}
