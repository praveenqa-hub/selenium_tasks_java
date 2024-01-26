package screenshotdemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TakesScreenshotEx2 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		capture(driver);
		

	}
	
	public static void capture(WebDriver driver) throws IOException {
		// TakesScreenshot ts = (TakesScreenshot) driver;
				// TakesScreenshot ts = driver;

				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
				String moment = sdf.format(date).toString().replace(":", "_");
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./screenshot/"+"sshot_"+moment+".png"));
	}

}
