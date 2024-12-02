package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailTxt;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwdTxt;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	public void emailadd(String ename ) {
		  emailTxt.sendKeys(ename);
		
	}
	
	public void passwd(String pwdname ) {
		  pwdTxt.sendKeys(pwdname);
		
	}
	
	public void Loginbt() {
		  btnLogin.click();
		
	}
	
	
	

}
