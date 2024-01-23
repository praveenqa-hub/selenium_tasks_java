package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginationTableEx1 {

	WebDriver driver = AppMain.getDriver();
	String url = "https://testautomationpractice.blogspot.com/";

	void paginationTable() {

		driver.get(url);
		List<WebElement> tabhead = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th"));

		for (WebElement e : tabhead) {
			System.out.print(e.getText() + "\t");
		}
		for (int page = 2; page <= 4; page++) {
			for (int row = 1; row <= 5; row++) {
				for (int div = 1; div <= 3; div++) {
					System.out.print(driver
							.findElement(By.xpath("//table[@id='productTable']//tbody/tr[" + row + "]/td[" + div + "]"))
							.getText() + "\t");
				}
				System.out.println();

			}

			driver.findElement(By.xpath("//ul[@class='pagination']//a[text()='" + page + "']")).click();

		}

	}
}
