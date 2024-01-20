package criotasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CountHyperlinks {
   WebDriver driver = LaunchBrowser.getDriver();

    public void countLinks(){
        // Navigate to the given URL  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        
		// Locate the hyperlink present on page using Using Locator "Tag Name" a
        int count = driver.findElements(By.tagName("a")).size();
        
        //Print the count of the hyperlink  
        System.out.println("hyperlinks count: "+count);
    }
}
