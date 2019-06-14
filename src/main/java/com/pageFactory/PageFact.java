package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.webp.*;
public class PageFact {
	
	

	@FindBy(name="uid")
    public WebElement user99GuruName;

    @FindBy(name="password")
    public WebElement password99Guru;    

    @FindBy(className="barone")
    public WebElement titleText;

    @FindBy(name="btnLogin")
    public WebElement login;

	protected int i;
}
