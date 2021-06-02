package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import methods.SidebarMethods;

public class GetInitialsTest {

	@Test
	public void testNormalName() {
		String initials = SidebarMethods.getInitials("Marko Markic");
		assertEquals("MM", initials);
	}
	
	@Test
	public void testThreeNames() {
		String initials = SidebarMethods.getInitials("Marko Kukic Markic ");
		assertEquals("MKM", initials);
	}

}
