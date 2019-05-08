package operations;

import org.junit.Assert;
import org.junit.Test;

import filehandlers.FileIO;

import static org.mockito.Mockito.*;

/**
 * A public class to test the ArrayOperations class functionality. It contains
 * all the cases necessary to test the outputs of the methods and their
 * exceptions in the ArrayOperations class.
 * @author thanos-pakou
 *
 */
public class ArrayOperationsTest {
	// Mock the FileIO dependency
	FileIO fI = mock(FileIO.class);
			
	// Mock the IntegerOperations dependency
	IntegerOperations intOp = mock(IntegerOperations.class);
	
	// Initialize the ArrayOperrations object
	ArrayOperrations aOp = new ArrayOperrations(fI, intOp);
	
	/**
	 * Tests if the findMaxInFile method returns the correct result
	 */
	@Test
	public void test_findMaxInFile() {
	
		when(fI.readFile("test_max")).thenReturn(new int[] {-16, -7, 5, 500, 321, 50, -258});
		Assert.assertEquals(500, aOp.findMaxInFile("test_max"));
	}
	
	/**
	 * Tests if the findMaxInFile method throws exception when
	 * array is empty
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_findMaxInFile_empty() {
	
		when(fI.readFile("test_empty")).thenReturn(new int[] {});
		aOp.findMaxInFile("test_empty");
	}
	
	/**
	 * Tests if the reverseArray method returns the correct result
	 */
	@Test
	public void test_reverseArray() {
	
		when(fI.readFile("test_reverse")).thenReturn(new int[] {-6, 7, -5, -500, 321, -50, 258});
		when(intOp.reverseSign(-6)).thenReturn(6);
		when(intOp.reverseSign(7)).thenReturn(-7);
		when(intOp.reverseSign(-5)).thenReturn(5);
		when(intOp.reverseSign(-500)).thenReturn(500);
		when(intOp.reverseSign(321)).thenReturn(-321);
		when(intOp.reverseSign(-50)).thenReturn(50);
		when(intOp.reverseSign(258)).thenReturn(-258);
		
		Assert.assertArrayEquals(new int[] {6, -7, 5, 500, -321, 50, -258}, 
				aOp.reverseArray("test_reverse"));
	}
	
	/**
	 * Tests if the reverseArray method throws exception when
	 * array is empty
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_reverseArray_empty() {
	
		when(fI.readFile("test_reverse_empty")).thenReturn(new int[] {});
		aOp.reverseArray("test_reverse_empty");
	}
}
