package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MyUtilitiesTest {

	@Test
	public void test_readFile() {
		List<String> testValues = new ArrayList<String>();
		
		testValues.add("test12345");
		testValues.add("teSt12#%$^&345");
		testValues.add("test12345 TesT)(<{}>};!@#");
		testValues.add("teSt12#%$^&345 +-*/=-)(*&^%$#@!");
		
		Assert.assertEquals(testValues, MyUtilities.readFile("src/test/resources/testValues.txt"));
	}
	
}
