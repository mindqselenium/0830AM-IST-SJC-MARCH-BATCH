package com.ohrms.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import com.ohrms.util.Testutil;

public class Baseclass {
	
	public static WebDriver driver;
	public  static Properties prop;
	
	// this is baseclass constructor to declare fileinputstream class
	
	public Baseclass() throws IOException{
		
		prop=new Properties(); // to create propery file statements
	FileInputStream fip=new FileInputStream
			("F:\\830AM ONLINE\\OHRMS\\src\\main\\java\\com\\ohrms\\config\\config.properties");
	prop.load(fip); // to load config.properties file properly.
	
	}


public static void initialization(){
	String browsername=prop.getProperty("browser");
	
	if(browsername.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","F:\\830AM ONLINE\\OHRMS\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	else if(browsername.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", "F:\\830AM ONLINE\\OHRMS\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	else if(browsername.equals("edge")){
		System.getProperty("webdriver.edge.driver", "F:\\830AM ONLINE\\OHRMS\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait
	           (Testutil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
		
}

//screenshot handling
	public static void takescreenshot(String str) throws Exception{
		
		// date and time format specification
		DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss"); 
		Date d=new Date();// it will collect the current system date and time
		String time=df.format(d); // system date and time framed in format specified.
		System.out.println(time); // to print date and time in console
		
		/* DateFormat is a class, contains different date formats, to get the 
		date and time formats we need to initialize it with type of format*/
		
		/*Date is class, contains system date, we need to initialize this class also*/
		
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // to capture screenshot	
		//copy the screenshot from variable f to custom location.
		//FileUtils.copyFile(f, new File("E:\\SELENIUM WORKSPACE 2017\\SELENIUM 11 to 1PM\\OHRMS\\screenshots\\"+str+time+".png"));
		FileHandler.copy(f, new File("F:\\830AM ONLINE\\OHRMS\\screenshots\\"+str+time+".png"));
	}
	
	
}

