package tasks;

import java.io.IOException;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		AppMain ap = new AppMain();
		// Uncomment to run

//		FlightBookingRS fly = new FlightBookingRS();
//		fly.endToEndTest();
		
		BrokenLinks broken = new BrokenLinks();
		broken.broke();

//		 LoginTestOrangeHrm hrm = new LoginTestOrangeHrm();
//		 hrm.loginTestHrm();

//		 LoginTestRS lrs = new LoginTestRS();
//		 lrs.loginTestRS();

//		 RsAssignment1 rs1 = new RsAssignment1();
//		 rs1.checkBox();

//		RsAssignment2 rs2 = new RsAssignment2();
//		rs2.protractorPage();

//		BlazeTicket blz = new BlazeTicket();
//		blz.blazeFly();

//		DummyTicket dt = new DummyTicket();
//		dt.dummyTicket();

		// driver quits
		Thread.sleep(3000);
		ap.endTest();
	}

}
