package ztestngdemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondTest {

	WebDriver driver;

	//default priority = 0 
	//@Test(priority = 1)
	@BeforeClass
	void OpenApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("I am first");
	}

	@Test(priority = 200)
	void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		System.out.println("I am sec");
	}

	//@Test(priority = 3)
	@AfterClass
	void close() {
		System.out.println("I am 3rd");
		driver.quit();
	}

}
