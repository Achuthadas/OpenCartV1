package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClasses;

public class ExtendReportManager implements ITestListener {
	public ExtentSparkReporter sparkreporter;   //UI
	public ExtentReports report;                //Info of report common
	public ExtentTest test;                     //Updation after execution
	String repName;
	
	
	
	public void onStart(ITestContext context) {
	/*	SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);  */
		            //  OR
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-" + timestamp+".html";
		
		sparkreporter=new ExtentSparkReporter(".\\reports\\"+repName);  
		sparkreporter.config().setDocumentTitle("Opencart Automation Report");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);   //desigh daek or stndrd basc
		 
		report = new ExtentReports();
		 report.attachReporter(sparkreporter);
		 
		 report.setSystemInfo("Application", "Opencart");
		 report.setSystemInfo("Environment", "Preproduction");
		 report.setSystemInfo("Tester Name", "Das");
		 report.setSystemInfo("Sub Module", "Customers");
		 report.setSystemInfo("Browser", "Google Chrome");
		 
		 String os=context.getCurrentXmlTest().getParameter("os");
		 report.setSystemInfo("Operating System", os);
		 
		 String browser=context.getCurrentXmlTest().getParameter("browser");
		 report.setSystemInfo("Browser", browser);
		 
		 List<String> includeGroups=context.getCurrentXmlTest().getIncludedGroups();
		 if(!includeGroups.isEmpty()) {
			 report.setSystemInfo("Groups", includeGroups.toString());
		 }
		
		  }
		
		public void onTestStart(ITestResult result) {
			System.out.println("test started.......");
		   
		  }
		
		public void onTestSkipped(ITestResult result) {
			test=report.createTest(result.getName());
			test.log(Status.SKIP, "Test Case Skipped : "+result.getName());
			  
			  }

		
		public void onTestSuccess(ITestResult result) {
			test=report.createTest(result.getClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, "Test Case Passed : "+result.getName());
			
		    
		  }
		
		public void onTestFailure(ITestResult result) {
			test=report.createTest(result.getClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL, "Test Case Failed : "+result.getName());
		    
			test.log(Status.FAIL, "Test Case Failed Reason : "+result.getThrowable());
			
				
				try {
					String imgpath = new BaseClasses().captureScreen(result.getName());
					test.addScreenCaptureFromPath(imgpath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				
			
		  }
		
		public void onFinish(ITestContext context) {
			report.flush();
		  }

		
	

}