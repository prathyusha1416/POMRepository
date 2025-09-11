package pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
 
public class ManagerDashboardTotalKRASAllKRAS extends BasePage {
 
    @FindBy(xpath = "(//div[@class=\"stat-label\"])[1]")
    private WebElement TotalKRAS;
 
    @FindBy(xpath = "//button[contains(text(),'📋 List')]")
    private WebElement Lists;
 
    @FindBy(xpath = "//div[@class='team-progress-section']//div[1]//div[2]//div[1]//span[1]")
    private WebElement firstKRA;
 
    @FindBy(xpath = "(//button[contains(@class,'filter-tab')])[1]")
    private WebElement ALLKRAS;
    
    @FindBy(xpath = "(//button[contains(@class,'filter-tab')])[2]")
    private WebElement InProgress;
    
    @FindBy(xpath = "(//button[contains(@class,'filter-tab')])[3]")
    private WebElement Completed;
    
    @FindBy(xpath = "(//button[contains(@class,'filter-tab')])[4]")
    private WebElement Overdue;
    
    @FindBy(xpath = "(//button[contains(@class,'filter-tab')])[5]")
    private WebElement Assigned;
    
    @FindBy(xpath = "(//button[contains(@class,'filter-tab')])[6]")
    private WebElement ObjectionRasied;
    
   
    
    @FindBy(xpath = "//button[contains(@class,'filter-tab')][.//text()[normalize-space()='All KRAs']]//span[@class='tab-count']")
    private WebElement ALLKRASCount;
 
   @FindBy(xpath = "//button[contains(@class,'filter-tab') and contains(normalize-space(.),'In-Progress')]//span[@class='tab-count']")
    private WebElement InProgressCount;
 
    @FindBy(xpath = "//button[contains(@class,'filter-tab') and contains(normalize-space(.),'Completed')]//span[@class='tab-count']")
    
    private WebElement completedCount;
    
   @FindBy(xpath = "//button[contains(@class,'filter-tab') and contains(normalize-space(.),'Assigned')]//span[@class='tab-count']")
    private WebElement AssignedCount;
 
    @FindBy(xpath = "//button[contains(@class,'filter-tab') and contains(normalize-space(.),'Objection Raised')]//span[@class='tab-count']")
    private WebElement objectionRaisedCount;
 
    @FindBy(xpath = "//button[contains(text(),'✕')]")
    private WebElement Closebutton;
 
    // Getter methods
    public int getAllKRAS() {
        return Integer.parseInt(getText(ALLKRASCount));
    }
 
    public int getInProgress() {
        return Integer.parseInt(getText(InProgressCount));
    }
 
 
    public int getCompleted() {
        return Integer.parseInt(getText(completedCount));
    }
    
    public int getAssignedCount() {
        return Integer.parseInt(getText(AssignedCount));
  
    }
    public int getObjectionRaised() {
        return Integer.parseInt(getText(objectionRaisedCount));
    }
 
    
 
    public ManagerDashboardTotalKRASAllKRAS(WebDriver driver) {
        super(driver);
       
    }
 
    // Navigate to a tab using BasePage click() → automatically waits until clickable
   /* public void navigateToTab(String tabName) {
        String tabXpath = String.format("//div[contains(normalize-space(),'%s')]", tabName);
        WebElement tab = driver.findElement(By.xpath(tabXpath));
        click(tab); // uses BasePage.wait internally
    }*/
 
    public void openTotalKRAS() {
        click(TotalKRAS);
    }
 
    public void Lists() {
        click(Lists);
    }
 
    public void openFirstKRAItem() {
        click(firstKRA);
    }
 
    public void ALLKRAS() {
        click(ALLKRAS);
    }
    
    public void InProgress() {
        click(InProgress);
    }
    
    public void Completed() {
        click(Completed);
    }
    
    public void Overdue() {
        click(Overdue);
    }
    
    public void Assigned() {
        click(Assigned);
    }
    
    public void ObjectionRasied() {
        click(ObjectionRasied);
    }
    
    public void ALLKRASCount() {
        click(ALLKRASCount);
    }
    
    public void InProgressCount() {
        click(InProgressCount);
    }
    
    public void completedCount() {
        click(completedCount);
    }
    
    public void AssignedCount() {
        click(AssignedCount);
    }
    
   
    public void objectionRaisedCount() {
        click(objectionRaisedCount);
    }
    
    public void Closebutton() {
        click(Closebutton);
    }
    
   
}
 