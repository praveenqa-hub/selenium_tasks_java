package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HiddenOptionsDropDown {

	WebDriver driver = AppMain.getDriver();
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	public void hiddenOptions() {
		driver.get(url);
		String totuser = driver.findElement(By.cssSelector("div.orangehrm-demo-credentials p:first-of-type")).getText();
		String username = totuser.substring(totuser.indexOf("A")).trim();

		String totpass = driver.findElement(By.cssSelector("div.orangehrm-demo-credentials p:last-of-type")).getText();
		String password = totpass.substring(totpass.indexOf(" a")).trim();

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space(text()=' Login ')]")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("(//div[@class='oxd-select-wrapper'])[3]")).click();
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		/*
		 * for(WebElement jobTitle : options) { System.out.println(jobTitle.getText()); }
		 */
		for (WebElement jobTitle : options) {
			if (jobTitle.getText().equals("QA Engineer")) {
				jobTitle.click();
				break;
			}
		}
		String actual = driver.findElement(By.xpath("(//div[@class='oxd-select-wrapper'])[3]")).getText();
		Assert.assertEquals(actual, "QA Engineer");
	}
}
