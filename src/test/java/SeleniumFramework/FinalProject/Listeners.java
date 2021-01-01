package SeleniumFramework.FinalProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    // To run on parallel mode, we create an instance of ThreadLocal and put all
    // tests into it.
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {

	test = extent.createTest(result.getMethod().getMethodName());
	// at the beginning adding all tests into ThreadLocal
	extentTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

//ExtentReporterNG test logs pass results
	extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

	// ExtentReporterNG test logs fail results
	extentTest.get().fail(result.getThrowable());

	WebDriver driver = null;
	// On test failure get screenshot of element
	String failedTestMethod = result.getMethod().getMethodName();

	// Getting an instance of DRIVER from failed method
	try {
	    driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
		    .get(result.getInstance());
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	try {
	    // adding screenshot to the failed page report

	    extentTest.get().addScreenCaptureFromPath(getScreenShot(failedTestMethod, driver), failedTestMethod);

	    // getScreenShot(failedTestMethod, driver);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Override
    public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub

	extent.flush();

    }

}
