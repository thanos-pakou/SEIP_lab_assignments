package mavenAssignment;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

/**
 * Contains the main functions and 2 other functions for generating the chart with students grades frequencies
 * @author thanos-pakou
 *
 */
public class HistogramGenerator {
	
	/**
	 * Generates the chart with the grade frequencies and shows it to the user 
	 * @param dataValues
	 */
	public void generateChart(int[] dataValues) {

		HistogramDataset dataset = new HistogramDataset();
		dataset.setType(HistogramType.RELATIVE_FREQUENCY);
		double[] b = new double[dataValues.length];
		for (int i = 0; i < dataValues.length; i++) {
			b[i] = dataValues[i];
		}
        dataset.addSeries("Hist",b,11);
        String plotTitle = "Grades Histogram";
        String xAxis = "Grade";
        String yAxis = "Frequency";
        PlotOrientation orientation = PlotOrientation.VERTICAL;

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createHistogram(plotTitle, xAxis, yAxis,
                dataset, orientation, legend, tooltips, urls);
		// Declare XYPlot
		XYPlot plot = chart.getXYPlot();
		
		// Declare domain Axis
		NumberAxis domain = (NumberAxis) plot.getDomainAxis();
		
		// Set domain Axis range
		domain.setRange(0, 10);
        

		// Set Tick unit to domain Axis
		domain.setTickUnit(new NumberTickUnit(1));
        
        
		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("Frequency Chart", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}
	
	/**
	 * Gets a list of grades and creates an array with the grades
	 * frequencies.
	 * @param values a list of students' grades
	 * @return freqArr array of grades frequencies
	 */
	public int[] frequenciesArr(List<Integer> values) {
		int[] freqArr = new int[values.size()];
		int[] freqAr2r = new int[values.size()];
		for (int i=0; i< values.size(); i++) {
			freqArr[i] = values.get(i);
			freqAr2r[values.get(i)] ++;
		}
		for(int x: freqAr2r) {
			System.out.println(x);
		}
		return freqArr;
	}
	
	/**
	 * Main function that takes one arg of a text file,
	 * reads it, adds the values to a list, calls the frequenciesArr 
	 * method and then takes the result and puts it as an arg while
	 * calling the chart generator method
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// checks if command arguement exist
		if (args.length != 0) {
			File file = new File(args[0]);
			List<Integer> gradesArr = new ArrayList<Integer>();
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  
			String st; 
			// checks every line of txt file and put the values into a list
			while ((st = br.readLine()) != null) {
				gradesArr.add(Integer.parseInt(st));
			}
			
			HistogramGenerator hG = new HistogramGenerator();
			// calls generateChart method 
			hG.generateChart(hG.frequenciesArr(gradesArr));
		}
	}
}
