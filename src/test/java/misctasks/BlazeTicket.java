package misctasks;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BlazeTicket {

	WebDriver driver = AppMain.getDriver();
	String url = "https://blazedemo.com/";

	public void blazeFly() {
		driver.get(url);

		WebElement fromPort = driver.findElement(By.name("fromPort"));
		Select fromSel = new Select(fromPort);
		fromSel.selectByValue("Paris");
		WebElement toPort = driver.findElement(By.name("toPort"));
		Select toSel = new Select(toPort);
		toSel.selectByVisibleText("Berlin");
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://blazedemo.com/reserve.php");

		List<WebElement> headers = driver.findElements(By.xpath("//table//th"));
		for (WebElement thead : headers) {
			System.out.print(thead.getText() + "\t");
		}
		System.out.println();

		for (int row = 1; row <= 5; row++) {
			for (int div = 2; div <= 6; div++) {
				String value = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + div + "]")).getText();
				System.out.print("\t" + value + "\t");
			}
			System.out.println();
		}

		List<WebElement> price = driver.findElements(By.xpath("// tbody/tr/td[6]"));
		float[] priceArray = new float[price.size()];
		for (int i = 0; i < price.size(); i++) {
			String value = price.get(i).getText();
			priceArray[i] = Float.parseFloat(value.substring(value.indexOf("$") + 1));
		}

		Arrays.sort(priceArray);
		System.out.println(Arrays.toString(priceArray));

		driver.findElement(
				By.xpath("//tbody//td[contains(text(),'" + priceArray[0] + "')]/preceding-sibling::td/input")).click();

		driver.findElement(By.id("inputName")).sendKeys("Yuvi");
		driver.findElement(By.name("address")).sendKeys("Bridge Toli");
		driver.findElement(By.id("state")).sendKeys("wakanda");
		driver.findElement(By.id("zipCode")).sendKeys("999888");
		driver.findElement(By.id("cardType")).click();
		driver.findElement(By.xpath("//option[@value='amex']")).click();
		driver.findElement(By.id("creditCardNumber")).sendKeys("123456789");
		WebElement month = driver.findElement(By.id("creditCardMonth"));
		month.clear();
		month.sendKeys("02");
		driver.findElement(By.id("nameOnCard")).sendKeys("Selenium Trainer");
		driver.findElement(By.id("rememberMe")).click();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://blazedemo.com/confirmation.php");
		Assert.assertTrue(driver.findElement(By.xpath("//h1")).getText().contains("Thank you"));

	}
}
