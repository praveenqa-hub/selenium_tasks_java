package poitasks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		String xlfile = System.getProperty("user.dir") + "\\testdata\\DDTdata.xlsx";
		int rows = ExcelUtilsEx.getRowCount(xlfile, "Sheet1");

		// read data
		for (int i = 1; i <= rows; i++) {
			String principle = ExcelUtilsEx.getCellData(xlfile, "Sheet1", i, 0);
			String roi = ExcelUtilsEx.getCellData(xlfile, "Sheet1", i, 1);
			String period1 = ExcelUtilsEx.getCellData(xlfile, "Sheet1", i, 2);
			String period2 = ExcelUtilsEx.getCellData(xlfile, "Sheet1", i, 3);
			String freq = ExcelUtilsEx.getCellData(xlfile, "Sheet1", i, 4);
			String exp_matvalue = ExcelUtilsEx.getCellData(xlfile, "Sheet1", i, 5);

			// pass data

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement prin_amount = driver.findElement(By.id("principal"));
			jse.executeScript("arguments[0].scrollIntoView();", prin_amount);
			prin_amount.sendKeys(principle);
			driver.findElement(By.id("interest")).sendKeys(roi);
			driver.findElement(By.id("tenure")).sendKeys(period1);
			Select perdrop = new Select(driver.findElement(By.id("tenurePeriod")));
			perdrop.selectByVisibleText(period2);
			Select freqdrop = new Select(driver.findElement(By.id("frequency")));
			freqdrop.selectByVisibleText(freq);

			WebElement calculate_btn = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			jse.executeScript("arguments[0].click();", calculate_btn);

			String act_matvalue = driver.findElement(By.cssSelector("span#resp_matval")).getText();

			Thread.sleep(2000);
			
			if (Double.parseDouble(act_matvalue) == Double.parseDouble(exp_matvalue)) {
				ExcelUtilsEx.fillGreenColor(xlfile, "Sheet1", i, 7);
				
			} else {
				ExcelUtilsEx.fillRedColor(xlfile, "Sheet1", i, 7);
			}

			
			Thread.sleep(2000);
			WebElement clr_btn = driver.findElement(By.xpath("//div[@class='cal_div']//a[2]"));
			jse.executeScript("arguments[0].click();", clr_btn);
		}

		driver.quit();
	}

}
