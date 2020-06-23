package demoProject.SeleniumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	WebDriver driver ;
	Properties prop;
	public WebDriver getDriverConfig() throws IOException{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hp au-620tx\\Desktop\\Tekstac\\SeleniumFramework\\src\\main\\java\\resources\\config.properties");
		prop=new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("Browser");
		
		if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\hp au-620tx\\Desktop\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\hp au-620tx\\Desktop\\Selenium\\SW\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		
		
		return driver;
	}
	public ExtentReports getExtentReport(){
		String path = System.getProperty("user.dir") + "//ExtentReports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Basic Extent Report");
		reporter.config().setReportName("Demo Report");
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("tester", "veena");
		return report;
	}
	public String getScreenShot(String methodName,WebDriver driver) throws IOException{
		TakesScreenshot t=(TakesScreenshot)driver;
		File source=t.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"//Screenshots/"+methodName+"/"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(source, new File(path));
		return path;
		
	}
}
