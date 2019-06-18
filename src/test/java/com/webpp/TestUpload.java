package com.webpp;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import com.webp.*;

import utils.ExcelDetails;
import utils.Reading_From_TextFile;

public class TestUpload extends UploadFilePage {

	
	@BeforeTest
    public void startBrowser() throws Exception {
		
		
		  String fileName = "C:\\Farmrise\\webp\\src\\test\\java\\com\\webpp\\property.txt"; 
	      FileReader fr = new FileReader(fileName);
	  	  BufferedReader br = new BufferedReader(fr);
		  Reading_From_TextFile obj = new Reading_From_TextFile();
		  ExcelDetails obj1 = new ExcelDetails();
		  String[] str = obj.read(br);
		
		  
		  
		  
		
		 selectBrowser(str[3]);
		sele(driver);
		
		
		driver.get("https://www.google.com");
		WebElement e = driver.findElement(By.id("photo"));
		e.sendKeys(Keys.ENTER);
		e.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.close();
		
		
        
        driver.get(str[0]); 
        
 		clickb();
 		setUsername(str[1]);
 		setPassword(str[2]);
 		clickLogin();
 		System.out.println("1.5");
 		Thread.sleep(2000);
 		driver.navigate().refresh();
 		System.out.println("1.51");
 		clickbv();
 		System.out.println("1.25");
 		StringSelection strSel = new StringSelection("C:\\Users\\gkokz\\OneDrive - Monsanto\\Migrated from My PC\\My Videos\\resume.doc");
 		System.out.println("1.5");
 		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
 		Robot robot = new Robot();
 		robot.keyPress(KeyEvent.VK_CONTROL);
 		robot.keyPress(KeyEvent.VK_V);
 		robot.keyRelease(KeyEvent.VK_CONTROL);
 		
 		Thread.sleep(3000);
 		robot.keyPress(KeyEvent.VK_ENTER);
 		robot.keyRelease(KeyEvent.VK_ENTER); 
 		
 		 
 			
        System.out.println("1");

    }

    
	
}
