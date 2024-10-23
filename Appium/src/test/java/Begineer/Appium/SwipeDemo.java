package Begineer.Appium;

//import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
public class SwipeDemo extends BaseTest {
	
	@Test
	public void SwipeDemoTest()
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	
	driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
	WebElement firstImage= 	driver.findElement(By.xpath("//android.widget.ImageView[1]"));
	Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "true");
	//swipe
	
	swipeAction(firstImage, "left");
	Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "false");
	}
}
