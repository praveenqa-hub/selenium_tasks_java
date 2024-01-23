package window_handles;

import org.openqa.selenium.WebDriver;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser{

	AppMain(){
		super();
	}
	public static void main(String[] args) throws InterruptedException {
		
		AppMain winhand = new AppMain();
		WebDriver driver = AppMain.getDriver();
		
		OrangeHrmDemo orng = new OrangeHrmDemo();
		orng.winHand();
		
		Thread.sleep(2000);
		winhand.endTest();
	}

}
