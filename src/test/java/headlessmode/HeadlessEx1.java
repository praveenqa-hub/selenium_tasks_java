package headlessmode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessEx1 {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[@title='Login']")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
	}
}
