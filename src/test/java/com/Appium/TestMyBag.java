package com.Appium;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.AppiumMain.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestMyBag extends MyBagPage{
	AppiumServerJava obj1 = new AppiumServerJava();
  @SuppressWarnings("deprecation")
@Test
  public void f() throws Exception {
	                  
	  AppiumServerJava obj1 = new AppiumServerJava();
		obj1.startServer();
		
		Thread.sleep(5000);
		InitializeDriver();
		Thread.sleep(5000);
		
		ClickBag();
		if(IsBagEmpty()) {
			System.out.println("Bag is Empty");
			driver.findElement(By.id("com.ril.ajio:id/btn_continue_shopping")).click();
			driver.findElement(By.id("com.ril.ajio:id/row_search_component_tv_search")).click();
			driver.findElement(By.id("com.ril.ajio:id/search_src_text")).sendKeys("Sneakers for men");
			((AndroidDriver<MobileElement>) driver).pressKeyCode(66);
			Thread.sleep(4000);
			while(!IsItemFound())
			verticalSwipeByPercentages();
			
			if(VerifyItemDetails()) {
				System.out.println("verified Item Details");
				AddToCart();
				ViewBag();
				
				if(VerifyItemDetailsInBag()) {
					ProceedToShipping();
					ProceedToPayment();
					
				}
			}
			else {
				System.out.println("Failed Item Verification");
			}
			

		}	
		else {
			Back();
			String s1 = BagCount();
			System.out.println(s1);
			ClickBag();
			String s2 = ItemCount();
			System.out.println(s2);
			if(s2.contains(s1)) {
				System.out.println("Bag Count verified");
			}
			else {
				System.out.println("Bag count failed");
			}
		}
			
  }
  //Medium  = 17
  //Hard = 3
  //Easy = 41
  //Matrix = 80-85	
  //Tree = 146
  //BST = 46
  //Hepas= 20
  //Hashing = 127
  //Stack = 43
  //queue = 31
  //arrays = 150+
  //Graphs = 64
  //searching = 59
  @AfterTest
  public void g() {
	  obj1.stopServer();
  }
}
