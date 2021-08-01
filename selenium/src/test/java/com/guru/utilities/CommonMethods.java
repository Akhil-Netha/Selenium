package com.guru.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonMethods {

	WebDriver driver;
	
	public static void CheckDisplayAndEnable(WebElement...elements) {
		for(WebElement ele:elements) {
			Assert.assertTrue(ele.isDisplayed(),"element should be displayed");
			Assert.assertTrue(ele.isEnabled(),"element should be Enabled");
		}
	}
		public static void CheckDisplay(WebElement...elements) {
			for(WebElement ele:elements) {
				Assert.assertTrue(ele.isDisplayed(),"element should be displayed");
				Assert.assertTrue(ele.isEnabled(),"element should be Enabled");
			}
	
	
	
	}
	
	
	
	
}
