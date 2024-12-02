package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistraion extends BaseClass {
	
	public AccountRegistraion(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtMail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtPhonNum;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPaswd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtCnfPaswd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement msgConf;
	
	
	
  public void FirstName(String FirName ) {
	  txtFirstName.sendKeys(FirName);
	
}
  
  public void LastName(String LastName ) {
	  txtLastName.sendKeys(LastName);
	
}
  
  public void Gmail(String mailId ) {
	  txtMail.sendKeys(mailId);
	
}
  
  public void PhNumber(String phn ) {
	  txtPhonNum.sendKeys(phn);
	
}
  
  public void Password(String pwd ) {
	  txtPaswd.sendKeys(pwd);
	
}
  
  public void ConPassword(String cnfpwd ) {
	  txtCnfPaswd.sendKeys(cnfpwd);
	
}
  
  public void PrivacyAgr() {
	  chkAgree.click();
	
}
  
  public void Continue() {
	  btnContinue.click();
	
}
  
  public  String Confmsg() {
	  try {
	  return(msgConf.getText());
	  }catch (Exception e)
	  {
		  return(e.getMessage());
	  }
	  
	
}
}
