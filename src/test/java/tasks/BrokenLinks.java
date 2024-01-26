package tasks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinks {

	WebDriver driver = AppMain.getDriver();
	String url = "http://www.deadlinkcity.com/";

	void broke() {
		driver.get(url);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("links count : " + links.size());

		// Iterate through each link and check for broken links
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				// Check if the link is a valid URL
				try {
					URL linkUrl = new URL(url);
					HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
					connection.setConnectTimeout(5000);
					connection.connect();

					// Check the response code
					int responseCode = connection.getResponseCode();
					if (responseCode >= 400) {
						System.out.println("Broken Link: " + url + " - Response Code: " + responseCode);
					}

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println("Error while checking link " + url + ": " + e.getMessage());
				}
			}
		}
	}

}
