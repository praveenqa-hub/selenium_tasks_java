package alerts;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {
		AppMain alt = new AppMain();

//		AlertEx1 ae1 = new AlertEx1();
//		ae1.alertDemo();

		AlertEx2 ae2 = new AlertEx2();
		ae2.alertTypes();

		Thread.sleep(3000);
		alt.endTest();
	}

}
