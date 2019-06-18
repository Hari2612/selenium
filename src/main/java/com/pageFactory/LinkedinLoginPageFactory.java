	package com.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedinLoginPageFactory {
	
	@FindBy(id = "username")
	protected WebElement LoginEmail;
	
	@FindBy(id ="password")
	protected WebElement LoginPassword;
	
	@FindBy(className = "login__form_action_container")
	protected WebElement SignInButton;
	
	@FindBy(xpath = "//*[@id=\"app__container\"]/main/div/div[3]/p/a")
	protected WebElement JoinNowButton;
	
	@FindBy(id = "error-for-username")
	protected WebElement Errormsg;
	
	@FindBy(id ="first-name")
	protected WebElement FirstName;
	
	@FindBy(id ="last-name")
	protected WebElement LastName;
	
	@FindBy(id = "join-email")
	protected WebElement SignInMail;
	
	@FindBy(id = "join-password")
	protected WebElement SignInPassword;
	
	@FindBy(id = "submit-join-form-text")
	protected WebElement JoinButton;
	
	@FindBy(xpath = "//span[starts-with(@class,'t-16')][contains(@class,'t-black')]")
	protected WebElement profile;
	
	@FindBy(xpath = "//span[starts-with(@class,'t-16')][contains(@class,'t-black')]")
	protected WebElement profilev;

}