package mousekeyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAndDropEx2 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://demo.guru99.com/test/drag_drop.html";

	void dragGuru() {
		driver.get(url);
		WebElement srcBank = driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		WebElement srcSales = driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
		WebElement fund1 = driver.findElement(By.xpath("(//li[@id='fourth']//a)[1]"));
		WebElement fund2 = driver.findElement(By.xpath("(//li[@id='fourth']//a)[2]"));
		WebElement tgtBank = driver.findElement(By.id("bank"));
		WebElement tgtSales = driver.findElement(By.id("loan"));
		WebElement tgtfund1 = driver.findElement(By.id("amt7"));
		WebElement tgtfund2 = driver.findElement(By.id("amt8"));
		Actions act = new Actions(driver);
		act.dragAndDrop(fund1, tgtfund1).perform();
		act.dragAndDrop(fund2, tgtfund2).perform();
		act.dragAndDrop(srcBank, tgtBank).perform();
		act.dragAndDrop(srcSales, tgtSales).perform();
		Assert.assertEquals(driver.findElement(By.id("equal")).getText(),"Perfect!");
	}
}
