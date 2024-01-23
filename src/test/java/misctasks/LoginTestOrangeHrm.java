package misctasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginTestOrangeHrm {

	static WebDriver driver = AppMain.getDriver();
	String url = "https://opensource-demo.orangehrmlive.com/";

	public static String getUserName() {
		String user = driver.findElement(By.xpath("//div[@class='orangehrm-login-error']/descendant::p[1]")).getText();
		String[] user_array = user.split(": ");
		return user_array[1];
	}

	public static String getPassword() {
		String pass = driver.findElement(By.xpath("//div[@class='orangehrm-login-error']//p[2]")).getText();
		String[] pass_array = pass.split(": ");
		return pass_array[1];
	}

	public void loginTestHrm() {
		driver.get("https://opensource-demo.orangehrmlive.com/");

		String title = driver.getTitle();
		SoftAssert sa = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		sa.assertEquals(title, "OrangeHRM");

		driver.findElement(By.name("username")).sendKeys(getUserName());
		driver.findElement(By.name("password")).sendKeys(getPassword());
		driver.findElement(By.xpath("//button[normalize-space(text()='Login')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Dashboard']"))));
		String dash_text = driver.findElement(By.xpath("//*[text()='Dashboard']")).getText();
		Assert.assertEquals(dash_text, "Dashboard");
		driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
