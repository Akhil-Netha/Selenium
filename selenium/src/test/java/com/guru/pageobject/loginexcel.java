package com.guru.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import com.guru.utilities.CommonMethods;

public class loginexcel {

	WebDriver driver;
	@FindBy(name="uid") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement login;
	

	
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
	
	
	
	public void Login() throws Exception {
		login.click();
		
		Thread.sleep(2000);
		
		 WebElement logout =driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
			logout.click();
		logout.click();
		
		Alert alt = driver.switchTo().alert();
		String Actualtxt = alt.getText();
		alt.accept();
		
		String exp = "You Have Succesfully Logged Out!!";
		System.out.println(Actualtxt);
		
		//Assert.
		assertEquals(Actualtxt, exp);
		
		
	}
	
	/*	public void logout() {
		//Assert.
			//	assertTrue(logout.getText().equals("Log out"));
			 WebElement logout =driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
				logout.click();
				
				Alert alt = driver.switchTo().alert();
				String Actualtxt = alt.getText();
				alt.accept();
				
				String exp = "You Have Succesfully Logged Out!!";
				System.out.println(Actualtxt); 
				
				//Assert.
				assertEquals(Actualtxt, exp);
	}*/
	
	
	public void ValidateInvalidCre(String namevalue,String pwdvalue) {
	//	username.clear();
		
		username.sendKeys(namevalue);
		password.sendKeys(pwdvalue);
		login.click();
		driver.switchTo().alert().accept();
		
	}
	public void InvalidUserAndEmptyPassword() {
	
		login.click();
		Alert a=driver.switchTo().alert();
		String Actualerror =  a.getText();
		        a.accept();
		String Expectederror = "User or Password is not valid";
		System.out.println(Actualerror);
		
		//Assert.
		assertEquals(Actualerror, Expectederror);
	}
	
	public void validUserAndEmptyPassword() {
		
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
	public loginexcel(WebDriver idriver) {
		this.driver = idriver;
	}
	
	
	
	
}
