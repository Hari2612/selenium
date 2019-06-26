package com.Appium;

import org.testng.annotations.Test;
import com.AppiumMain.*;

public class TestSignupPage extends SignupPage{
  @Test
  public void f() throws Exception {
	  AppiumServerJava obj1 = new AppiumServerJava();
		obj1.startServer();
		
	  
	  InitializeDriver();
	  
	  ClickAccount();
	  ClickSignup();
	  EnterMobileNo("7013802059");
	  ClickLoginWithOTP();
	  if(VerifyLoginDetails()) {
		  System.out.println("Login details Verified");
	  }
	  
	  ClickStartShopping();
	  if(VerifyAccountDetails()) {
		  System.out.println("Account details Verified");
	  }
	  
	  obj1.stopServer();
		
  }
}
