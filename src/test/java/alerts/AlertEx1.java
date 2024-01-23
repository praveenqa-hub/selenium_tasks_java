package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/AutomationPractice/";

	void alertDemo() {
		driver.get(url);
		WebElement field = driver.findElement(By.id("name"));
		field.sendKeys("Dhoni");
		driver.findElement(By.id("alertbtn")).click();

		String content = driver.switchTo().alert().getText();
		System.out.println(content);
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();
		String content1 = driver.switchTo().alert().getText();
		System.out.println(content1);
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();

	}
}
