package misctasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RsAssignment2 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/angularpractice/";

	public void protractorPage(WebDriver driver) {
		driver.get(url);
		driver.findElement(By.name("name")).sendKeys("Dhoni");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Dhoni@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("passTest@1");
		
		WebElement checkbox = driver.findElement(By.id("exampleCheck1"));
		Assert.assertTrue(checkbox.isEnabled());
		checkbox.click();
		genderSelect(driver);
		WebElement radio = driver.findElement(By.id("inlineRadio2"));
		Assert.assertTrue(radio.isEnabled());
		radio.click();
		driver.findElement(By.name("bday")).sendKeys("07-07-1981");
		driver.findElement(By.xpath("//input[contains(@class,'btn-success')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))));
		String actual_msg = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actual_msg.contains("Success!"));
	}

	public void genderSelect(WebDriver driver) {
		WebElement genDrop = driver.findElement(By.id("exampleFormControlSelect1"));
		Select sel = new Select(genDrop);
		sel.selectByVisibleText("Male");
	}

}
