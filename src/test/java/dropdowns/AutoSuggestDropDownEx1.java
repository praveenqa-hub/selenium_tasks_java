package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AutoSuggestDropDownEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/dropdownsPractise/";
	String country = "India";

	public void autoDrop(WebDriver driver) {
		driver.get(url);

		WebElement autodrop = driver.findElement(By.id("autosuggest"));
		autodrop.click();
		autodrop.sendKeys("Ind");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		for (WebElement opt : options) {
			if (opt.getText().equalsIgnoreCase(country)) {
				Assert.assertEquals(opt.getText(), country);
				opt.click();
				break;
			}
		}

	}

}
