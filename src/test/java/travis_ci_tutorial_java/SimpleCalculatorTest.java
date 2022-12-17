package travis_ci_tutorial_java;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.function.ThrowingRunnable;

public class SimpleCalculatorTest {
	@Test
	public void testAdd() {
		SimpleCalculator calc = new SimpleCalculator();
		assertEquals(calc.add(1, 1), 2);
	}
	
	@Test
	public void testMinus() {
		SimpleCalculator calc = new SimpleCalculator();
		assertEquals(calc.minus(5, 3), 2);
	}
	
	public void testMultiply() {
		SimpleCalculator calc = new SimpleCalculator();
		assertEquals(calc.multiply(-1, 1), -1);
		assertEquals(calc.multiply(1, 1), 1);
		assertEquals(calc.multiply(1, 0), 0);
		assertEquals(calc.multiply(0, 0), 0);
	}
	
	public void testDivide() {
		SimpleCalculator calc = new SimpleCalculator();
		assertEquals(calc.divide(1, 1), 1);
		assertEquals(calc.divide(2, 1), 2);
		assertEquals(calc.divide(1, 2), 0);
		assertEquals(calc.divide(9, 10), 0);
						
		Exception divByZeroException = assertThrows(ArithmeticException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
			    int result = 1 / 0;
			}
		});
		
		String expectedMessage = "/ by zero";
				
		String actualMessage = divByZeroException.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));	
		
		
		assertThrows(ArithmeticException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
			    int result = 0 / 0;
			}
		});
	}
}