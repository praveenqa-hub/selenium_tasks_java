package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownEx2 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/";
	
	public void dropDown(WebDriver driver){
		driver.get(url);
		
		//not using select class
		driver.findElement(By.id("country-list")).click();
		List<WebElement> countryopt = driver.findElements(By.cssSelector("select#country-list option"));
		for(WebElement e:countryopt) {
			if(e.getText().equalsIgnoreCase("usa")) {
				e.click();
				break;
			}
		}
		
		driver.findElement(By.id("state-list")).click();
		List<WebElement> stateopt = driver.findElements(By.cssSelector("select#state-list option"));
		for(WebElement e:stateopt) {
			if(e.getText().equalsIgnoreCase("new york")) {
				e.click();
				break;
			}
		}
		
		//using select
		WebElement country = driver.findElement(By.id("country-list"));
		Select sel = new Select(country);
		sel.selectByValue("5");
		
		WebElement state = driver.findElement(By.id("state-list"));
		Select selstate = new Select(state);
		selstate.selectByVisibleText("Iowa");
		
	}
}
