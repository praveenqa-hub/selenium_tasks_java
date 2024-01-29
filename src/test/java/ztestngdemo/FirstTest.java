package ztestngdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	WebDriver driver;
	// seq of execution - alphabetical order 
	@Test
	public void testOne() {
		System.out.println("I am test one");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("google.com");
	}

	@Test
	public void aTwoTest() {
		System.out.println("I am test 2");
	}

	@Test
	public void test3() {
		System.out.println("I am test 3");
		driver.quit();
	}
}
