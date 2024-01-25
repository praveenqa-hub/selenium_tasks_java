package mousekeyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";

	public void dragDrop() {
		driver.get(url);
		WebElement cap1 = driver.findElement(By.xpath("(//div[text()='Oslo'])[2]"));
		WebElement city1 = driver.findElement(By.xpath("//div[text()='Norway']"));
		
		WebElement cap2 = driver.findElement(By.xpath("(//div[text()='Rome'])[2]"));
		WebElement city2 = driver.findElement(By.xpath("//div[text()='Italy']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(cap1, city1).perform();
		act.dragAndDrop(cap2, city2).perform();
	}
}
