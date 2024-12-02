package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClasses {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups={"Sanity","Master","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws Exception {
		
		//loading config.prop file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) 
		{
		DesiredCapabilities cap=new DesiredCapabilities();
		//os
		if(os.equalsIgnoreCase("windows")) {
			cap.setPlatform(Platform.WINDOWS);
		}
		else if(os.equalsIgnoreCase("mac")) {
			cap.setPlatform(Platform.MAC);
		}
		else {
			System.out.println("no matching found");
			return;
		}
		//browser
		switch(br.toLowerCase()) {
		case "chrome" : cap.setBrowserName("chrome");break;
		case "edge"  : cap.setBrowserName("MicrosoftEdge");break;
		default:System.out.println("No matching browser found");return;
		}
		driver =new RemoteWebDriver(new URL("http://172.16.32.53:4444/wd/hub"),cap);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch(br.toLowerCase())
		{
		case "chrome" :driver=new ChromeDriver();break;
		case "edge" :driver=new EdgeDriver();break;
		case "firefox" :driver=new FirefoxDriver();break;
		default : System.out.println("invalid browser");return;
		}}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL"));  //reading url from propertyfile
		
		driver.manage().window().maximize();
	}
		
	
	@AfterClass(groups={"Sanity","Master","Regression"})
	public void teardown() {
		driver.quit();
		
	}
	
	public String randomString() {
		 String randomstring=RandomStringUtils.randomAlphabetic(6);
		 return randomstring;
		}
		
		public String randomNumber() {
			 String randomnum=RandomStringUtils.randomNumeric(10);
			 return randomnum;
			}
		
		public String randomAlphaNumer() {
			 String randomstring=RandomStringUtils.randomAlphabetic(4);
			 String randomnum=RandomStringUtils.randomNumeric(4);
			 return randomstring+"@"+randomnum;
			}
		
		public String captureScreen(String tname)throws IOException {
			String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File sofile=ts.getScreenshotAs(OutputType.FILE);
			
			String tarfile=System.getProperty("user.dir")+"\\screenshot"+tname+"_"+timeStamp;
			File tf=new File(tarfile);
			sofile.renameTo(tf);
			
			return tarfile;
		}

}
