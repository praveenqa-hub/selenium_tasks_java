package mousekeyactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverFlipKart1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://www.flipkart.com/";

	void mouseDemo() {
		driver.get(url);

		Actions act = new Actions(driver);
		WebElement elect = driver.findElement(By.xpath("//*[text()='Electronics']"));
		act.moveToElement(elect).perform();
				act.moveToElement(driver.findElement(By.xpath("//*[text()='Laptop and Desktop']")))
				.moveToElement(driver.findElement(By.xpath("//*[text()='Laptops']"))).click().build()
				.perform();

	}
}
