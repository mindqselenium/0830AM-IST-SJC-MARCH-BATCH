package testcasescripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;


import org.apache.logging.log4j.core.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;
//import org.w3c.dom.DOMConfiguration;

import com.ohrms.pages.HomePage;
import com.ohrms.pages.LoginPage;
import com.ohrms.baseclass.Baseclass;
import com.ohrms.util.Testutil;

public class LoginPageListenersExtentReportTest extends com.ohrms.baseclass.Baseclass {

	com.ohrms.pages.HomePage hp;
	com.ohrms.pages.LoginPage lp;

	
	public LoginPageListenersExtentReportTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub

	}

	@BeforeTest
	public void setup() throws Exception {

		initialization();
		lp = new com.ohrms.pages.LoginPage(); // login page initialization

	}

	@Test
	public void LoginTest() throws Exception {

		//takescreenshot("login page");
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//takescreenshot("dashboard page");
		
	}

	@AfterTest
	public void teardown() {
		// driver.quit();
	}
}
