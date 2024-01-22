package calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarFutureEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/dropdownsPractise/";

	public void calendarFuture(WebDriver driver) throws InterruptedException {
		driver.get(url);
		WebElement roundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		 roundTrip.click();
		departureDate(driver);
		returnDate(driver);

	}

	public void departureDate(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		String current_month = driver.findElement(By.className("ui-datepicker-month")).getText();
		int act_month = month(current_month);
		int dep_month = month("April");
		Integer depart_date = 25;
		// ui-datepicker-year
		if (act_month == dep_month) {
			driver.findElement(By.xpath(String.format("//a[text()=%s]", depart_date.toString()))).click();
		} else {
			int i = dep_month - act_month;
			for (int j = 0; j < i; j++) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			driver.findElement(By.xpath(String.format("//a[text()=%s]",depart_date.toString()))).click();
		}
	}

	public void returnDate(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		String current_month = driver.findElement(By.className("ui-datepicker-month")).getText();
		int act_month = month(current_month);
		Integer return_date = 27;
		int return_month = month("June");
		if (act_month == return_month) {
			driver.findElement(By.xpath(String.format("//a[text()=%s]", return_date.toString()))).click();
		} else {
			int i = return_month - act_month;
			for (int j = 0; j < i; j++) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			driver.findElement(By.xpath(String.format("//a[text()=%s]",return_date.toString()))).click();
		}
	}

	public int month(String month) {
		switch (month.toLowerCase()) {
		case "january":
			return 1;
		case "february":
			return 2;
		case "march":
			return 3;
		case "april":
			return 4;
		case "may":
			return 5;
		case "june":
			return 6;
		case "july":
			return 7;
		case "august":
			return 8;
		case "september":
			return 9;
		case "october":
			return 10;
		case "november":
			return 11;
		case "december":
			return 12;
		default:
			return 0;
		}
	}
}
