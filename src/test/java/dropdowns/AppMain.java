package dropdowns;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {
		// Uncomment to execute
		AppMain drp = new AppMain();
		
		HiddenOptionsDropDown hid = new HiddenOptionsDropDown();
		hid.hiddenOptions();

//		DynamicDropEx1 dd = new DynamicDropEx1();
//		dd.dynamicDropDown();
		
//		StaticDropEx1 sd1 = new StaticDropEx1();
//		sd1.handleStaticDropDown();

//		AutoSuggestDropDownEx1 auto = new AutoSuggestDropDownEx1();
//		auto.autoDrop();

//		DropDownEx2 dx2 = new DropDownEx2();
//		dx2.dropDown();
		
		Thread.sleep(3000);
		drp.endTest();
	}

}
