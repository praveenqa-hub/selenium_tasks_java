package mousekeyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	WebDriver driver = AppMain.getDriver();
	String url = "https://text-compare.com/";

	public void keyboardAct() {
		driver.get(url);
		WebElement area1 = driver.findElement(By.cssSelector("textarea#inputText1"));
		WebElement area2 = driver.findElement(By.cssSelector("textarea#inputText2"));
		area1.sendKeys("Automation Test Engineer");
		Actions act = new Actions(driver);

		// ctrl +a
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

		// ctrl +c
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

		// tab
		act.sendKeys(Keys.TAB).perform();

		// ctrl +v
		 act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		//act.keyDown(area2, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

	}

}
