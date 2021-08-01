package com.guru.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	
public static  WebDriver start(WebDriver driver, String browser,String appurl) {
	
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\uday_2\\eclipse-workspace-21\\selenium\\Drivers\\chrome1.exe");
		driver = new ChromeDriver();
		
		driver.get(appurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		
	}else if(browser.equalsIgnoreCase("ie")) {
		
	}else {
		System.out.println("browser is invalid");
	}
	return driver;
	
}
	public static void  close(WebDriver driver) {
		driver.quit();
	
	}
	
	
	
	
	
}
