package calendars;

import org.openqa.selenium.WebDriver;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {

		AppMain calend = new AppMain();

		WebDriver driver = AppMain.getDriver();
	CalendarCurrentEx1 ca1 = new CalendarCurrentEx1();
		ca1.pickCurrentDate(driver);

		


		Thread.sleep(3000);
		calend.endTest();
	}

}
