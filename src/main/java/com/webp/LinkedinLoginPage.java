package com.webp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pageFactory.*;

public class LinkedinLoginPage extends LinkedinLoginPageFactory{
	
	protected WebDriver driver;
	
	public void selectBrowser(String Browser) {
		SelectBrowser obj = new SelectBrowser();
		this.driver = obj.SelectBrowser(Browser);
		
	}
	
	
	public void setLoginMail(String mail) {
		LoginEmail.sendKeys(mail);
	}
	
	public void setLoginPassword(String password) {
		LoginPassword.sendKeys(password);
	}
	
	public void clickSignIn() {
		SignInButton.submit();;
	}
	
	public void clickJoinNow() {
		JoinNowButton.click();
	}
	
	public boolean isErrorMessageDisplayed() {
		return Errormsg.isEnabled();
	}
	
	public void sele(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
	
	
	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		LastName.sendKeys(lname);
	}
	
	public void setSignInMail(String mail) {
		SignInMail.sendKeys(mail);
	}
	
	public void setSignInPassword(String password) {
		SignInPassword.sendKeys(password);
	}
	
	public void clickJoinButton() {
		JoinButton.click();
	}
	
	public void clickprofile() {
		 profile.click();
	}
	
	public String clickprofilev() {
		 return profilev.getText();
	}
	

}
