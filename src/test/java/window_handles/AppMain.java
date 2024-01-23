package window_handles;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {

		AppMain winhand = new AppMain();

//		OrangeHrmDemo orng = new OrangeHrmDemo();
//		orng.winHand();

		MultipleWindowEX1 mw = new MultipleWindowEX1();
		mw.multiWindowApproach1();
		mw.multiWindowApproach2();
		
		Thread.sleep(2000);
		winhand.endTest();
	}

}
