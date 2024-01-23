package iframes;

import org.openqa.selenium.WebDriver;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser{

	AppMain(){
		super();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppMain ifrm = new AppMain();
		WebDriver driver = AppMain.getDriver();
		
		IFrameEx1 ifx1 = new IFrameEx1();
		ifx1.uiVisionFrames(driver);
		
		
		ifrm.endTest();
	}

}
