package com.webp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelectBrowser {
	
	public WebDriver SelectBrowser(String d){
		WebDriver driver = null;
	switch (d) { 
    case "firefox": 
    	String driverPath = "C:\\Farmrise\\webp\\src\\geckodriver.exe";
    	System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
         driver =new FirefoxDriver(capabilities);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.manage().window().maximize();
        
        break; 
    case "IE": 
    	System.setProperty("webdriver.ie.driver","C:\\Farmrise\\webp\\src\\IEDriverServer.exe");
    	DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    	 driver = new InternetExplorerDriver(); 
    	 driver.manage().window().maximize();
        break; 
	}
	return driver;
	}
}
