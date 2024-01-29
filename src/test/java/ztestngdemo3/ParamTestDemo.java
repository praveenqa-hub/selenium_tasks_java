package ztestngdemo3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParamTestDemo {
	WebDriver driver;

	@BeforeClass
	@Parameters({"browser","url"})
	void setup(String brow,String url) {
		
		switch(brow) {
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
			break;
		default:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
		}
	}

	@Test(priority = 1)
	void testLogo() {
		try {
			// we are using this try catch block avoid no such element exception
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='orangehrm-login-branding'] img"))));
			boolean logoFlag = driver.findElement(By.cssSelector("div[class='orangehrm-login-branding'] img")).isDisplayed();
			Assert.assertTrue(logoFlag, "logo not available");
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test(priority = 2)
	void testHomePageTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM","title mismatched");
	}

	@AfterClass
	void closeApp() {
		driver.quit();
	}
}
