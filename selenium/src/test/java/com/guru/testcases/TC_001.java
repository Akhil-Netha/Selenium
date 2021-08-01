package com.guru.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru.pageobject.LoginPage;

public class TC_001 extends BaseClass{

	
	LoginPage login = new LoginPage(driver);
//	LoginPage login;
	
	@BeforeClass
	public void con() {
		login = PageFactory.initElements(driver,LoginPage.class);
	}
	@Test
	public void verifylabelandfields() {
		login.verifyloginlabel();
	}
	
	@Test
	public void BothUserNameAndPasswordIsEmpty() {
		login.BothUserNameAndPasswordIsEmpty();
	}
	@Test
	public void InvalidCredentials() {
		
		login.LoginWithInValidCredentials("akhil", "akhil");
	}
	@Test
	public void InValidUsernameAndEmptyPassword() {
		login.InvalidUserAndEmptyPassword("akhil");
	}
	@Test
	public void ValidUserNameAndEmptyPassword() {
		login.validUserAndEmptyPassword("mngr318593");
	}
	
	@Test
	public void ValidCredentials() {
		login.LoginWithValidCredentials("mngr318593", "senehys");
	}
	
	
	
}
