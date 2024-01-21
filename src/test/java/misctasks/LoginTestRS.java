package misctasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginTestRS {
	WebDriver driver = AppMain.getDriver();

	public static String getPassword(WebDriver driver) {
		String msg = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] msg_array = msg.split("'");
		return msg_array[1];
	}

	public void loginTestRS(WebDriver driver) {

		String url = "https://rahulshettyacademy.com/locatorspractice/";
		String title = "Rahul Shetty Academy - Login page";
		String email = "Dhoni@gmail.com";

		driver.get(url);
		SoftAssert sa = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// validating the url and title is as per requirement
		Assert.assertEquals(driver.getCurrentUrl(), url, "incorrect url");
		sa.assertEquals(driver.getTitle(), title, "title different");

		// locating web elements and passing inputs
		WebElement username_field = driver.findElement(By.id("inputUsername"));
		WebElement password_field = driver.findElement(By.name("inputPassword"));
		WebElement terms_checkbox = driver.findElement(By.name("chkboxTwo"));
		WebElement sigin_button = driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]"));
		username_field.sendKeys("Tom");
		password_field.sendKeys("Jerry");
		terms_checkbox.click();
		sigin_button.click();

		// Explicitly wait until condition is met
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p[class='error']"))));
		WebElement error = driver.findElement(By.cssSelector("p[class='error']"));
		sa.assertEquals(error.getText(), "* Incorrect username or password");

		driver.findElement(By.linkText("Forgot your password?")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Go to Login']"))));

		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Dhoni");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//div[contains(@class,'sign-up-container')]//input[3]")).sendKeys("9494949494");
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p.infoMsg"))));
		String password = getPassword(driver);
		driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
		username_field.sendKeys(email);
		password_field.clear();
		password_field.sendKeys(password);
		terms_checkbox.click();
		sigin_button.click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[@class='login-container']/child::p"))));
		String actual_email = driver.findElement(By.cssSelector("div.login-container h2")).getText();
		sa.assertEquals(actual_email, "Hello " + email + ",");
		boolean actual_msg = driver.findElement(By.xpath("//div[@class='login-container']/child::p")).getText()
				.equals("You are successfully logged in.");
		Assert.assertEquals(actual_msg, true);
		sa.assertAll();
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	}

}
