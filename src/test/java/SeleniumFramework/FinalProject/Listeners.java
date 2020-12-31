package SeleniumFramework.FinalProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.Base;

public class Listeners extends Base implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result) {
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
	    getScreenShot(failedTestMethod, driver);
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

    }

}
