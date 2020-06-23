package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	WebDriver driver;
	public Register(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user_name")
	WebElement name;
	
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(id="user_password")
	WebElement pass;
	
	@FindBy(id="user_password_confirmation")
	WebElement cpass;
	
	
	@FindBy(name="commit")
	WebElement regi;
	
	public WebElement getName(){
		return name;
		
	}
	public WebElement getEmail(){
		return email;
		
	}
	public WebElement getPass(){
		return pass;
		
	}
	public WebElement getCPass(){
		return cpass;
		
	}

	public WebElement getRegister(){
		return regi;
		
	}
}
