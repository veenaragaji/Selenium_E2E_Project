package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class='theme-btn register-btn']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='pull-left']/h2")
	WebElement title;
	
	@FindBy(css="nav[class='main-menu']")
	WebElement nav;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement register;
	
	public WebElement getLogin(){
		return login;
		
	}
	public WebElement getRegister(){
		return register;
		
	}
	
	public WebElement getTitle(){
		return title;
		
	}
	public WebElement getNBar(){
		return nav;
		
	}
}
