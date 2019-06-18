package com.webpp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.webp.*;
import utils.*;

public class TestLinkedinLoginPage extends LinkedinLoginPage {
	
	
	@Test
	public void g() throws Exception {
		String fileName = "C:\\Farmrise\\webp\\src\\test\\java\\com\\webpp\\property.txt"; 
	      FileReader fr = new FileReader(fileName);
	  	  BufferedReader br = new BufferedReader(fr);
		  Reading_From_TextFile obj = new Reading_From_TextFile();
		  ExcelDetails obj1 = new ExcelDetails();
		  String[] str = obj.read(br);
		  
		  
		  String[] ans = new String[10]; 
		  String[] res = new String[10];
		  
		  selectBrowser(str[3]);
	  	  sele(driver);
		  driver.get(str[0]);
		  setLoginMail(str[1]);
		  ans[0] = "User mail Entered";
		  res[0] = "Passed";
		  setLoginPassword(str[2]);
		  ans[1] = "User Password Entered";
		  res[1] = "Passed";
		  clickSignIn();
		  ans[2] = "Sign in button pressed";
		  res[2] = "Passed";
		  
		  if(clickprofilev().contains("Hari")) {
			  ans[3] = "Profile Name Verified";
			  res[3] = "Passed";
		  }
		  else {
			  System.out.println(clickprofilev());
			  ans[3] = "Profile Name Not Verified";
			  res[3] = "failed";
			  
		  }
		 clickprofile();
		 
		 Thread.sleep(5000);
		  
		  if(driver.getCurrentUrl().contains(str[4] + "-" + str[5])) {
			  System.out.println("Verified");
			  ans[4] = "Profile Url Verified";
			  res[4] = "Passed";
		  }
		  else {
			  res[4] = "Failed";
			  ans[4] = "Profile Url not Verified";
		  }
		  obj1.writeExcel("C:\\Farmrise\\webp\\src", "Book1.xlsx","Sheet1", ans, 1);
		  System.out.println("Done");
		  obj1.writeExcel("C:\\Farmrise\\webp\\src", "Book1.xlsx","Sheet1", res, 2);
		  
	}
	
	/*
  @Test
  public void f() throws Exception {
	  String fileName = "C:\\Farmrise\\webp\\src\\test\\java\\com\\webpp\\property.txt"; 
      FileReader fr = new FileReader(fileName);
  	  BufferedReader br = new BufferedReader(fr);
	  Reading_From_TextFile obj = new Reading_From_TextFile();
	  String[] str = obj.read(br);
	  
	  selectBrowser(str[3]);
  	  sele(driver);
	  driver.get(str[0]);
	  setLoginMail(str[1]);
	  setLoginPassword(str[2]);
	  clickSignIn();
	  System.out.println(isErrorMessageDisplayed());
	  if(isErrorMessageDisplayed()) {
		  clickJoinNow();
		  setFirstName(str[4]);
		  setLastName(str[5]);
		  setSignInMail(str[1]);
		  setSignInPassword(str[2]);
		  clickJoinButton();
		  
	  }
	  else
		  System.out.println("hoho");
	  
	  setLoginMail(str[1]);
	  setLoginPassword(str[2]);
	  clickSignIn();
	  if(driver.getCurrentUrl().contains(str[4] +"-"+ str[5])) {
		  System.out.println("profile url address verified");
	  }
  }
  */
}
