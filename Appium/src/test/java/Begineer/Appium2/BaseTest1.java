package Begineer.Appium2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest1 {

	public AndroidDriver driver;
	public AppiumDriverLocalService serviceBuilder;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {

		serviceBuilder = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\sumit\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		serviceBuilder.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("SumitEmulator");
		options.setApp("C:\\Users\\sumit\\eclipse-workspace1\\Appium\\src\\test\\java\\Resources\\General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	

	@AfterClass
	public void tearDown() {
		driver.quit();
		serviceBuilder.stop();
	}

}
