package mousekeyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SliderEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI";

	void sliderJQ() {
		driver.get(url);
		WebElement minEnd = driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
		WebElement maxEnd = driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));

		System.out.println("min location: " + minEnd.getLocation());
		System.out.println("max location: " + maxEnd.getLocation());

		Actions act = new Actions(driver);
		act.dragAndDropBy(minEnd, 125, 250).perform();
		act.dragAndDropBy(maxEnd, -100, 250).perform();

		System.out.println("After sliding : ");
		System.out.println("min location: " + minEnd.getLocation());
		System.out.println("max location: " + maxEnd.getLocation());

	}
}
