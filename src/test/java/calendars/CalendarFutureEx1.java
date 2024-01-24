package calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarFutureEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/dropdownsPractise/";

	public void calendarFuture() {
		driver.get(url);
		WebElement roundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		roundTrip.click();
		departureDate();
		returnDate();
	}

	public void datePicker(String reqMonth, String reqYear, String reqDate) {

		while (true) {
			String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			String currentYear = driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText();
			if (currentMonth.equals(reqMonth) && currentYear.equals(reqYear)) {
				driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='" + reqDate + "']")).click();
				break;
			}
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
	}

	public void departureDate() {
		String reqMonth = "September";
		String reqYear = "2024";
		String reqDate = "14";
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		datePicker(reqMonth, reqYear, reqDate);
	}

	public void returnDate() {
		String reqMonth = "October";
		String reqYear = "2024";
		String reqDate = "24";
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		datePicker(reqMonth, reqYear, reqDate);
	}

}
