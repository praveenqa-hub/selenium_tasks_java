package mousekeyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class IActionVsCActions {

	WebDriver driver = AppMain.getDriver();
	String url = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";

	public void demo() {
		driver.get(url);
		WebElement cap1 = driver.findElement(By.xpath("(//div[text()='Oslo'])[2]"));
		WebElement city1 = driver.findElement(By.xpath("//div[text()='Norway']"));
		
		WebElement cap2 = driver.findElement(By.xpath("(//div[text()='Rome'])[2]"));
		WebElement city2 = driver.findElement(By.xpath("//div[text()='Italy']"));
		
		WebElement cap3 = driver.findElement(By.xpath("(//div[text()='Copenhagen'])[2]"));
		WebElement city3 = driver.findElement(By.xpath("//div[text()='Denmark']"));
		Actions act = new Actions(driver);
		
		act.dragAndDrop(cap1, city1).perform();
		act.dragAndDrop(cap2, city2).build().perform();
		Action drag3 = act.dragAndDrop(cap3, city3).build(); // creating action and storing to perform later
		drag3.perform();
	}
}
