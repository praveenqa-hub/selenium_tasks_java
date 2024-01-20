package criotasks;

import java.awt.AWTException;
import java.io.IOException;

public class AppMain {
	public void getGreeting() throws InterruptedException, IOException, AWTException {
		LaunchBrowser tests = new LaunchBrowser(); // Initialize your test class

		// uncomment a task to execute
		CountHyperlinks hyper = new CountHyperlinks();
		// hyper.countLinks();

		SearchAmazon sa = new SearchAmazon();
		// sa.searchAmazon();

		TextLinkedin lin = new TextLinkedin();
		// lin.textPost();

		GoogleNameLinks name = new GoogleNameLinks();
		 name.nameLinks();

		BmsImageUrl iurl = new BmsImageUrl();
		// iurl.imgUrl();

		NestedFrames nf = new NestedFrames();
		// nf.nFrame();

		IMDBRatings imdbr = new IMDBRatings();
		// imdbr.imdb();

		WindowHandle wh = new WindowHandle();
		// wh.winHandle();

		ImageLinkedin imglinked = new ImageLinkedin();
		// imglinked.imagePost();

		VideoLinkedin vlinked = new VideoLinkedin();
		// vlinked.videoPost();
		// END Tests

		tests.endTest(); // End your test by clearing connections and closing browser
	}

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		new AppMain().getGreeting();
	}
}
