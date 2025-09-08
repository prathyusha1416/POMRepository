package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    @FindBy(how = How.CSS, using = "div.flash.success")
    private WebElement successBanner;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        try {
            return successBanner.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
