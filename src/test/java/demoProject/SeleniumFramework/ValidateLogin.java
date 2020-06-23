package demoProject.SeleniumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.HomePage;

public class ValidateLogin extends BaseClass {
	WebDriver driver;
	/*@BeforeClass
	public void b4class2() throws IOException {
		System.out.println("Before Class - Login page");
	}
	@BeforeTest
	public void b4test2() throws IOException {
		System.out.println("Before Test - Login page");
	}*/
	@BeforeMethod
	public void initialize() throws IOException {
		driver = getDriverConfig();
		driver.get(prop.getProperty("Url"));
		System.out.println("Test2 Before Method -Login");
	}

	@Test
	public void login() throws IOException, InterruptedException {
		ExtentTest test=Listeners.test;
		HomePage hp = new HomePage(driver);
		// driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
		// Thread.sleep(4000);
		/*
		 * WebDriverWait wait=new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
		 * "/html/body/app-root/div/header/div[1]/div/div/div[2]/div[2]")));
		 * ///html/body/app-root/div/header/div[1]/div/div/div[2]/div[2]
		 */
		WebElement loginB = hp.getLogin();
		test.log(Status.PASS, "Step1-Login button identified-"+test.addScreenCaptureFromPath(getScreenShot("login", driver)));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginB);
		test.log(Status.PASS, "Step2-Login success-"+test.addScreenCaptureFromPath(getScreenShot("login", driver)));
		System.out.println("Test2 method is successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Test2 After Method Login exited");
		
	}
	
	/*@AfterTest
	public void aftertest2() throws IOException {
		
		System.out.println("After Test - Login page");
	}
	@AfterClass
	public void afterclass2() throws IOException {
		System.out.println("After Class - Login page");
	}*/
}
