package dropdowns;

import org.openqa.selenium.WebDriver;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AppMain drp = new AppMain();

		WebDriver driver = AppMain.getDriver();

//		StaticDropEx1 sd1 = new StaticDropEx1();
//		sd1.handleStaticDropDown(driver);
		
//		DynamicDropEx1 dd = new DynamicDropEx1();
//		dd.DynamicDropDown(driver);
		
		AutoSuggestDropDownEx1 auto = new AutoSuggestDropDownEx1();
		auto.autoDrop(driver);
		
		
		drp.endTest();
	}

}
