package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
	this.driver = driver;
    }

    private By signIn = By.xpath("//span[contains(text(),'Login')]");

    public WebElement getLogin() {
	return driver.findElement(signIn);
    }

    private By featuredText = By.cssSelector("div[class='text-center'] h2");

    public WebElement getFeaturedTextElement() {
	return driver.findElement(featuredText);
    }

    private By navBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");

    public WebElement getNavBarElement() {
	return driver.findElement(navBar);
    }

}
