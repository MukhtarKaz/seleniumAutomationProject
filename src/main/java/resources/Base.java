package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

    public WebDriver driver;
    public String urlName;
    Properties prop;

    public WebDriver initDriver() throws IOException {
	prop = new Properties();
	FileInputStream fis = new FileInputStream(
		"C:\\MyProjects\\selenium_course\\FinalProject\\src\\main\\java\\resources\\data.properties");

	prop.load(fis);

	// THIS PROP COMES FROM data.properties
	// String browserName = prop.getProperty("browser");
	urlName = prop.getProperty("url");

	// TO USE PARAMETER browser from Jenkins
	// we use system properties. Because mvn -Dbrowser=chrome can be accessed by
	// system.getProperty
	String browserName = System.getProperty("browser");

	// if (browserName == "chrome") IT WILL THROW ERROR NULL POINTER EXCEPTION,
	// USE EQUALS

	if (browserName.equals("chrome")) {
	    System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\chromedriver.exe");
	    driver = new ChromeDriver();
	} else if (browserName.equals("firefox")) {
	    System.setProperty("webdriver.gecko.driver", "C:\\MyProjects\\geckodriver.exe");
	    driver = new FirefoxDriver();
	} else if (browserName.equals("IE")) {
	    System.setProperty("webdriver.ie.driver", "C:\\MyProjects\\IEDriverServer.exe");
	    driver = new InternetExplorerDriver();
	}

	// make global implicit wait for loading projects
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	return driver;

    }

    public String getScreenShot(String failedMethodName, WebDriver driver) throws IOException {

	TakesScreenshot ts = (TakesScreenshot) driver;

	File img = ts.getScreenshotAs(OutputType.FILE);

	String destinationFile = System.getProperty("user.dir") + "\\reports\\" + failedMethodName + ".png";
	FileUtils.copyFile(img, new File(destinationFile));

	return destinationFile;

    }

}
