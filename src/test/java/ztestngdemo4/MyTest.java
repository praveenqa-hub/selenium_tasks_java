package ztestngdemo4;

import org.testng.Assert;
import org.testng.annotations.*;

public class MyTest {

	@Test(priority = 1)
	void loginTest() {
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	void ticketBookingTest() {
		Assert.fail();
	}

	@Test(dependsOnMethods = { "ticketBookingTest" })
	void logoutTest() {
		Assert.assertEquals(1, 1);
	}
}
