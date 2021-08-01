package com.guru.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.guru.utilities.BrowserFactory;

public class BaseClass {

	WebDriver driver;
	
	@BeforeClass
	public void StartApplication() {
		driver	= BrowserFactory.start(driver, "chrome", "http://demo.guru99.com/V4/");
		
	}
	
	@AfterClass
	public void TearDown() {
			 BrowserFactory.close(driver);
	}
	
	public void sleep(int seconds) {
		try {
		Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}
}
