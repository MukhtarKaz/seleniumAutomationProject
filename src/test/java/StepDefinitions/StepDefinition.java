package StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalPage;
import resources.Base;

// This page is Cucumber implementation of HomePage class
public class StepDefinition extends Base {

    @Given("^Initialize browser with chrome$")
    public void initialize_browser_with_chrome() throws Throwable {
	driver = initDriver();
    }

    @And("^Navigate to page \"([^\"]*)\"$")
    public void navigate_to_page_something(String urlAddress) throws Throwable {
	driver.get(urlAddress);
    }

    @And("^Click to login button to go sign in page$")
    public void click_to_login_button_to_go_sign_in_page() throws Throwable {
	LandingPage landingPage = new LandingPage(driver);
	landingPage.getLogin().click();
    }

//    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" then \"([^\"]*)\" to log in$")
//    public void user_enters_something_and_something_then_something_to_log_in(String username, String password,
//	    String userInfo) throws Throwable {
//	LoginPage loginPage = new LoginPage(driver);
//	loginPage.getUsernameInput().sendKeys(username);
//	loginPage.getPasswordInput().sendKeys(password);
//	loginPage.getLogInButton().click();
//
//    }

    @When("^User enters (.+) and (.+) then (.+) to log in$")
    public void user_enters_and_then_to_log_in(String username, String password, String userinfo) throws Throwable {

	LoginPage loginPage = new LoginPage(driver);
	loginPage.getUsernameInput().sendKeys(username);
	loginPage.getPasswordInput().sendKeys(password);
	loginPage.getLogInButton().click();

    }

    @Then("^Verify that user is succesfully logged in$")
    public void verify_that_user_is_succesfully_logged_in() throws Throwable {

	PortalPage portalPage = new PortalPage(driver);
	Assert.assertTrue(portalPage.getSearchBox().isDisplayed());
    }

    @Then("^close browsers$")
    public void close_browsers() throws Throwable {
	driver.quit();
    }

}
