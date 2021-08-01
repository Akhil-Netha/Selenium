package com.guru.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.guru.pageobject.LoginPage;
import com.guru.pageobject.loginexcel;
import com.guru.utilities.ExcelUtils;



public class TC_002_Excel extends BaseClass{
	
	loginexcel log = new loginexcel(driver);
	

	@BeforeClass
	public void con() {
		log = PageFactory.initElements(driver,loginexcel.class);
	}
	
	@DataProvider(name = "test")
	public static Object[][] data() throws IOException {
	return ExcelUtils.getTableArray("C://test//guru.xlsx", "guru");
	
	
	}

	@Test(dataProvider = "test")
	public void testData(String namevalue, String pwdvalue, String status) throws Exception {
		
		
		
		
		namevalue = namevalue==null? "": namevalue;
		pwdvalue = pwdvalue==null? "": pwdvalue;
			
			log.ValidateInvalidCre(namevalue, pwdvalue);
		     if(status.equals("invalid")) {
		}else if(status.equals("invalid")) {
			log.InvalidUserAndEmptyPassword();
			sleep(2);
		}else if(status.equals("invalid")) {
			log.validUserAndEmptyPassword();
		}else if(status.equals("empty")) {
			log.BothUserNameAndPasswordIsEmpty();
		}else if(status.equals("Valid")) {
			log.Login();
			
}
		
		System.out.println(namevalue +" -"+pwdvalue +"- "+ status );
		}
			
		
			
			
		
		
	/*	loginPageObj.login(name,pass);
		if(assertType.equals("A")) {
		loginPageObj.logout();
		}else if (assertType.equals("B")) {
		loginPageObj.validateLoginNameAlert();
		} else if (assertType.equals("C")) {
		loginPageObj.validatePasswordAlert();
		} else if (assertType.equals("D")) {
		loginPageObj.validateLoginFailure();
		} else if (assertType.equals("E")) {
		loginPageObj.validatePasswordLength();
		}
		}*/

	/*	@Test
	public void login() {
		log.Login("mngr318593", "senehys");
		log.logout();
	}
	@Test
	public void test2() {
		log.ValidateInvalidCre("akhil", "akhil");
	}
	@Test
	public void test3() {
		log.InvalidUserAndEmptyPassword("akhil");
	}
	@Test
	public void test4() {
		log.validUserAndEmptyPassword("mngr318593");
	}
	@Test
	public void test5() {
		log.BothUserNameAndPasswordIsEmpty();
	}*/
}
