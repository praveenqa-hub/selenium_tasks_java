package calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarDatePickEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://jqueryui.com/datepicker/";
	
	public void datePicker() throws InterruptedException {
		driver.get(url);
		pastDatePicker();
		Thread.sleep(3000);
		futureDatePicker();
	}

	public void pastDatePicker() {

		
		String reqYear = "2023";
		String reqDate = "5";
		String reqMonth = "July";

		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();

		while (true) {
			String actualMonth = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
			String actualYear = driver.findElement(By.cssSelector("span[class='ui-datepicker-year']")).getText();
			if (reqMonth.equals(actualMonth) && reqYear.equals(actualYear)) {
				driver.findElement(By.xpath("//td[@Data-handler='selectDay']/a[text()='" + reqDate + "']")).click();
				break;
			}
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
		}
		driver.switchTo().defaultContent();

	}

	public void futureDatePicker() {
		
		String reqYear = "2025";
		String reqDate = "14";
		String reqMonth = "January";

		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();

		while (true) {
			String actualMonth = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
			String actualYear = driver.findElement(By.cssSelector("span[class='ui-datepicker-year']")).getText();
			if (reqMonth.equals(actualMonth) && reqYear.equals(actualYear)) {
				driver.findElement(By.xpath("//td[@Data-handler='selectDay']/a[text()='" + reqDate + "']")).click();
				break;
			}
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
		driver.switchTo().defaultContent();
	}

}
