package dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class DynamicDropEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/dropdownsPractise/";

	public void originToDestination(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']"))
				.click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
	}

	public void dynamicDropDown() {
		SoftAssert sa = new SoftAssert();
		driver.get(url);
		Integer adult = 5;
		driver.findElement(By.id("divpaxinfo")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='hrefIncAdt']")));

		int i = 1;
		while (i < adult) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			i++;
		}

		String actual_adult = driver.findElement(By.id("spanAudlt")).getText();
		sa.assertEquals(actual_adult, adult.toString());
		// selecting origin and destination
		originToDestination(driver);
		sa.assertAll();
	}

}
