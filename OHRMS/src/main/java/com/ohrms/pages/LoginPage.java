package com.ohrms.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrms.baseclass.Baseclass;

//import Academy.HomePage;

public class LoginPage extends Baseclass {


	public LoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	//object repository or page factory
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='btnLogin'][@value='LOGIN']")
	WebElement LoginButton;
		
	public HomePage login(String un,String pwd) throws Exception{
		username.sendKeys(un);
		password.sendKeys(pwd);
	    LoginButton.click();
		return new HomePage();// navigating to home page once login was success or landing page
	    	   
	}
}
