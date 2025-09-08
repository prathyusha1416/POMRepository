package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class Dashboardpage extends BasePage  {
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-block']") private WebElement dashboard;
	public Dashboardpage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	public void clickOnDashboard() {
        dashboard.click();
    }
}
