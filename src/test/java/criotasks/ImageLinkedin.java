package criotasks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImageLinkedin {
	WebDriver driver = LaunchBrowser.getDriver();

	public void imagePost() throws AWTException, InterruptedException {

		// Navigate to the given URL https://www.linkedin.com/
		driver.get("https://www.linkedin.com/");
		// sendKeys in the "Email or Phone" Field
		driver.findElement(By.id("session_key")).sendKeys("enter_your_email");
		//sendKeys in the "Password" Field
		driver.findElement(By.id("session_password")).sendKeys("enter_password");
		//Click on "Sign in" Button 
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Click on start a post
		driver.findElement(By.xpath("//span[text()='Start a post']")).click();
		Thread.sleep(2000);
		//Click on "Photo" Button 
		driver.findElement(By.xpath("//button[@aria-label='Add media']")).click();

		//Upload file using Robot class  
		Robot rb = new Robot();
		rb.delay(3000);

		// We have to pass path of the file using StringSelection // status_codes.jpeg 
		StringSelection ss = new StringSelection("Enter_path_of_file with extension");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// rb.keyPress(KeyEvent.VK_CONTROL);
		// rb.keyPress(KeyEvent.VK_C);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_ENTER);

		//Click on "Next" button 
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	

		WebElement textbox = driver.findElement(By.xpath("//div[contains(@aria-label,'editor for creating content')]"));
		textbox.sendKeys("This short video is uploaded through automation using Robot Class.");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		

		// Click on "Post" button Using Locator "XPath" //span[text()='Post']
		driver.findElement(By.xpath("//span[text()='Post']")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Post successful.']"))));
		//Explicitly wait for 30 sec for visibility of view post Using Locator "Link Text" View post
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View post")));

		// Verify that "Post successful." message is displayed Using Locator "XPath" //span[text()='Post successful.']
		boolean isDisplayed = driver.findElement(By.xpath("//span[text()='Post successful.']")).isDisplayed();
		System.out.println("Post is displayed? : " + isDisplayed);

	}
}
