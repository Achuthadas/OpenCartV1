package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcntPage extends BaseClass {
	
	
public MyAcntPage(WebDriver driver) {
		super(driver);
	
	}
  @FindBy(xpath="//*[@id=\"content\"]/h2[1]")
  WebElement MyAccounttxt;
  
  @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
  WebElement btnLogout;
  
  
  public boolean isMyAccout() {
	  try {
	return(MyAccounttxt.isDisplayed()); 
	}
	  catch(Exception e) 
	  {
		  return false;
	  }
	  
	  
  }
  
  public void btnlogout() {
	  btnLogout.click();
  }
	

}