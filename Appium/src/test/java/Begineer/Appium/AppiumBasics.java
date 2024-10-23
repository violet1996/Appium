package Begineer.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import junit.framework.Assert;

public class AppiumBasics extends BaseTest {
	@Test
	public void wifiSettingName() throws MalformedURLException {

		// ConfigureAppium();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("sumit");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();


	

		
		// tearDown();
	}

}
