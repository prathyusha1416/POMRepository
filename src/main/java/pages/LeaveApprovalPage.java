package pages;

import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import base.BasePage;

public class LeaveApprovalPage  extends BasePage{
 
    private WebDriverWait wait;

    @FindBy(id = "year")
    private WebElement yearDropdown;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "(//a[text()=' view'])[1]")
    private WebElement firstViewLink;

    @FindBy(name = "mgr_approval")
    private WebElement statusDropdown;

    @FindBy(name = "mgr_comments")
    private WebElement commentBox;

    @FindBy(id = "submit")
    private WebElement submitApproval;

    public LeaveApprovalPage(WebDriver driver) {
    	super(driver);
    }

    public void selectYear(int index) {
        new Select(yearDropdown).selectByIndex(index);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void clickFirstView() {
        firstViewLink.click();
    }

    public void selectApprovalStatus(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown));
        new Select(statusDropdown).selectByIndex(index);
    }

    public void enterManagerComment(String comment) {
        commentBox.sendKeys(comment);
    }

    public void submitApproval() {
        submitApproval.click();
    }

    public String handleAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }
}
