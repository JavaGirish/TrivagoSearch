package com.trivago.util;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trivago.base.TestBase;

public class TestUtil extends TestBase {

	
	public static String checkinDate = "2019-05-23";

	public static String checkOutDate = "2019-05-28";
	public static String roomType = "Double room";
	public static String expectedPageTitle = "trivago.in�- Compare hotel prices worldwide";
	public static int LONG_WAIT = 180;
	public static String city= "Barcelona";

	public static void wait(int timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void switchtoWindow() throws InterruptedException {
		Thread.sleep(30000);
		ArrayList<String> newtab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newtab.get(newtab.size() - 1));

	}

}
