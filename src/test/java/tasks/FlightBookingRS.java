package tasks;

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

	public void endToEndTest() {
		driver.get(url);
		autoDrop();
		dynamicDropDown();
		handleStaticDropDown();
		calendarFuture();

	}

	public void originToDestination() {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']"))
				.click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
	}

	public void dynamicDropDown() {
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
		originToDestination();
		sa.assertAll();
	}

	public void handleStaticDropDown() {

		SoftAssert sa = new SoftAssert();
		WebElement currency_drp = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select sel = new Select(currency_drp);
		sel.selectByValue("USD");
		sel.selectByIndex(2);

		sa.assertEquals(sel.isMultiple(), false);
		sel.selectByVisibleText("INR");

		sa.assertAll();

	}

	public void autoDrop() {

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
	public void calendarFuture() {
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
