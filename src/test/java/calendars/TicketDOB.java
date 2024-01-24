package calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TicketDOB {

	WebDriver driver = AppMain.getDriver();
	String url = "https://www.dummyticket.com/dummy-ticket-for-visa-application/";
	
	void calendarDob(){
		driver.get(url);
		driver.findElement(By.id("dob")).click();
		WebElement month = driver.findElement(By.className("ui-datepicker-month"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("Apr");
		
		WebElement year = driver.findElement(By.className("ui-datepicker-year"));
		Select selectYear = new Select(year);
		selectYear.selectByValue("2014");
		
		String date = "21";
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='"+date+"']")).click();
	}
}
