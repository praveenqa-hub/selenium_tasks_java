package misctasks;

public class AppMain extends criotasks.LaunchBrowser {

	AppMain() {
		super();

	}

	public static void main(String[] args) {

		AppMain ap = new AppMain();

		// Uncomment to run
//		 LoginTestOrangeHrm hrm = new LoginTestOrangeHrm();
//		 hrm.loginTestHrm();

		// LoginTestRS lrs = new LoginTestRS();
		// lrs.loginTestRS();

//		 RsAssignment1 rs1 = new RsAssignment1();
//		 rs1.checkBox();

		RsAssignment2 rs2 = new RsAssignment2();
		rs2.protractorPage();
		// driver quits
		ap.endTest();
	}

}
