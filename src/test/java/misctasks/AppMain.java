package misctasks;

public class AppMain extends criotasks.LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {

		AppMain ap = new AppMain();
		// Uncomment to run
//		 LoginTestOrangeHrm hrm = new LoginTestOrangeHrm();
//		 hrm.loginTestHrm();

		// LoginTestRS lrs = new LoginTestRS();
		// lrs.loginTestRS();

//		 RsAssignment1 rs1 = new RsAssignment1();
//		 rs1.checkBox();

//		RsAssignment2 rs2 = new RsAssignment2();
//		rs2.protractorPage();

//		FlightBookingRS fly = new FlightBookingRS();
//		fly.endToEndTest();

//		BlazeTicket blz = new BlazeTicket();
//		blz.blazeFly();

		// driver quits
		Thread.sleep(3000);
		ap.endTest();
	}

}
