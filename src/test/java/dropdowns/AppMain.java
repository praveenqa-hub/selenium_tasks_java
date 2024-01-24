package dropdowns;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {
		// Uncomment to execute
		AppMain drp = new AppMain();

//		StaticDropEx1 sd1 = new StaticDropEx1();
//		sd1.handleStaticDropDown();

//		DynamicDropEx1 dd = new DynamicDropEx1();
//		dd.DynamicDropDown();

//		AutoSuggestDropDownEx1 auto = new AutoSuggestDropDownEx1();
//		auto.autoDrop();

//		DropDownEx2 dx2 = new DropDownEx2();
//		dx2.dropDown();
		
		HiddenOptionsDropDown hid = new HiddenOptionsDropDown();
		hid.hiddenOptions();
		

		Thread.sleep(3000);
		drp.endTest();
	}

}
