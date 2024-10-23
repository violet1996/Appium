package Begineer.Appium;

//import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
public class DragDropDemo extends BaseTest {
	
	@Test
	public void DragDropDemoTest()
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	
	driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	WebElement source= 	driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	
	dragDropAction(source);
	String resultString=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
	Assert.assertEquals(resultString, "Dropped!");

	}
}
