package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
	this.driver = driver;
    }

    By usernameInput = By.cssSelector("#user_email");
    By passwordInput = By.cssSelector("#user_password");
    By logInButton = By.cssSelector("input[value='Log In']");

    public WebElement getUsernameInput() {
	return driver.findElement(usernameInput);
    }

    public WebElement getPasswordInput() {
	return driver.findElement(passwordInput);
    }

    public WebElement getLogInButton() {
	return driver.findElement(logInButton);
    }

}
