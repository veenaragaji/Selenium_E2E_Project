package demoProject.SeleniumFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.HomePage;
import pageObjects.Register;

public class ValidateRegister extends BaseClass{
	WebDriver driver;
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = getDriverConfig();
		driver.get(prop.getProperty("Url"));
		
	}
	@Test(dataProvider="getData")
	public void register(String name,String email,String pass,String cpass) throws InterruptedException, IOException{
		ExtentTest test=Listeners.test;
		
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		test.log(Status.PASS, "Register link found-"+test.addScreenCaptureFromPath(getScreenShot("register", driver)));
		
		hp.getRegister().click();
		test.log(Status.PASS, "Step1-Register link clicked-"+test.addScreenCaptureFromPath(getScreenShot("register", driver)));
		
		Register reg=new Register(driver);
		reg.getName().sendKeys(name);
		reg.getEmail().sendKeys(email);
		reg.getPass().sendKeys(pass);
		reg.getCPass().sendKeys(cpass);
		test.log(Status.PASS, "Step2-All fields are filled-"+test.addScreenCaptureFromPath(getScreenShot("register", driver)));
		
		reg.getRegister().click();
		//Assert.assertEquals(reg.getMessage(), "Test");
		test.log(Status.PASS, "Step3-Register success-"+test.addScreenCaptureFromPath(getScreenShot("register", driver)));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object obj[][]=new Object[1][4];
		obj[0][0]="VeenaRagaji";
		obj[0][1]="veenaragaji@gmail.com";
		obj[0][2]="test123";
		obj[0][3]="test123";
		
		return obj;
		
		
		
		
		
	}
}
