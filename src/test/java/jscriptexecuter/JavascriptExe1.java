package jscriptexecuter;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExe1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.switchTo().frame(0);
		WebElement nameField = driver.findElement(By.id("RESULT_TextField-0"));
		// nameField.sendKeys("MSD");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// JavascriptExecutor jse = driver;

		jse.executeScript("arguments[0].setAttribute('value','MSD')", nameField);

		WebElement genderRadio = driver.findElement(By.id("RESULT_RadioButton-1_0"));
		jse.executeScript("arguments[0].scrollIntoView();",genderRadio);
		jse.executeScript("arguments[0].click();", genderRadio);
		// genderRadio.click(); //ElementClickInterceptedException

		driver.switchTo().defaultContent();

		WebElement checkBox = driver.findElement(By.id("monday"));
		jse.executeScript("arguments[0].scrollIntoView();", checkBox);
		jse.executeScript("arguments[0].click();", checkBox);
		
		jse.executeScript("window.scrollBy(0,1000);","");
		Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

		// scroll down till end of the page/document
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(jse.executeScript("return window.pageYOffset;"));
		Thread.sleep(2000);
		// go back to initial position
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(3000);
		 driver.quit();
	}
}
