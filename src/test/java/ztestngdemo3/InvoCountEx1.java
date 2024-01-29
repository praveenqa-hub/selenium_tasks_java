package ztestngdemo3;

import org.testng.annotations.*;

public class InvoCountEx1 {

	@Test(invocationCount = 5)
	void demoTest() {
		System.out.println("demo test"); //this is for exhaustive testing to check whether the functionality will broke
	}
}
