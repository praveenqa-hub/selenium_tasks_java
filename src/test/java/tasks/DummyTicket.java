package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DummyTicket {

	WebDriver driver = AppMain.getDriver();
	String url = "https://www.dummyticket.com/dummy-ticket-for-visa-application/";
	
	public void dummyTicket() {
		driver.get(url);
		driver.findElement(By.id("travname")).sendKeys("Mahendra Singh");
		driver.findElement(By.id("travlastname")).sendKeys("Dhoni");
		driver.findElement(By.id("dob")).click();
		WebElement month = driver.findElement(By.className("ui-datepicker-month"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("Apr");
		
		WebElement year = driver.findElement(By.className("ui-datepicker-year"));
		Select selectYear = new Select(year);
		selectYear.selectByValue("2020");
		
		String date = "16";
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='"+date+"']")).click();
	}
	
}
