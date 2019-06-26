package com.AppiumMain;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static java.time.Duration.ofMillis;

import java.util.List;

public class MyBagPage extends Capabilities{
	
	String OldPrice,ItemPrice;
protected AppiumDriver<MobileElement> driver;
	
	public void InitializeDriver() throws Exception {
		InitializeCapabilities();
		this.driver = new AndroidDriver<MobileElement>( caps);

	}
	
	

	public void ClickBag() throws Exception {
		driver.findElement(By.id("com.ril.ajio:id/icon_cart_tab")).click();
		Thread.sleep(4000);

	}
	
	public boolean IsBagEmpty() {
		try {
			 if(driver.findElement(By.xpath("//android.widget.TextView[@text = 'Your bag is empty']")).isDisplayed())
				 return true;
		}catch(Exception e) {
			return 	false;		
		}
		return false;
	}
	
	public void Back() {
		driver.findElement(By.xpath("//*[@content-desc = 'Navigate up']")).click();

	}
	
	public String BagCount() {
		return driver.findElement(By.id("com.ril.ajio:id/count_cart_tab")).getText();
	}
	
	public String ItemCount() {
		return driver.findElement(By.id("com.ril.ajio:id/toolbar_title")).getText();
	}
	
	
	
	public void verticalSwipeByPercentages() {
		double startPercentage = 0.8;
		double endPercentage=0;
		double anchorPercentage= 0.5;
        Dimension size = driver.manage().window().getSize();
        System.out.println("hohoho   " + size.width +"  " + size.height );
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction(driver)
                .press(PointOption.point(anchor,startPoint))
                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(anchor,endPoint))
                .release().perform();
    }
	
		public boolean IsItemFound() {
		try {
			List<MobileElement> elements = driver.findElements(By.id("com.ril.ajio:id/item_name"));
			for(MobileElement element : elements) {
				if(element.getAttribute("text").equals("Slip-On Mesh Sneakers ")) {
					verticalSwipeByPercentages();
					Thread.sleep(4000);
					List<MobileElement> elements1 = driver.findElements(By.id("com.ril.ajio:id/parent_layout"));
					System.out.println("size " +elements1.size());
					for(MobileElement element2 : elements1) {
						
						String s = element2.findElement(By.id("com.ril.ajio:id/item_name")).getAttribute("text");
						System.out.println("text is: " + s);
						if(s.equals("Slip-On Mesh Sneakers ")) {
							OldPrice =  element2.findElement(By.id("com.ril.ajio:id/item_old_price")).getAttribute("text");
							ItemPrice =  element2.findElement(By.id("com.ril.ajio:id/item_price")).getAttribute("text");
							element.click();
							return true;
						}
						
					}	
				}
			}
				 
		}catch(Exception e) {
			return 	false;		
		}
		return false;
	}
	
		
		
		public boolean VerifyItemDetails() {
			return driver.findElement(By.id("com.ril.ajio:id/row_pdp_title_price_tv_info")).getAttribute("text").equals("Slip-On Mesh Sneakers ") &&
					driver.findElement(By.id("com.ril.ajio:id/row_pdp_title_price_tv_old_price")).getAttribute("text").equals(OldPrice) &&
					driver.findElement(By.id("com.ril.ajio:id/row_pdp_title_price_tv_price")).getAttribute("text").equals(ItemPrice);
		}
		
		
		public boolean AddToCart() {
			driver.findElement(By.id("com.ril.ajio:id/add_to_cart_layout")).click();
			List<MobileElement> elements = driver.findElements(By.id("com.ril.ajio:id/row_pdp_fixed_size_tv"));
			for(MobileElement element : elements) {
				if(element.getAttribute("text").equals("9")) {
					if(element.getAttribute("clickable").equals("true")) {
						element.click();
						driver.findElement(By.id("com.ril.ajio:id/add_to_cart_layout")).click();
						return true;
					}
					else {
						return false;
					}
					
				}
			}
			return false;
		}
		
		
		public void ViewBag() {
			driver.findElement(By.id("com.ril.ajio:id/add_to_cart_layout")).click();
		}
		
		public boolean VerifyItemDetailsInBag() {
			List<MobileElement> elements1 = driver.findElements(By.id("com.ril.ajio:id/row_cart_product"));
			System.out.println("size " +elements1.size());
			for(MobileElement element2 : elements1) {
				if(element2.findElement(By.id("com.ril.ajio:id/row_cart_product_tv_name")).getAttribute("text").equals("AJIO-Slip-On Mesh Sneakers ")) {
					return element2.findElement(By.id("com.ril.ajio:id/row_cart_product_tv_discount_price")).getAttribute("text").equals(OldPrice) &&
							element2.findElement(By.id("com.ril.ajio:id/row_cart_product_tv_actual_price")).getAttribute("text").equals(ItemPrice) &&
							element2.findElement(By.id("com.ril.ajio:id/row_cart_product_tv_size")).getAttribute("text").equals("9");

			}
				else {
					return false;
				}
			
		 }
			return false;
		}
		
		public void ProceedToShipping() {
			driver.findElement(By.id("com.ril.ajio:id/fragment_cart_list_tv_proceed")).click();
		}
		
		public void ProceedToPayment() {
			driver.findElement(By.id("com.ril.ajio:id/fragment_address_list_tv_proceed")).click();
		}
		
}
