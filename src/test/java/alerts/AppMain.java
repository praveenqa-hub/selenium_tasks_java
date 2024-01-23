package alerts;

import org.openqa.selenium.WebDriver;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {
		AppMain alt = new AppMain();
		WebDriver driver = AppMain.getDriver();
		
//		AlertEx1 ae1 = new AlertEx1();
//		ae1.alertDemo(driver);
		
		AlertEx2 ae2 = new AlertEx2();
		ae2.alertTypes(driver);

		Thread.sleep(3000);
		alt.endTest();
	}

}
