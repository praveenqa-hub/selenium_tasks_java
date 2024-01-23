package calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarCurrentEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/dropdownsPractise";
	
	void pickCurrentDate() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.cssSelector("div.ui-datepicker-group-first a.ui-state-default")).click();
		
	}
}
