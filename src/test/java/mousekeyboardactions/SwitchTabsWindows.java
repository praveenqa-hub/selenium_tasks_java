package mousekeyboardactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class SwitchTabsWindows {

	WebDriver driver = AppMain.getDriver();
	String url1 = "https://www.amazon.in/";
	String url2 = "https://www.flipkart.com/";
	String url3 = "https://www.airasia.com/en/gb";

	public void switchTabsAndWindows() {
		driver.get(url1);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url2);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get(url3);

	}
}
