package com.webp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.pageFactory.*;
public class UploadFilePage extends UploadFile {

protected WebDriver driver;
	
	public void selectBrowser(String Browser) {
		System.out.println("90");
		SelectBrowser obj = new SelectBrowser();
		this.driver = obj.SelectBrowser(Browser);
		
	}
	
	public void sele(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
	
	public void setUsername(String s) {
		UserName.sendKeys(s);
	}
	
	public void setPassword(String s) {
		Password.sendKeys(s);
	}
	
	public void clickb() {
		login.click();
	}
	
	public void clickbv() {
		System.out.println("in"); 
		updateResume.sendKeys();;
		System.out.println("isn");
	}
	
	public void clickLogin() {
		loginButton.click();
	}
}
