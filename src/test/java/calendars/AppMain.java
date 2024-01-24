package calendars;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {

		AppMain calend = new AppMain();

		FlightBookingRS flight = new FlightBookingRS();
		flight.endToEndTest();

//		CalendarDatePickEx1 datepick = new CalendarDatePickEx1();
//		datepick.datePicker();

//		CalendarCurrentEx1 ca1 = new CalendarCurrentEx1();
//		ca1.pickCurrentDate();

//		TicketDOB dob = new TicketDOB();
//		dob.calendarDob();

//		CalendarFutureEx1 cf = new CalendarFutureEx1();
//		cf.calendarFuture();

		Thread.sleep(3000);
		calend.endTest();
	}

}
