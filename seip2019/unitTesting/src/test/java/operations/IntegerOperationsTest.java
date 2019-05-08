package operations;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

/**
 * A public class to test the IntegerOperations class functionality. It contains
 * all the cases necessary to test the outputs of the methods and their
 * exceptions in the IntegerOperations class.
 * @author thanos-pakou
 *
 */
public class IntegerOperationsTest {
	IntegerOperations intOp = 	new IntegerOperations();
	
	/**
	 * Tests if the reverseSign method returns the result it was 
 	 * supposed to with a positive argument
	 */
	@Test
	public void test_reverseSign_positive() {
		Assert.assertEquals(5, intOp.reverseSign(-5));
	}
	
	/**
	 * Tests if the reverseSign method returns the result it was 
 	 * supposed to with a negative argument
	 */
	@Test
	public void test_reverseSign_negative() {
		Assert.assertEquals(-5, intOp.reverseSign(5));
	}
	
	/**
	 * Tests if the reverseSign method returns the result it was 
 	 * supposed to with the 0 argument
	 */
	@Test
	public void test_reverseSign_zero() {
		Assert.assertEquals(0, intOp.reverseSign(0));
	}
	
	
	/**
	 * Tests if the method add returns the correct result for 
	 * 2 positive integers x,y
	 * 
	 */
	@Test
	public void test_add_positives() {
		Assert.assertEquals(6874, intOp.add(985, 5889));
	}
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Tests if the method add throws the exception message expected 
	 * with x negative and y positive 
	 * 
	 */
	@Test
	public void test_add_negativeX() {
		thrown.expectMessage("Input numbers should be positive.");
		intOp.add(-5, 5);
		
	}
	
	/**
	 * Tests if the method add throws the exception message expected 
	 * with x positive and y negative 
	 * 
	 */
	@Test
	public void test_add_negativeY() {
		thrown.expectMessage("Input numbers should be positive.");
		intOp.add(5, -5);
		
	}
	
	/**
	 * Tests if the method add throws the exception message expected for
	 * 2 negative integers x,y
	 * 
	 */
	@Test
	public void test_add_negativeXY() {
		thrown.expectMessage("Input numbers should be positive.");
		intOp.add(-5, -5);
		
	}
	
	/**
	 * Tests if the method add throws the exception message expected 
	 * when index is out of range
	 * 
	 */
	@Test
	public void test_add_maxValue() {
		thrown.expectMessage("Cannot fit the result in an Integer.");
		intOp.add(2147483647, 1);
		
	}
	
	/**
	 * Tests if the method powerOfTwo throws the exception message expected 
	 * when argument is a negative number
	 * 
	 */
	@Test
	public void test_powerOfTwo_negative() {
		thrown.expectMessage(-15 + " is not a positive integer.");
		intOp.powerOfTwo(-15);
		
	}
	
	/**
	 * Tests if the method powerOfTwo throws the exception message expected 
	 * when argument is bigger than 30
	 * 
	 */
	@Test
	public void test_powerOfTwo_over30() {
		thrown.expectMessage(31 + "^2 causes an integer overflow.");
		intOp.powerOfTwo(31);
		
	}
	
}
