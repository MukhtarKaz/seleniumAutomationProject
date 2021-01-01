package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    static ExtentReports extent;

    public static ExtentReports getReportObject() {
	// To get Extent Report we need to
	// instantiate 2 classes - ExtentReports, ExtentSparkReporter

	// First create file to save a report
	String path = System.getProperty("user.dir") + "\\reports\\index.html";
	// Second prepare reporter, contains config data for extent report
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Page Test Automation");
	reporter.config().setDocumentTitle("Test results");

	// Third create main class for extent report
	extent = new ExtentReports();
	// attaching reporter
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Mukhtar Otarbayev");

	return extent;

    }

}
