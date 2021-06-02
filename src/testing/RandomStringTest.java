package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import methods.MailMethods;

public class RandomStringTest {

	@Test
	public void testLength() {
		String value = MailMethods.randomString();
		assertEquals(8, value.length());
	}

}
