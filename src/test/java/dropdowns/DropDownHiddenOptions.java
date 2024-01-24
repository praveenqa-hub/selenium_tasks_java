package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownHiddenOptions {

	WebDriver driver = AppMain.getDriver();
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	public void hiddenOptions(){
		driver.get(url);
		String totuser = driver.findElement(By.cssSelector("div.orangehrm-demo-credentials p:first-of-type")).getText();
		String username = totuser.substring(totuser.indexOf("A")).trim();
		
		String totpass = driver.findElement(By.cssSelector("div.orangehrm-demo-credentials p:last-of-type")).getText();
		String password = totpass.substring(totpass.indexOf(" a")).trim();
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space(text()=' Login ')]")).click();
	}
}
