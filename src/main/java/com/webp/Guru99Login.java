package com.webp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pageFactory.*;




public class Guru99Login extends PageFact{
	
	

    protected WebDriver driver; 
    
    SelectBrowser obj = new SelectBrowser();
	public void selectBrowser(String browser) {
	  this.driver = obj.SelectBrowser(browser);;
	}
	
	public void sele(WebDriver driver){

        

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    //Set user name in textbox

    public void setUserName(String strUserName){
    	
        user99GuruName.sendKeys(strUserName);     
    }

    //Set password in password textbox

    public void setPassword(String strPassword){

    password99Guru.sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

            login.click();

    }  

    //Get the title of Login Page

    public String getLoginTitle(){

     return    titleText.getText();

    }

    

    public void loginToGuru99(String strUserName,String strPasword){
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();           

    }
    
    
    
    


}
