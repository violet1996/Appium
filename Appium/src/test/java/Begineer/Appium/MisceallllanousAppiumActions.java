package Begineer.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import junit.framework.Assert;

public class MisceallllanousAppiumActions extends BaseTest {
	@SuppressWarnings("deprecation")
	@Test
	public void wifiSettingName() throws MalformedURLException {

		// ConfigureAppium();
		//adb shell dumpsys window | find "mCurrentFocus"
		// reach directly to activity page
		Activity activity=new Activity(" io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
	/*	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();*/
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscapeDeviceRotation=new DeviceRotation(0, 0, 90);
		driver.rotate(landscapeDeviceRotation);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		//set clipboard text
		driver.setClipboardText("Sumit Wifi");
		
		//retreive clipboard text
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));


	

		
		// tearDown();
	}

}
