package mousekeyactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	WebDriver driver = AppMain.getDriver();
	String url = "https://swisnl.github.io/jQuery-contextMenu/demo.html";

	void rCon() {
		driver.get(url);
		WebElement target = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act = new Actions(driver);
		act.contextClick(target).perform();
		
		WebElement cop = driver.findElement(By.xpath("//span[text()='Copy']"));
		act.moveToElement(cop).click().perform();
		driver.switchTo().alert().accept();
	}
}
