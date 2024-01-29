package ztestngdemo3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenDemo {

	WebDriver driver;

	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "logindataprovider")
	void testLogin(String email, String pwd) {
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();

		Assert.assertEquals(exp_title, act_title);
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "logindataprovider")
	String[][] loginData() {
		
		String data[][] = { { "test@gmail", "test123" }, { "dhoni@gmail.com", "demo123" },
				{ "msd@gmail.com", "test@123" } };
		return data;
	}

	@DataProvider(name = "demodatalogin",indices= {0,2})  //only 0th and 2nd input will be taken. not range
	String[][] demoData() {
		String data[][] = { { "test@gmail", "test123" }, { "yuvi@gmail.com", "demo123" }, { "dhoni@gmail.com", "demo123" },
				{ "msd@gmail.com", "test@123" }};
		return data;
	}
}
