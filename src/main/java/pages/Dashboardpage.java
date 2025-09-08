package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class Dashboardpage extends BasePage{
 

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboardMenu;

    @FindBy(xpath = "//a[text()='Leaves & Permissions']")
    private WebElement leavesMenu;

    @FindBy(xpath = "//a[text()='EmpLeaveRequest']")
    private WebElement empLeaveRequest;

    public Dashboardpage(WebDriver driver) {
    	super(driver);
    }

    public void clickDashboard() {
        dashboardMenu.click();
    }

    public void openLeavesSection() {
        leavesMenu.click();
    }

    public void openEmpLeaveRequest() {
        empLeaveRequest.click();
    }
}
