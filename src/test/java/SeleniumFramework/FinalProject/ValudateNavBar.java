package SeleniumFramework.FinalProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValudateNavBar extends Base {

    @Test
    public void basePageToNavigate() throws IOException {

	driver = initDriver();
	driver.get(urlName);

	LandingPage landingPage = new LandingPage(driver);

	System.out.println(landingPage.getNavBarElement().getText());

	Assert.assertTrue(landingPage.getNavBarElement().isDisplayed());

    }

}
