package testcasescripts;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		
		htmlReporter=new ExtentSparkReporter("Extentreport.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information or environment information to reports
		
		reports.setSystemInfo("machine","sudheer test system");
		reports.setSystemInfo("os","windows 10");
		reports.setSystemInfo("browsername","chrome");
		reports.setSystemInfo("userdetails","Shyam Sudheer");
		
		//configuration to change look and feel theme
		htmlReporter.config().setDocumentTitle("Extent listener Report");
		htmlReporter.config().setReportName("this is logintest report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		}
   
	public void onTestStart(ITestResult result) {
	    // not implemented
		  
		System.out.println("name of the test method started:"+result.getName());
	  }

	  public void onTestSuccess(ITestResult result) {
	    // not implemented
		  
		  System.out.println("name of the test method success:"+result.getName());
		  test.log(Status.PASS, MarkupHelper.createLabel("name of passed test case is"+result.getName()
		   +"PASSED",ExtentColor.GREEN));
	  }

	 
	  public void onTestFailure(ITestResult result) {
	    // not implemented
		  
		  System.out.println("name of the test method failed:"+result.getName());
		  test=reports.createTest(result.getName());
		  test.log(Status.FAIL, MarkupHelper.createLabel("name of failed test case is"+result.getName()
		  +"FAILED", ExtentColor.RED));
		  
	  }

	 
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
		  
		  System.out.println("name of the test method skipped:"+result.getName());
		  test.log(Status.SKIP, MarkupHelper.createLabel("name of skipped test case is"+result.getName()
		  +"SKIPPED", ExtentColor.YELLOW));
	  }

	 
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	 
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  
	  public void onStart(ITestContext result) {
	    // not implemented
		  configureReport();
		  System.out.println("on start method:"+result.getName());
	  }

	  
	  public void onFinish(ITestContext result) {
	    // not implemented
		 
		  System.out.println("on Finish method:"+result.getName());
	  }

}
