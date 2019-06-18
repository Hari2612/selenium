package com.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpeechPage {
	@FindBy(xpath = "//span[starts-with(@class,'btn__text')][contains(@class,'listen')]")
	protected WebElement Start;
	
	@FindBy(xpath = "//*[@id=\"speech\"]/div[1]/p")
	protected WebElement ResultText;
	
	
}
