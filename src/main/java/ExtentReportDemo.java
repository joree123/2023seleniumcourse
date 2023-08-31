import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Constants.FileConstants;

public class ExtentReportDemo {
@Test
public void createReport()
{
	 ExtentReports extent=new ExtentReports();
	 ExtentSparkReporter reporter=new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
     extent.attachReporter(reporter);
     ExtentTest test=extent.createTest("LoginToSalesForce");
     test.log(Status.PASS, "test passed");
     test.info("password entered");
     extent.flush();
     
}
	
	
	
}
