package com.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFile {
	
	@FindBy(className = "icl-TextPromo-linkText")
	protected WebElement SignInButton;
	
	@FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[2]/a")
	protected WebElement login;
	
	@FindBy(id = "resume")
	protected WebElement updateResume;
	
	@FindBy(id = "user_email_field")
	protected WebElement UserName;
	
	@FindBy(id = "user_password_field")
	protected WebElement Password;
	
	@FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/div/div/div/form/div[4]/input")
	protected WebElement loginButton;
	

}
