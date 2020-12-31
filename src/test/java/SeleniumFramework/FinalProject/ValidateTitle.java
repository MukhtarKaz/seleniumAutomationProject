package SeleniumFramework.FinalProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
    // To launch tests parallel , localizing driver
    WebDriver driver;

    private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());

    @BeforeTest
    public void initializer() throws IOException {
	driver = initDriver();

	log.info("Driver is initialized");
	driver.get(urlName);
	log.info("navigated to test page");

    }

    @Test
    public void validatingTitle() throws IOException {

	LandingPage landingPage = new LandingPage(driver);

	// System.out.println(landingPage.getFeaturedTextElement().getText());

	Assert.assertEquals(landingPage.getFeaturedTextElement().getText(), "FEATURED COURSES123");
	log.info("Succesfully validated Text massage");

    }

    @AfterTest
    public void teardown() {
	driver.quit();
    }

}
