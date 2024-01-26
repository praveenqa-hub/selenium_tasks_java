package criotasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class IMDBRatings {
	WebDriver driver = LaunchBrowser.getDriver();

	public void imdb() throws InterruptedException {
		// Navigate to the given URL https://www.imdb.com/chart/top
		driver.get("https://www.imdb.com/chart/top");

		// Print the Highest Rated Movie Using Locator "XPath"
		System.out.println(
				"Highest Rated Movie :" + driver.findElement(By.xpath("//a[@CLASS='ipc-title-link-wrapper']")).getText());

		// Print the count of the movies included in the table Using Locator "XPath"
		System.out.println("No of Movies included in the table: " + driver.findElements(By.xpath("//ul[@role='presentation']/li[contains(@class,'summary')]")).size());
		
		// Select the Sort by Dropdown 
		Select sel = new Select(driver.findElement(By.id("sort-by-selector")));

		// Select "Release Date" from the dropdown, using visible text Release Date
		sel.selectByVisibleText("Release date");

		// Click on sortby arrow button 
		WebElement arrow = driver.findElement(By.xpath("//*[text()='Sort by']/parent::span/following-sibling::button"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", arrow);
		jse.executeScript("arguments[0].click();", arrow);
		Thread.sleep(2000);

		// Print the oldest movie on the list Using Locator "XPath"
		System.out.println("Oldest movie on the list: "
				+ driver.findElement(By.xpath("//a[@CLASS='ipc-title-link-wrapper']")).getText());

		// Click on arrow button Using Locator "CSS Selector" div.lister-activated span
		arrow.click();
		Thread.sleep(2000);
		
		// Print the most recent movie on the list Using Locator "XPath"
		System.out.println("The most recent movie on the list -"
				+ driver.findElement(By.xpath("//a[@CLASS='ipc-title-link-wrapper']/h3")).getText());

		// Select "Number of Ratings" from the dropdown, using visible text Number of
		// Ratings
		sel.selectByValue("USER_RATING_COUNT");
		Thread.sleep(2000);

		// Print the movie with most user ratings Using Locator
		System.out.println("The movie with most user ratings: "
				+ driver.findElement(By.xpath("//a[@CLASS='ipc-title-link-wrapper']/h3")).getText());
	}
}
