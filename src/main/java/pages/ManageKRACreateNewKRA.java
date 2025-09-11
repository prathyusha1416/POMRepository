package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class ManageKRACreateNewKRA extends BasePage {

    @FindBy(xpath = "//button[@class='toggle-btn active']")
    private WebElement ManageKRA;

    @FindBy(xpath = "//button[@class='action-btn']")
    private WebElement CreateNewKRA;
    
    @FindBy(xpath = "//select[@class='form-select']")
    private WebElement SelectEmployee;
    
    
    @FindBy(xpath = "//input[@placeholder='Enter KRA name']")
    private WebElement KRAName;
    
    @FindBy(xpath = "//select[@formcontrolname='frequency']")
    private WebElement Frequency;
    
    @FindBy(xpath = "//textarea[@placeholder='Describe the KRA']")
    private WebElement DescriptionofKRA;
    
    @FindBy(xpath = "//input[@formcontrolname='fromDate']")
    private WebElement fromDateInput;
    
    @FindBy(xpath = "//button[normalize-space()='Create KRAs']")
    private WebElement CreateKRAButton;
     
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement CancelButton;
  
    
    public ManageKRACreateNewKRA(WebDriver driver) {
        super(driver);
    }
    
    
    public void clickManageKRA() {
        ManageKRA.click();
    }

    public void clickCreateNewKRA() {
        CreateNewKRA.click();
    }
    
    public void SelectEmployee() {
    	SelectEmployee.click();
    }	
    
  
    public void selectEmployeeAngular(int index) {
       
    	Select s = new Select(SelectEmployee);
    	s.selectByIndex(index);
    	}
    public void KRAName(String Name) {
    	KRAName.sendKeys(Name);
    }	
    
    public void Frequency(int index) {
    	Select s = new Select(Frequency);
    	s.selectByIndex(index);
    }	
    
    public void DescriptionofKRA(String Description) {
    	DescriptionofKRA.sendKeys(Description);
    }	
    public void setFromDate(String date) {
                   // Clear any existing value
        fromDateInput.sendKeys(date);     // e.g., "2025-09-10"
    }
    
    public void CreateKRAButton() {
    	CreateKRAButton.click();
    }
   /* public void CancelButton() {
    	CancelButton.click();
    }*/
}
