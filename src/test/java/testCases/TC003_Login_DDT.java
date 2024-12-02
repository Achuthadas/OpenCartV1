package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAcntPage;
import testBase.BaseClasses;
import utilities.DataProviders;

public class TC003_Login_DDT extends BaseClasses {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Master")
	public void verify_LoginDTT(String email ,String password,String exp) { 
		
	logger.info("----tc003 execution started---");
	try {
	HomePage hp=new HomePage(driver);
	hp.clickAccount();
	hp.clickLogin();
	System.out.println("started");
	
	//Login page
	
	LoginPage lp=new LoginPage(driver);
	lp.emailadd(email);
	lp.passwd(password);
	lp.Loginbt();
	System.out.println("login done");
	
	//validation account page
	/*valid data -----login success--test pass--logout
	 *          -----login failed--test fail
	 *          invalid data--login fail--test pass
	 *                      ---login pass--test fail..logout
	 */
	
	
    MyAcntPage ac=new MyAcntPage(driver);
   
    boolean target= ac.isMyAccout();
    
    if(exp.equalsIgnoreCase("valid")){
    	if(target==true) {
    		ac.btnlogout();
    		Assert.assertTrue(true);
    	}else {
    		Assert.assertTrue(false);
    	}
    }else {
    	if(target==true) {
    		ac.btnlogout();
    		Assert.assertTrue(false);
    		
    	}else {
    		Assert.assertTrue(true);
    	}
    }
	}catch(Exception e) {
    	Assert.fail();
    }
	logger.info("---tc003 completed----");
    	
    }

}
