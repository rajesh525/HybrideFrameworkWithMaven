package com.MavenHybrideFramework.testCases;


import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MavenHybrideFramework.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException 
	{
			
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		try {
			if(driver.switchTo().alert().getText().equalsIgnoreCase("User or Password is not valid")) {
				Assert.assertTrue(true);
			}
		}	catch(NoAlertPresentException e) {
			Assert.assertTrue(false);
			logger.info(e.getMessage());
		}
	}
}
