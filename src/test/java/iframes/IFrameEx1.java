package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFrameEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://ui.vision/demo/webtest/frames/";

	void uiVisionFrames() {
		driver.get(url);

		// frame 3 contains inner frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_3.html']")));
		driver.findElement(By.name("mytext3")).sendKeys("Yuvi entered Frame 3");
		// switching to inner frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("i5")).click();
		driver.findElement(By.xpath("//div[@aria-label='Web Testing']")).click();
		driver.switchTo().defaultContent();

		// frame 1
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_1.html']")));
		driver.findElement(By.name("mytext1")).sendKeys("Yuvi entered Frame 1");
		driver.switchTo().defaultContent();
		// frame 2
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_2.html']")));
		driver.findElement(By.name("mytext2")).sendKeys("Yuvi entered Frame 2");
		driver.switchTo().parentFrame();
		// frame 4
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_4.html']")));
		driver.findElement(By.name("mytext4")).sendKeys("Yuvi entered Frame 4");
		driver.switchTo().defaultContent();
		// frame 5
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_5.html']")));
		// frame(index) Frame index starts with 0
		// driver.switchTo().frame(5);
		driver.findElement(By.name("mytext5")).sendKeys("Yuvi entered Frame 5");
		driver.switchTo().defaultContent();

	}
}
