package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class Logoutpage extends BasePage{
  

    public Logoutpage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//a[@role='button']")
    private WebElement profileDropdown;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutButton;

    public void logout() {
        try {
            profileDropdown.click();
            logoutButton.click();
        } catch (Exception e) {
            System.out.println("Logout skipped due to session error.");
        }
    }
}
