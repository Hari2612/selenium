package com.Appium;


import static java.time.Duration.ofMillis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.AppiumMain.*;
import utils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
 
public class ProfileChecking  extends Capabilities{
	 
	 
	
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

		//Instantiate Appium Driver
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>( caps);

			//Added 5 seconds wait so that the app loads completely before starting with element identification
		driver.findElement(By.id("com.ril.ajio:id/icon_account_tab")).click();
		driver.findElement(By.id("com.ril.ajio:id/signin_bt_myact")).click();
		driver.findElement(By.id("com.ril.ajio:id/et_login_mobilenumber_emailid")).sendKeys("7013802059");
		((AndroidDriver<MobileElement>) driver).pressKeyCode(66);
		Thread.sleep(6000);
		//driver.findElement(By.id("com.ril.ajio:id/loginpassword_btn_login")).click();
		
		
		List<MobileElement> elements = driver.findElements(By.id("com.ril.ajio:id/loginpassword_btn_login"));
			for(MobileElement element : elements) {
				if(element.getAttribute("text").contains("LOGIN WITH OTP")) {
					element.click();
					break;
				}
			}
			Thread.sleep(10000);
			driver.findElement(By.id("com.ril.ajio:id/btn_signinotp_startshopping")).click();
			Thread.sleep(6000);
		
			

			
			
			
		/*	MobileElement startElement = null,EndElement = null;
			List<MobileElement> elements11 = driver.findElements(By.id("com.ril.ajio:id/feature_name"));
			for(MobileElement element : elements11) {
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
			*/
			
			String[] ans = new String[1];
			if((driver.findElement(By.id("com.ril.ajio:id/user_name")).getAttribute("text")).equals("Hari")) {
				ans[0] = "passed";
				System.out.println("hhhhhhhhhhhhh");
			}
			else
				ans[0] = "failed";
			
			ExcelDetails obj2 = new ExcelDetails();
			obj2.writeExcel("C:\\Farmrise\\webp\\src\\test\\java\\com\\Appium", "Book1.xlsx","Sheet1", ans, 1);
			obj1.stopServer();
	}

	}
 
