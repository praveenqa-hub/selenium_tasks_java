package misctasks;

import org.openqa.selenium.WebDriver;

public class AppMain extends criotasks.LaunchBrowser {

	AppMain() {
		super();
		
	}

	public static void main(String[] args) {
			// Launch
			AppMain ap = new AppMain();
			WebDriver driver = AppMain.getDriver();
			
			LoginTestOrangeHrm hrm = new LoginTestOrangeHrm();
			hrm.loginTestHrm(driver);
			
			// LoginTestRS lrs = new LoginTestRS();
			// lrs.loginTestRS(driver);
			
			
			// driver quits
			ap.endTest();
	}

}
