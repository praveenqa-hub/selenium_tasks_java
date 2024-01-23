package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaticTableEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://testautomationpractice.blogspot.com/";

	public void staticTable() {

		driver.get(url);

		int col_count = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("no of columns : " + col_count);

		int row_count = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("no of rows : " + row_count);

		// specific row, col date 2,3
		String specificdata = driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]//td[3]")).getText();
		System.out.println(specificdata);

		// read data from all rows
		List<WebElement> headers = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		for (WebElement w : headers) {
			System.out.print(w.getText() + " ");
		}
		// table[@name='BookTable']//tr[2]//td[1]
		// //table[@name='BookTable']//tr["+r+"]//td["+c+"]"
		for (int i = 2; i <= 7; i++) {
			for (int j = 1; j <= 4; j++) {
				String value = (driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[" + j + "]"))
						.getText());
				System.out.print(value + "\t");
			}
			System.out.println();
		}

		// book names author Amit
		for (int i = 2; i <= 7; i++) {
			String value = (driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[2]")).getText());
			if (value.equals("Amit")) {
				System.out.println("Author Amit : "
						+ driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[1]")).getText());
			}

		}
		
		//sum of prices //table[@name='BookTable']//tr[2]//td[4]
		int total = 0;
		for (int i = 2; i <= 7; i++) {
		String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
		total += Integer.parseInt(price);
		}
		System.out.println("Total Cost of Books : "+total);
	}
}
