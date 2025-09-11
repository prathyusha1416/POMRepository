package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class MangerDashborad extends BasePage{
	

	@FindBy(xpath = "//div[normalize-space()='Total KRAs']")
    private WebElement TotalKRAS;
	
    @FindBy(xpath = "//div[text()='In Progress']")
    private WebElement InProgress;

    @FindBy(xpath = "//div[normalize-space()='Pending Acknowleged']")
    private WebElement PendingAcknowleged;

    @FindBy(xpath = "//div[normalize-space()='Completed']")
    private WebElement Completed;
    
    @FindBy(xpath = "//div[normalize-space()='Objection Raised']")
    private WebElement ObjectionRaised;
    
    @FindBy(xpath = "//div[normalize-space()='Missed deadlines']")
    private WebElement Misseddeadlines;
    


    public MangerDashborad(WebDriver driver) {
    	super(driver);
    }
    
   

    public void TotalKRAS() {
    	TotalKRAS.click();
    }

    public void InProgress() {
    	InProgress.click();
    }

    public void PendingAcknowleged() {
    	PendingAcknowleged.click();
    }
    public void Completed() {
    	Completed.click();
    }
    
    public void ObjectionRaised() {
    	ObjectionRaised.click();
    }
    
    public void Misseddeadlines() {
    	Misseddeadlines.click();
    }

	
	
}
