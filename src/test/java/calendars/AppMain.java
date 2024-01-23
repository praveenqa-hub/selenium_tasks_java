package calendars;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {

		AppMain calend = new AppMain();

		CalendarCurrentEx1 ca1 = new CalendarCurrentEx1();
		ca1.pickCurrentDate();

		Thread.sleep(3000);
		calend.endTest();
	}

}
