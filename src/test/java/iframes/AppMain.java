package iframes;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppMain ifrm = new AppMain();

		IFrameEx1 ifx1 = new IFrameEx1();
		ifx1.uiVisionFrames();

		ifrm.endTest();
	}

}
