package com.webpp;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.webp.*;

public class TestUploadFile extends UploadFilePage {
	@BeforeTest
    public void startBrowser() throws Exception {
		System.out.println("1");
		selectBrowser("firefox");
		sele(driver);
		String baseUrl = "http://demo.guru99.com/test/upload/";
		driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
 
        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\gkokz\\OneDrive - Monsanto\\Migrated from My PC\\My Videos\\resume.doc");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
	}
}