package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class ManagerDashboardInprogressCountandViewDetails extends BasePage{
	private WebDriverWait wait;
	
	
	 // Locators with PageFactory
	 @FindBy(xpath = "//div[text()='In Progress']")
	 private WebElement Inprogress;
	 
	  @FindBy(xpath = "//button[contains(text(),'📋 List')]")
	    private WebElement Lists;
	 
	  @FindBy(xpath = "//div[@class='team-progress-section']//div[1]//div[2]//div[1]//span[1]")
	  private WebElement firstKRAPendingReview;
	  
	  @FindBy(xpath ="//button[contains(normalize-space(.),'Pending Review')]")
	  private WebElement PendingReviews;
	
	  @FindBy(xpath = "//button[contains(normalize-space(.),'Reviewed KRAs')]")
	    private WebElement reviewedKRAsTab;

	  @FindBy(xpath = "//button[normalize-space()='View Details']")
	    private WebElement reviewedKRAsViewDetails;
	  
	  @FindBy(xpath = "//button[@class=\"close-btn\"]")
	    private WebElement Closebutton;
	  
	    @FindBy(xpath = "//button[contains(normalize-space(.),'Rejected KRAs')]")
	    private WebElement rejectedKRAsTab;
	    
	    @FindBy(xpath = "(//button[@class=\"view-details-btn\"])[4]")
	    private WebElement rejectedKRAsViewDetails;
	    
	  
	    @FindBy(xpath = "//button[contains(normalize-space(.),'Yet to Start')]")
	    private WebElement yetToStartTab;
	 
	  @FindBy(xpath = "//button[contains(.,'Pending Review')]/span[@class='tab-count']")
	    private WebElement pendingReviewCount;
	 
	    @FindBy(xpath = "//button[contains(.,'Reviewed KRAs')]/span[@class='tab-count']")
	    private WebElement 	ReviewedKRASCount;
	 
	    @FindBy(xpath = "//button[contains(.,'Rejected KRAs')]/span[@class='tab-count']")
	    private WebElement RejectedKRASCount;
	 
	    @FindBy(xpath = "//button[contains(.,'Yet to Start')]/span[@class='tab-count']")
	    private WebElement YetToStartCount;

	    public ManagerDashboardInprogressCountandViewDetails(WebDriver driver) {
	    	super(driver);
	    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }   
	
	    // Getter methods
	    public int getpendingReview() {
	        return Integer.parseInt(getText(pendingReviewCount));
	    }
	 
	    public int getReviewedKRAS() {
	        return Integer.parseInt(getText(ReviewedKRASCount));
	    }
	 
	    public int getRejectedKRAS() {
	        return Integer.parseInt(getText(RejectedKRASCount));
	    }
	 
	    public int getYetToStart() {
	        return Integer.parseInt(getText(YetToStartCount));
	    }
	 
	    
   public void navigateToTab(String tabName) {
	    String tabXpath = String.format("//div[normalize-space()='%s']", tabName);
	    WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tabXpath)));
	    tab.click();
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
   public void Closebutton() {
	   Closebutton.click();
   }
   
   
   public void ReviewedKRAS() {
	   reviewedKRAsTab.click();
   }
   
   public void reviewedKRAsViewDetails() {
	   reviewedKRAsViewDetails.click();
   }
   
   public void PendingReviews() {
	   PendingReviews.click();
   }
   
   public void RejectedKRAS() {
	   rejectedKRAsTab.click();
   }
   public void rejectedKRAsViewDetails() {
	   rejectedKRAsViewDetails.click();
   }
   
   
   public void YetToStart() {
	   yetToStartTab.click();
   }  
	  
}
   

