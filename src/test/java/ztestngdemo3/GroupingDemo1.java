package ztestngdemo3;

import org.testng.annotations.*;

public class GroupingDemo1 {

	@Test(priority = 1, groups= {"sanity","regression"})
	void loginByEmail() {
		System.out.println("logged in by email");
	}

	@Test(priority = 2,groups= {"sanity"})
	void loginByFacebook() {
		System.out.println("logged in by facebook");
	}

	@Test(priority = 3,groups= {"sanity"})
	void loginByTwitter() {
		System.out.println("logged in by Twitter");
	}

	@Test(priority = 4,groups= {"sanity","regression"})
	void signupByEmail() {
		System.out.println("signup by email");
	}

	@Test(priority = 5,groups = {"regression"})
	void signupByFacebook() {
		System.out.println("signup by facebook");
	}

	@Test(priority = 6,groups = {"regression"})
	void signupByTwitter() {
		System.out.println("signup by Twitter");
	}

	@Test(priority = 7,groups = {"regression","sanity"})
	void paymentByRupees() {
		System.out.println("by rupees");
	}

	@Test(priority = 8,groups = {"sanity"})
	void paymentByDollars() {
		System.out.println("by dollars");
	}

	@Test(priority = 9,groups = {"regression"})
	void paymentReturnByBank() {
		System.out.println("payment refund");
	}
}
