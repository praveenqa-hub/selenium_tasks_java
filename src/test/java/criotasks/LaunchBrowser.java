package criotasks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	private static WebDriver driver;

	protected LaunchBrowser() {
		System.out.println("Constructor: TestCases");
		// System.setProperty("webdriver.chrome.driver", ".src/test/resources/chromedriver.exe");
		WebDriverManager.chromedriver().timeout(10).setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public void endTest() {
		System.out.println("End Test: TestCases");
		// driver.close();
		driver.quit();

	}

}
