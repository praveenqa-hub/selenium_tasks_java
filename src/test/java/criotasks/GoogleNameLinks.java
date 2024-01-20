package criotasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GoogleNameLinks {
	WebDriver driver = LaunchBrowser.getDriver();

	public void nameLinks() throws InterruptedException {
		String name = "Crio";
		// Navigate to URL https://www.google.com/
		driver.get("https://www.google.com/");
		// sendKeys "Hanuman" to Search Bar Using Locator "Name" q
		driver.findElement(By.name("q")).sendKeys(name);
		// Click on "Google Search" Button Using Locator "XPath" //input[@value='Google
		// Search']
		driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		Thread.sleep(5000);
		int count = driver.findElements(By.partialLinkText(name)).size();
		System.out.println("Number of " + name + " links: " + count);
	}

}
