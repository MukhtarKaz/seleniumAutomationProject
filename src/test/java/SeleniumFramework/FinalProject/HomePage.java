package SeleniumFramework.FinalProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

    // To launch tests parallel , localizing driver
    WebDriver driver;

    private static Logger log = LogManager.getLogger(HomePage.class.getName());

    @BeforeTest
    public void initializer() throws IOException {

	driver = initDriver();

    }

    @Test(dataProvider = "getData")
    public void basePageToNavigate(String username, String password, String userInfo) throws IOException {

	driver.get(urlName);

	LandingPage landingPage = new LandingPage(driver);
	landingPage.getLogin().click();

	LoginPage loginPage = new LoginPage(driver);

	loginPage.getUsernameInput().sendKeys(username);
	log.info("Sent username " + username);
	loginPage.getPasswordInput().sendKeys(password);
	log.info("Sent password " + password);

	// System.out.println(username);
	loginPage.getLogInButton().click();
	log.info("Login page is clicked");

    }

    @AfterTest
    public void teardown() {
	driver.quit();
    }

    @DataProvider
    public String[][] getData() {
	// We are making parameterization for data
	String[][] data = new String[2][3];
	// First row data for the test
	data[0][0] = "nonstrict@test.com";
	data[0][1] = "123456";
	data[0][2] = "NonStrict User";
	// Second row data for the test
	data[1][0] = "strict@test.com";
	data[1][1] = "123456";
	data[1][2] = "Strict User";

	return data;
    }

}
