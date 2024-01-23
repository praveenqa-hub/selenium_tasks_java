package window_handles;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrangeHrmDemo {

	WebDriver driver = AppMain.getDriver();
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	void winHand() {
		driver.get(url);
		String mainHandle = driver.getWindowHandle();
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windHandles = driver.getWindowHandles();

		for (String s : windHandles) {
			if (!s.equals(mainHandle)) {
				driver.switchTo().window(s);
				Assert.assertEquals(driver.getTitle(), "OrangeHRM HR Software | OrangeHRM");
				driver.close();
			}
		}
		driver.switchTo().window(mainHandle);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
}
