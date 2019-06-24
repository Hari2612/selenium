package com.Appium;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import com.AppiumMain.*;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static java.time.Duration.ofMillis;
public class ScrollExample  extends Capabilities{
	 
	//Generic function for Scroll
	public void swipeByElements (MobileElement startElement, MobileElement endElement,AppiumDriver driver) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

		
		new TouchAction(driver)
                .press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
	
	@Test
	public  void first() throws Exception{
		System.out.println("1");
		AppiumServerJava obj1 = new AppiumServerJava();
		obj1.startServer();
	
		Thread.sleep(5000);
		InitializeCapabilities();
		System.out.println("33333333333333333**************************************************************************************************************************************8");

		//Instantiate Appium Driver#appPackage=com.ril.ajio
		//#appActivity=com.ril.ajio.view.home.HomeActivity
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>( caps);
		Thread.sleep(5000);
				driver.findElement(By.id("com.ril.ajio:id/icon_account_tab")).click();

		MobileElement startElement = null,EndElement = null;
		List<MobileElement> elements1 = driver.findElements(By.id("com.ril.ajio:id/feature_name"));
		for(MobileElement element : elements1) {
			if(element.getAttribute("text").contains("Orders")) {
				 startElement = element;
				break;
			}
		}
		
		
		List<MobileElement> elements2 = driver.findElements(By.id("com.ril.ajio:id/feature_name"));
		for(MobileElement element : elements2) {
			if(element.getAttribute("text").contains("How To Return")) {
				 EndElement = element;
				break;
			}
		}

		swipeByElements(startElement,EndElement,driver);
		
		obj1.stopServer();
		  
	}

	}
 
