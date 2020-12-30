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

public class ValudateNavBar extends Base {
    // To launch tests parallel , localizing driver
    WebDriver driver;
    // Logger initializing
    private static Logger log = LogManager.getLogger(ValudateNavBar.class.getName());

    @BeforeTest
    public void initializer() throws IOException {
	driver = initDriver();
	driver.get(urlName);
    }

    @Test
    public void basePageToNavigate() throws IOException {

	LandingPage landingPage = new LandingPage(driver);

	System.out.println(landingPage.getNavBarElement().getText());

	log.info(landingPage.getNavBarElement().getText());

	Assert.assertTrue(landingPage.getNavBarElement().isDisplayed());

    }

    @AfterTest
    public void teardown() {
	driver.quit();
    }

}
