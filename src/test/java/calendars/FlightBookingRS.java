package calendars;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FlightBookingRS {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/dropdownsPractise";
	String country = "India";

	public void endToEndTest(WebDriver driver) {
		driver.get(url);
		autoDrop(driver);
		dynamicDropDown(driver);
		handleStaticDropDown(driver);
		calendarFuture(driver);

	}

	public void originToDestination(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']"))
				.click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
	}

	public void dynamicDropDown(WebDriver driver) {
		SoftAssert sa = new SoftAssert();
		Integer adult = 5;
		driver.findElement(By.id("divpaxinfo")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='hrefIncAdt']")));

		int i = 1;
		while (i < adult) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			i++;
		}

		String actual_adult = driver.findElement(By.id("spanAudlt")).getText();
		sa.assertEquals(actual_adult, adult.toString());
		// selecting origin and destination
		originToDestination(driver);
		sa.assertAll();
	}

	public void handleStaticDropDown(WebDriver driver) {

		SoftAssert sa = new SoftAssert();
		WebElement currency_drp = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select sel = new Select(currency_drp);
		sel.selectByValue("USD");
		sel.selectByIndex(2);

		sa.assertEquals(sel.isMultiple(), false);
		sel.selectByVisibleText("INR");

		sa.assertAll();

	}

	public void autoDrop(WebDriver driver) {

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
	
	public void calendarFuture(WebDriver driver) {
		WebElement roundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		roundTrip.click();
		departureDate(driver);
		returnDate(driver);
	}

	public void departureDate(WebDriver driver) {
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
			driver.findElement(By.xpath(String.format("//a[text()=%s]", depart_date.toString()))).click();
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
			driver.findElement(By.xpath(String.format("//a[text()=%s]", return_date.toString()))).click();
		}

		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
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
