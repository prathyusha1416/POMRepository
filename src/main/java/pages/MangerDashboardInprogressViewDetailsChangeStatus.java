package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class MangerDashboardInprogressViewDetailsChangeStatus extends BasePage{
	@FindBy(xpath = "//button[@class='toggle-btn active']")
    private WebElement ManageKRA;
	
	 // Locators with PageFactory
	 @FindBy(xpath = "//div[text()='In Progress']")
	 private WebElement Inprogress;
	 
	  @FindBy(xpath = "//button[contains(text(),'📋 List')]")
	    private WebElement Lists;
	 
	  @FindBy(xpath = "//div[@class='team-progress-section']//div[1]//div[2]//div[1]//span[1]")
	  private WebElement firstKRAPendingReview;
	  
	  
	  @FindBy(xpath ="//button[contains(normalize-space(.),'Pending Review')]")
	  private WebElement PendingReviews;
	
	  @FindBy(xpath ="//div[@class='kra-submissions-list']//div[1]//div[2]//div[1]//div[1]//div[2]//button[1]")
	  private WebElement ViewDetails;
	
	  @FindBy(xpath ="//div[@class='details-actions']//select[@class='filter-dropdown ng-untouched ng-pristine ng-valid']")
	  private WebElement SelectStatus; 
	  
	  @FindBy(xpath ="//textarea[@id='rejectionComments']")
	  private WebElement RejectedComments;
	  
	  @FindBy(xpath ="//button[normalize-space()='Update Kra Status']")
	  private WebElement UpdateKraStatus;
	
	
	    public MangerDashboardInprogressViewDetailsChangeStatus(WebDriver driver) {
	    	super(driver);
	    	new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }   
	
	 
	public void clickManageKRA() {
	        ManageKRA.click();
	    }
  
   public void Inprogress() {
	   Inprogress.click();
   }
   public void Lists() {
	   Lists.click();
   }
   public void firstKRAPendingReview() {
	   firstKRAPendingReview.click();
   }
   public void ViewDetails() {
	   ViewDetails.click();
   }
   public void SelectStatus(int index) {
	  Select s = new Select(SelectStatus);
	// Optional: check if dropdown is enabled
	    if (!SelectStatus.isEnabled()) {
	        throw new RuntimeException("Status dropdown is disabled");
	    }

	    s.selectByIndex(index); 
   }
   
   public void RejectedComments(String comments) {
	   RejectedComments.sendKeys(comments);
   }
   public void UpdateKraStatus() {
	   UpdateKraStatus.click();
   }
   
   
   
}
   

