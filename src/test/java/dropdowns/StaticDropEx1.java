package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class StaticDropEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://rahulshettyacademy.com/dropdownsPractise/";

	public void handleStaticDropDown(WebDriver driver) throws InterruptedException {

		driver.get(url);
		SoftAssert sa = new SoftAssert();
		WebElement currency_drp = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select sel = new Select(currency_drp);
		sel.selectByValue("USD");
		Thread.sleep(2000); // for visibility of changing
		sel.selectByIndex(2);
	
		sa.assertEquals(sel.isMultiple(), false);
		
		WebElement static_Firstsel = sel.getFirstSelectedOption();
		System.out.println("First selected : " + static_Firstsel.getText());
		sel.selectByVisibleText("INR");
		Thread.sleep(2000);

		List<WebElement> opt = sel.getOptions();
		System.out.println("Available options: ");
		for (WebElement e : opt) {
			System.out.println(e.getText());
		}
		sa.assertAll();

	}

}
