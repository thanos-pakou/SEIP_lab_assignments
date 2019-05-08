package operations;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
/**
 * This class is a Parameterized class for IntegerOperationsTest_PowerOfTwo
 * which tests all the parameters possible for the PowerOfTwo method.
 * @author thanos-pakou
 *
 */
public class IntegerOperations_PowerOfTwo_ParameterizedTest {
	
	@Parameter (value = 0)
	public int power;
	@Parameter (value = 1)
	public int result;
	
	
	IntegerOperations intOp = new IntegerOperations();
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {{0,1},{1,2},{2,4},{3,8},{4,16},{5,32},
			{6,64},{7,128},{8,256},{9,512},{10,1024},{11,2048},{12,4096},
			{13,8192},{14,16384},{15,32768},{16,65536},{17,131072},{18,262144},
			{19,524288},{20,1048576},{21,2097152},{22,4194304},{23,8388608},
			{24,16777216},{25,33554432},{26,67108864},{27,134217728},
			{28,268435456},{29,536870912},{30,1073741824},};
		
		return Arrays.asList(data);
	}
	
	/**
	 * Performs all the parameter tests
	 */
	@Test 
	public void test_powerOfTwo() {
		Assert.assertEquals(result, intOp.powerOfTwo(power));
	}
	

}
