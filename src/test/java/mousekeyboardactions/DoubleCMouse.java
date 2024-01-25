package mousekeyboardactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DoubleCMouse {

	WebDriver driver = AppMain.getDriver();

	String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3";

	void doubleC() {
		String role = "Automation Engineer";
		driver.get(url);
		driver.switchTo().frame("iframeResult");
		Actions act = new Actions(driver);
		WebElement field1 = driver.findElement(By.id("field1"));
		field1.clear();
		field1.sendKeys(role);
		// getAttribute("value") vs getText()
		WebElement button = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		act.doubleClick(button).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id("field2")), "value", role));
		String actfield = driver.findElement(By.id("field2")).getAttribute("value");
		Assert.assertEquals(actfield, role);
		driver.switchTo().defaultContent();
	}
}
