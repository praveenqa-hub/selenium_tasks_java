package alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertEx2 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://the-internet.herokuapp.com/javascript_alerts";

	public void alertTypes() {
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
				wait.until(ExpectedConditions.alertIsPresent());
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().sendKeys("Dhoni");
				driver.switchTo().alert().accept();
	}

}
