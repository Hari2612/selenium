package com.Appium;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.AppiumMain.*;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
 
public class FirstCode  extends Capabilities{
	@Test
	public  void first() throws Exception{
		System.out.println("1");
		AppiumServerJava obj1 = new AppiumServerJava();
		obj1.startServer();
		Thread.sleep(5000);
		InitializeCapabilities();

		//Instantiate Appium Driver
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>( caps);

			//Added 5 seconds wait so that the app loads completely before starting with element identificationappPackage=in.startv.hotstar
		//appActivity=in.startv.hotstar.rocky.home.HomeActivity
			
			System.out.println("33333333333333333**************************************************************************************************************************************8");
			
			driver.findElement(By.id("com.whatsapp:id/menuitem_search")).click();
			driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("Niyas");
			List<MobileElement> elements = driver.findElements(By.id("com.whatsapp:id/conversations_row_contact_name"));
				for(MobileElement element : elements) {
					if(element.getAttribute("text").contains("Niyas")) {
						element.click();
						break;
					}
				}
				for(int i=0;i<100;i++) {
				driver.findElement(By.className("android.widget.EditText")).sendKeys("Hello");
				driver.findElement(By.id("com.whatsapp:id/send")).click();
				}

/*
 * pages to be created
SigninPage(username and verify all details)(while entering otp the mail stars one)
HomePage(all the icons to be verified)
Mybag page verify
identify swipedown  and swipe up (swipe until element is displayed (do while loop)) until u find the requireditem to be ordered
add the item to the cart and verify whether the cart shows the popup in the home page
verify the costs in each page (first take the cost and verify whether it as same cost when u open the item)
go to my bag and verify whether the item is added correctly
check  the all buttons and verify the payments option and proceed
 
 */
			
	
			
			obj1.stopServer();
	}

	}
 
