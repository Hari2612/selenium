package com.Appium;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.AppiumMain.*;

public class TesthomePage extends HomePage {
	
	public void verifyText(String s) {
		String m = driver.findElement(By.id("com.ril.ajio:id/toolbar_title")).getText();
		if(m.equals(s))	
				System.out.println(s +" verified");
		else
			System.out.println("Failed" + m +" "+s);
	}
	
	public void VerifyCategory(String s) {
		String m = driver.findElement(By.id("com.ril.ajio:id/bt_toolbar_category")).getText();
		if(m.equals(s))	
				System.out.println(s +" verified");
		else
			System.out.println("Failed" + m +" "+s);
	}
	
  @Test
  public void f() throws Exception {
	  AppiumServerJava obj1 = new AppiumServerJava();
		obj1.startServer();
		
		Thread.sleep(5000);
		InitializeDriver();
		Thread.sleep(5000);
		
		ClickCollections();
		verifyText("Collections");
		
		
		ClickCloset();
		verifyText("My Closet");

		
		ClickBag();
		verifyText("My Bag");
		Back();

		
		ClickAccount();
		verifyText("My Account");
		ClickHome();
		
		ClickNotification();
		verifyText("Notifications");
		Back();
		
		Changecategory();
		ClickCategory("Women");
		VerifyCategory("Women");
		
		Changecategory();
		ClickCategory("Kids");
		VerifyCategory("Kids");
		
		Changecategory();
		ClickCategory("Sale");
		VerifyCategory("Sale");
		Thread.sleep(1000);
		
		Changecategory();
		ClickCategory("Men");
		VerifyCategory("Men");
		
		
		
		
		
		obj1.stopServer();
		
  }
}
