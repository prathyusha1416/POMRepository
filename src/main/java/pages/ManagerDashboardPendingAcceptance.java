package pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerDashboardPendingAcceptance {
	private WebDriverWait wait;


	 // Locators with PageFactory
	 @FindBy(xpath = "//div[normalize-space()='Pending Acceptance']")
	private WebElement PendingAcceptance;
    @FindBy(xpath="(//button[text()=' View Details '])[1]")
    private WebElement ViewDetails;

    @FindBy(xpath="//button[contains(text(),'✕')]")
    private WebElement Closebutton;
    
    public ManagerDashboardPendingAcceptance(WebDriver driver) {
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void navigateToTab(String tabName) {
	    String tabXpath = String.format("//div[normalize-space()='%s']", tabName);
	    WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tabXpath)));
	    tab.click();
	}
    public void openPendingAcceptance() {
    	PendingAcceptance.click();
    }

    public void ViewDetails() {
    	ViewDetails.click();
    }
    
    public void Closebutton() {
    	Closebutton.click();
    }
    
}
