package misctasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RsAssignment1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/AutomationPractice/";

	public void checkBox(WebDriver driver) {
		driver.get(url);
		WebElement checkBox1 = driver.findElement(By.id("checkBoxOption1"));
		Assert.assertFalse(checkBox1.isSelected());
		checkBox1.click();
		Assert.assertTrue(checkBox1.isSelected());
		checkBox1.click();
		Assert.assertFalse(checkBox1.isSelected());
		int count = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println("Count of check boxes : "+count);
	}
}
