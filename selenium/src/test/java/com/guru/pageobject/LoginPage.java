package com.guru.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import com.guru.utilities.CommonMethods;

public class LoginPage {

	WebDriver driver;
	@FindBy(xpath="//input[@name='uid']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement login;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]") WebElement logout;
	
	//For UserName and Password Label
	@FindBy(xpath="//td[contains(text(),'UserID')]") WebElement usernamelabel;
	@FindBy(xpath="//td[contains(text(),'Password')]") WebElement passwordlabel;
	
	public void verifyloginlabel() {
		CommonMethods.CheckDisplayAndEnable(username,password);
		CommonMethods.CheckDisplay(usernamelabel,passwordlabel);
		
		//Assert.
		assertTrue(login.getAttribute("type").equals("submit"));
		
		
		//Assert.
		assertTrue(username.getAttribute("type").equals("text"));
		//Assert.
		assertTrue(password.getAttribute("type").equals("password"));
		//Assert.
		assertTrue(usernamelabel.getText().equals("UserID"));
		//Assert.
		assertTrue(passwordlabel.getText().equals("Password"));
	}
	
	public void LoginWithInValidCredentials(String name,String pass) {
		username.sendKeys(name);
		password.sendKeys(pass);
		login.click();
		
		Alert alt = driver.switchTo().alert();
		String txt = alt.getText();
		alt.accept();
		
		String exp = "User or Password is not valid";
		System.out.println(txt);
		
		//Assert.
		assertEquals(txt, exp);
		
		String windowID = driver.getWindowHandle();
		System.out.println(windowID);
	}
	
	public void LoginWithValidCredentials(String name,String pass) {
		username.sendKeys(name);
		password.sendKeys(pass);
		login.click();
		
		//Assert.
		assertTrue(logout.getText().equals("Log out"));
		
		logout.click();
		
		Alert alt = driver.switchTo().alert();
		String Actualtxt = alt.getText();
		alt.accept();
		
		String exp = "You Have Succesfully Logged Out!!";
		System.out.println(Actualtxt);
		
		//Assert.
		assertEquals(Actualtxt, exp);
	}
	
	public void InvalidUserAndEmptyPassword(String name) {
		username.sendKeys(name);
		login.click();
		
		Alert a=driver.switchTo().alert();
		String Actualerror =  a.getText();
		        a.accept();
	
		String Expectederror = "User or Password is not valid";
		System.out.println(Actualerror);
		
		//Assert.
		assertEquals(Actualerror, Expectederror);
	}
	
	
	public void validUserAndEmptyPassword(String name) {
		username.sendKeys(name);
		login.click();
		
		Alert a=driver.switchTo().alert();
		String Actualerror =  a.getText();
		        a.accept();
	
		String Expectederror = "User or Password is not valid";
		System.out.println(Actualerror);
		//Assert.
		assertEquals(Actualerror, Expectederror);
	}
	
	public void BothUserNameAndPasswordIsEmpty() {
		
		login.click();
		
		Alert a=driver.switchTo().alert();
		String Actualerror =  a.getText();
		        a.accept();
	
		String Expectederror = "User or Password is not valid";
		System.out.println(Actualerror);
		//Assert.
		assertEquals(Actualerror, Expectederror);
	}
	
	public LoginPage(WebDriver idriver) {
		this.driver = idriver;
	}
	
	
	
	
}
