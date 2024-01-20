package misctasks;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTestRS {
	WebDriver driver = AppMain.getDriver();

	public void loginTestRS(WebDriver driver) {
		
		 
		
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(),url);
		
		
	}

	
}
