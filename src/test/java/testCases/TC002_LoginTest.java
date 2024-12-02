package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAcntPage;
import testBase.BaseClasses;

public class TC002_LoginTest extends BaseClasses{
	@Test(groups={"Sanity","Master"})
	public void verify_Login() throws InterruptedException {
		
		logger.info("-----Started TC002 Execution---");
		//home page
		try {
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		System.out.println("started");
		
		//Login page
		
		LoginPage lp=new LoginPage(driver);
		lp.emailadd(p.getProperty("email"));
		
		lp.passwd(p.getProperty("password"));
		lp.Loginbt();
		System.out.println("login done");
		
		//validation account page
		
	    MyAcntPage ac=new MyAcntPage(driver);
	   
	    boolean target= ac.isMyAccout();
	    System.out.println(target);
	    Assert.assertTrue(target);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		
		
		logger.info("----TC002----completed");
		
		
	}

}
