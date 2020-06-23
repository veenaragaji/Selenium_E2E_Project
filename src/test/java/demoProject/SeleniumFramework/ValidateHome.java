package demoProject.SeleniumFramework;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import pageObjects.*;


public class ValidateHome extends BaseClass{
	WebDriver driver;
	private static Logger log=LogManager.getLogger(ValidateHome.class.getName());
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = getDriverConfig();
		driver.get(prop.getProperty("Url"));
		log.info("Browser URL launched");
		
	}
	
	@Test(priority=0)
	public void home() throws IOException, InterruptedException{
		ExtentTest test=Listeners.test;
		
		driver.get(prop.getProperty("Url"));
		HomePage hp=new HomePage(driver);
		Assert.assertEquals(hp.getTitle().getText(), "Featured Courses");
		test.log(Status.PASS, "Step1-Title matches-"+test.addScreenCaptureFromPath(getScreenShot("home", driver)));
		Assert.assertTrue(hp.getNBar().isDisplayed());
		test.log(Status.PASS, "Step2-Navigation bar displayed-"+test.addScreenCaptureFromPath(getScreenShot("home", driver)));
		log.info("Home Page validated successfully");
		
		
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
		log.info("Home Page test method driver is closed");
		
	}
	/*@AfterTest
	public void afterTest1() throws IOException {
		System.out.println("After Test - Home page");
	}
	@AfterClass
	public void afterclass1() throws IOException {
		System.out.println("After Class - Home page");
	}*/
}
