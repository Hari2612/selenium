package com.webp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pageFactory.*;

public class Speech extends SpeechPage{
protected WebDriver driver;
	
	public void selectBrowser(String Browser) {
		SelectBrowser obj = new SelectBrowser();
		this.driver = obj.SelectBrowser(Browser);
		
	}
	
	public void Initialize(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
	
	public void StartSpeech() {
		Start.click();
	}
	
	public void StopSpeech() {
		Start.click();
	}
	
	public String getText() {
		return ResultText.getText();
	}
	

}
