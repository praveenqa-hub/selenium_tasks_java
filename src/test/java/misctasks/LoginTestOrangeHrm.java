package misctasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginTestOrangeHrm {
	/*
	1) Launch browser
	2) open url
		https://opensource-demo.orangehrmlive.com/
	3) Provide username  - Admin
	4) Provide password  - admin123
	5) Click on Login button 
	6) Verify the title of dashboard page   
		Exp title : OrangeHRM
	7) close browser

	 */
	 WebDriver driver = AppMain.getDriver();
	
	
	public void loginTestHrm(WebDriver driver) {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.name("username")).sendKeys("Hai");;
	}

}
