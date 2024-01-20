package misctasks;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginLimeRoad {

	WebDriver driver = AppMain.getDriver();
	
	public void limeLoginTest(WebDriver driver){
		
		String url = "https://www.limeroad.com/";
		String title = "Online Shopping Site - Shop Men & Women Fashion Online in India";
		driver.get(url);
		SoftAssert sa = new SoftAssert();
		Assert.assertEquals(driver.getCurrentUrl(),url);
		sa.assertEquals(driver.getTitle(),title);
		
	}
}
