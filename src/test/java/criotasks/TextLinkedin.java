package criotasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TextLinkedin {
	WebDriver driver = LaunchBrowser.getDriver();

	public void textPost() {

		// Navigate to the given URL  https://www.linkedin.com/
		driver.get("https://www.linkedin.com/");
		
		//sendKeys to "Email or Phone" Field 
		driver.findElement(By.id("session_key")).sendKeys("enter_your_email");
		
		//sendKeys to "Password" Field
		driver.findElement(By.id("session_password")).sendKeys("enter_password");
		
		//Click on "Sign in" Button 
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Print the count of 'Who's viewed your profile' 
		String viewCount = driver
				.findElement(By.xpath("//span[contains(text(),'view')]/../../following-sibling::div/span"))
				.getText();
		System.out.println("profile view count: " + viewCount);
		
		// Print the count of 'Impressions of your post' 
		String impressionCount = driver.findElement(By.xpath("//span[text()='Post impressions']/..//../following-sibling::div/span/strong"))
									.getText();
		System.out.println("Impressions of your post: " + impressionCount);
		
		// Click on "Start a post" Button 
		driver.findElement(By.xpath("//span[text()='Start a post']")).click();
		
		// Click on Post visibility options Dropdown
		driver.findElement(By.className("share-unified-settings-entry-button")).click();
		// Select "Connections only" 
		driver.findElement(By.id("CONNECTIONS_ONLY")).click();
		// Click on "Done" button
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		// Click on the text box 
		WebElement textBox = driver.findElement(By.xpath("//div[@role='textbox']"));
		textBox.click();
		// Type the message in text box 
		textBox.sendKeys("This is an automated test post for connections only kindly ignore. Happy Weekend");
		// Click on "Post" button 
		driver.findElement(By.xpath("//span[text()='Post']")).click();
		// Verify that "Post successful." 
		boolean isDisplayed = driver.findElement(By.xpath("//span[text()='Post successful.']")).isDisplayed();
		System.out.println("Post is displayed? : " + isDisplayed);

	}
}
