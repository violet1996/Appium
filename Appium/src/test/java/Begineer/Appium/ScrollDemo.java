package Begineer.Appium;

//import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

//import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {
	@Test
	public void ScrollDemoTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
	//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WebView\"));"));
		
	/*
	 * boolean canScrollMore; do { canScrollMore=
	 * (boolean)driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
	 * "left",100, "top", 100, "width", 200, "height", 200, "direction" , "down",
	 * "percent", 3.0)); }while(canScrollMore);
	 *
	 */
		scrollToEndAction();
	
	}

}
