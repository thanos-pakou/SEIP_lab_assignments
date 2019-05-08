package filehandlers;

import org.junit.Assert;
import org.junit.Test;

/**
 * A public class to test the FileIO class functionality. It contains
 * all the cases necessary to test the outputs of the methods and their
 * exceptions in the FileIO class.
 * @author thanos-pakou
 *
 */
public class FileIOTest {
	FileIO fI = new FileIO();
	

	/**
	 * Tests if the readFile return the result it is supposed to
	 */
	@Test
	public void test_readFile_valid () {
		int[] testValues = {
				1,3,5,7,9,11,13,15,17,19,
				21,23,25,27,29,31,33,35,37,39,41,43
				,45,47,49,51,53,55,57,59,61,63,65,67,
				69,71,73,75,77,79,81,83,85,87,89,91,
				93,95,97,99,101,103,105,107,109,111,
				113,115,117,119,121,123,125,127,129,
				131,133,135,137,139,141,143,145,147,
				149,151,153,155,157,159,161,163,165,
				167,169,171,173,175,177,179,181,183,
				185,187,189,191,193,195,197,199,201,
				203,205,207,209,211,213,215,217,219
				,221,223,225,227,229,231,233,235,237,
				239,241,243,245,247,249,251,253,255,
				257,259,261,263,265,267,269,271,273,
				275,277,279,281,283,285,287,289,291,
				293,295,297,299,301,303,305,307,309,
				311,313,315,317,319,321,323,325,327,
				329,331,333,335,337,339,341,343,345,
				347,349,351,353,355,357,359,361,363,
				365,367,369,371,373,375,377,379,381,
				383,385,387,389,391,393,395,397,399
				};
		Assert.assertArrayEquals(testValues, fI.readFile("src/test/resources/valid.txt"));
	}
	
	/**
	 * Tests if the readFile throws NumberFormatException when
	 * array doesn't contain only integers.
	 */
	@Test (expected = NumberFormatException.class)
	public void test_readFile_invalid () throws Exception {
		fI.readFile("src/test/resources/invalid.txt");
	}
	
	/**
	 * Tests if the readFile throws IllegalArgumentException when
	 * file path doesn't exists.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_readFile_invalidPath () throws Exception {
		fI.readFile("invalidpathonpurpose");
	}
}
