package windowhandles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultipleWindowEX1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://testautomationpractice.blogspot.com/";

	public void multiWindowApproach1() {
		driver.get(url);
		String mainHandle = driver.getWindowHandle();
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("India tour");
		driver.findElement(By.cssSelector("input.wikipedia-search-button")).click();
		List<WebElement> results = driver.findElements(By.cssSelector("div.wikipedia-search-results a"));
		for (WebElement e : results) {
			e.click();
		}
		Set<String> handles = driver.getWindowHandles();
		// approach 1
		for (String h : handles) {
			if (!h.equals(mainHandle)) {
				driver.switchTo().window(h);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainHandle);
		//driver.quit();
	}

	public void multiWindowApproach2() {
		driver.get(url);

		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("India tour");
		driver.findElement(By.cssSelector("input.wikipedia-search-button")).click();
		List<WebElement> results = driver.findElements(By.cssSelector("div.wikipedia-search-results a"));
		for (WebElement e : results) {
			e.click();
		}
		Set<String> handles = driver.getWindowHandles();

		// approach 2 by index
		List<String> handlist = new ArrayList(handles);

		driver.switchTo().window(handlist.get(3));
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(handlist.get(1));
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(handlist.get(0));
		System.out.println(driver.getTitle());
		
	}
}
