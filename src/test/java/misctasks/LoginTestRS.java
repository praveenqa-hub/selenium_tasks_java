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

	public void loginTestRS(WebDriver driver) {

		String url = "https://rahulshettyacademy.com/locatorspractice/";
		String title = "Rahul Shetty Academy - Login page";
		driver.get(url);
		SoftAssert sa = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		Assert.assertEquals(driver.getCurrentUrl(), url, "incorrect url");
		sa.assertEquals(driver.getTitle(), title, "title different");

		driver.findElement(By.id("inputUsername")).sendKeys("Tom");
		driver.findElement(By.name("inputPassword")).sendKeys("Jerry");
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.cssSelector("button.signInBtn")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p[class='error']"))));
		WebElement error = driver.findElement(By.cssSelector("p[class='error']"));
		sa.assertEquals(error.getText(), "* Incorrect username or password");

		driver.findElement(By.linkText("Forgot your password?")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Go to Login']"))));

		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Dhoni");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Dhoni@gmail.com");
		driver.findElement(By.xpath("//div[contains(@class,'sign-up-container')]//input[3]"))
				.sendKeys("9494949494");
		driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
	}

}
