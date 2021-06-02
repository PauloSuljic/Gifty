package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import methods.WishlistMethods;

public class URLValidationTest {

	@Test
	public void testEmpty() {
		Boolean value = WishlistMethods.URLValidation("");
		assertEquals (false, value);
	}
	
	@Test
	public void testValid() {
		Boolean value = WishlistMethods.URLValidation("https://www.youtube.com");
		assertEquals (true, value);
	}
	
	@Test
	public void testInvalidLink() {
		Boolean value = WishlistMethods.URLValidation("https://www.you12345tube.com");
		assertEquals (false, value);
	}
	
	@Test
	public void testInvalidForm() {
		Boolean value = WishlistMethods.URLValidation("https://www.youtube");
		assertEquals (false, value);
	}

}
