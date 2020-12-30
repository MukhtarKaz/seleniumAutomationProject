package SeleniumFramework.FinalProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {

    @Test
    public void basePageToNavigate() throws IOException {

	driver = initDriver();
	driver.get(urlName);

	LandingPage landingPage = new LandingPage(driver);

	// System.out.println(landingPage.getFeaturedTextElement().getText());

	Assert.assertEquals(landingPage.getFeaturedTextElement().getText(), "FEATURED COURSES");

    }

}
