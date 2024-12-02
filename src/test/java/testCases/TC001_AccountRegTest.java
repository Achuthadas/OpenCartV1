package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistraion;
import pageObjects.HomePage;
import testBase.BaseClasses;

public class TC001_AccountRegTest extends BaseClasses {
	
	
	@Test(groups={"Regression","Master"})
	public void validate_Account_Reg() {
		logger.info("***started execution***");
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickAccount();
		logger.info("***clicked on Account***");
		hp.clickRegister();
		logger.info("***clicked on Register***");
		
		AccountRegistraion ag=new AccountRegistraion(driver);
		
		logger.info("***Account info providing***");
		ag.FirstName(randomString().toUpperCase());
		ag.LastName(randomString().toUpperCase());
		ag.Gmail(randomString()+"@gmail.com");
		ag.PhNumber(randomNumber());
		ag.Password("Perun123");
		ag.ConPassword("Perun123");
		ag.PrivacyAgr();
		ag.Continue();
		
		String conf=ag.Confmsg();
		if(conf.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			
			logger.error("**Error occured**");
			logger.debug("debugging logs");
			Assert.assertTrue(false);
			
		}
		System.out.println(conf);
		//Assert.assertEquals(conf, "Your Account Has Been Created!");
		
		}catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("***execution completed***");
		
	}
	

}
