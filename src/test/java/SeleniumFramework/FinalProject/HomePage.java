package SeleniumFramework.FinalProject;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

    @Test(dataProvider = "getData")
    public void basePageToNavigate(String username, String password, String userInfo) throws IOException {

	driver = initDriver();
	driver.get(urlName);

	LandingPage landingPage = new LandingPage(driver);
	landingPage.getLogin().click();

	LoginPage loginPage = new LoginPage(driver);

	loginPage.getUsernameInput().sendKeys(username);
	loginPage.getPasswordInput().sendKeys(password);
	System.out.println(username);
	loginPage.getLogInButton().click();

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
