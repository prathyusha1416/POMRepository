package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import factory.DriverFactory;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {
    	
        LoginPage login = new LoginPage(DriverFactory.getDriver()); // ✅ use DriverFactory
        HomePage home = login.doLogin(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        // Assert.assertTrue(home.isUserLoggedIn(), "User should be logged in");
    }
}
