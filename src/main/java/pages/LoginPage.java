package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username") private WebElement usernameField;
    @FindBy(id = "password") private WebElement passwordField;
    @FindBy(xpath= "//button[@class=\"btn btn-primary btn-block\"]") private WebElement loginButton;
	public boolean actual;

    public LoginPage(WebDriver driver) {
    	
        super(driver);
        
    }

    public HomePage doLogin(String user, String pass) {
    	
        type(usernameField, user);
        type(passwordField, pass);
        click(loginButton);
        return new HomePage(driver);
    }
}
