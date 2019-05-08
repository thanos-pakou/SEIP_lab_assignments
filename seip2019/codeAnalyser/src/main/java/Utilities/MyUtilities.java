package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Providing custom utility methods for reading
 * a java file and writing a csv file
 * @author thanos-pakou
 * 
 */
public final class MyUtilities {
	
	/**
	 * Private constructor for avoiding constructing conflicts
	 */
	private MyUtilities() {
		
	}
	
	/**
	 * Reads a file, removes empty lines and extra spaces
	 * and adds each line to a list
	 * @param file
	 * @return srcLines
	 */
	public static List<String> readFile(String file) {
		BufferedReader br = null;
		FileReader fr = null;
		// Initialize srcLines list
		List<String> srcLines = new ArrayList<String>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String sCurrentLine;
			// Looping through all lines of file
			while ((sCurrentLine = br.readLine()) != null) {
				// Ignore empty Lines
				if (sCurrentLine.matches("^\\s*$")) {
					continue;
				}
				// Removes extra spaces
				else {
					String toAdd = sCurrentLine.trim().replaceAll(" +", " ");
					if (toAdd.substring(toAdd.length() - 1).equals(" ")) {
						toAdd = toAdd.substring(0, toAdd.length() - 1);
					}
					if (toAdd.substring(0).equals(" ")) {
						toAdd = toAdd.substring(1, toAdd.length());
					}
					srcLines.add(toAdd);
				}
			}
		// Catching exception
		} catch (IOException e) {
			// Print exception
			e.printStackTrace();
		// If no exception has been caught
		} finally {
			// Close br and fr
			try {
				
				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
				
			} catch (IOException ex) {

				ex.printStackTrace();
			}
		}
		// Returns List of lines of code
		return srcLines;
	}
	
	/**
	 * Gets a list of 3 strings and creates a csv presenting 
	 * these 3 metrics (loc, noc, nom)
	 * @param listForCsv
	 */
	public static void writeFile(List<String> listForCsv) {
		// 
		try {
			// Declares file writer
			FileWriter writer = new FileWriter("test.csv");
			// Writing the column titles to the csv
			writer.append("Number of lines, Number of classes, Number of methods \n");
			
			// Writing the metrics in the csv
			writer.append(listForCsv.get(0) + ", " + listForCsv.get(1) + ", " 
			+ listForCsv.get(2));
			
			//Closing writer
			writer.close();
			
			// Catching exception
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
