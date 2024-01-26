package screenshotdemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakesScreenshotEx1 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tgt = new File("./screenshot/screenshotdemo.png");
		FileUtils.copyFile(src, tgt);
		
		WebElement req = driver.findElement(By.xpath("//div[@class='tLbyDf']"));
		File reqSrc = req.getScreenshotAs(OutputType.FILE);
		File tgtSrc = new File("./screenshot/screenshotflipkart.png");
		FileUtils.copyFile(reqSrc, tgtSrc);
		

	}
	
}
