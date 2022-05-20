package testcasescripts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ohrms.baseclass.Baseclass;
import com.ohrms.pages.LoginPage;

public class LoginpageDatabaseTest extends Baseclass {

	public LoginpageDatabaseTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginPage lp;
	// WebDriver driver;
	String dbUrl = "jdbc:mysql://localhost:3306/ohrms_testdata"; // database connection statements
	String username = "root"; // username
	String password = "sudheer"; // password
	Connection Conn = null;

	@BeforeTest
	public void browser() throws IOException {

		initialization();
		lp = new com.ohrms.pages.LoginPage(); // login page initialization
	}

	@Test
	public void hrmslogin() throws Exception {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();// mysql driver to connect to db
			Conn = DriverManager.getConnection(dbUrl, username, password);// establishing connection

			Statement st = Conn.createStatement(); // statements to perform actions//connecting to the database
			System.out.println(st);
			ResultSet rs = st.executeQuery("select *from logincredentials"); // statement query

			while (rs.next()) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.name("txtUsername")).sendKeys(rs.getString("username"));
				driver.findElement(By.id("txtPassword")).sendKeys(rs.getString("password"));
				driver.findElement(By.className("button")).click();
				String expectedtitle = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
				// Assert.assertEquals(driver.getCurrentUrl(), expectedtitle);
				if (driver.getCurrentUrl()
						.equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {

					driver.findElement(By.xpath("//a[@id='welcome'][@class='panelTrigger']")).click();
					// driver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.linkText("Logout")).click();

				}
				// else {
				// driver.navigate().back();

				driver.findElement(By.name("txtUsername")).clear();

			}

		}

		catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
		}

		finally {
			Conn.close();// to close the database automatically
		}

	}

}
