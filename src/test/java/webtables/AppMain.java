package webtables;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) {

		AppMain tables = new AppMain();

//		StaticTableEx1 table1 = new StaticTableEx1();
//		table1.staticTable();
		
		PaginationTableEx1 ptab = new PaginationTableEx1();
		ptab.paginationTable();

		tables.endTest();
	}

}
