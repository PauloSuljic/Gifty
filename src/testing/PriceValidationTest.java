package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import methods.WishlistMethods;

public class PriceValidationTest {

	@Test
	public void testNumber() {
		Boolean value = WishlistMethods.priceValidation("500");
		assertEquals(true, value);	
	}
	
	@Test
	public void testAlphanumeric() {
		Boolean value = WishlistMethods.priceValidation("5abc00");
		assertEquals(false, value);	
	}

}
