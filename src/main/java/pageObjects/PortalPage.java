package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalPage {

    private WebDriver driver;

    public PortalPage(WebDriver driver) {
	this.driver = driver;
    }

    private By searchBox = By.name("query");

    public WebElement getSearchBox() {
	return driver.findElement(searchBox);
    }

}
