package mousekeyactions;

import criotasks.LaunchBrowser;

public class AppMain extends LaunchBrowser {

	AppMain() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {
		AppMain mouseact = new AppMain();

//		MouseHoverFlipKart1 mou = new MouseHoverFlipKart1();
//		mou.mouseDemo();

//		ContextClick context = new ContextClick();
//		context.rCon();

//		DoubleCMouse doub = new DoubleCMouse();
//		doub.doubleC();

//		DragAndDropEx1 dragd = new DragAndDropEx1();
//		dragd.dragDrop();

		DragAndDropEx2 dg = new DragAndDropEx2();
		dg.dragGuru();

//		SliderEx1  slide1 = new SliderEx1();
//		slide1.sliderJQ();

//		IActionVsCActions ac = new IActionVsCActions();
//		ac.demo();

		Thread.sleep(2000);
		mouseact.endTest();
	}
}
