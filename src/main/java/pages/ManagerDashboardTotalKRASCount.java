package pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
 
public class ManagerDashboardTotalKRASCount extends BasePage {
 
    public ManagerDashboardTotalKRASCount(WebDriver driver) {
        super(driver);
    }
 
    @FindBy(xpath = "//div[@class='stat-label' and normalize-space(text())='Total KRAs']/preceding-sibling::div[@class='stat-number']/span")
    private WebElement totalKRASCount;
 
    @FindBy(xpath = "//div[@class='stat-label' and normalize-space(text())='In Progress']/preceding-sibling::div[@class='stat-number']/span\r\n"
    		+ "")
    private WebElement inProgressCount;
 
    @FindBy(xpath = "//div[@class='stat-label' and normalize-space(text())='Pending Acknowleged']/preceding-sibling::div[@class='stat-number']/span"
    		+ "")
    private WebElement pendingAcknowlegedCount;
 
    @FindBy(xpath = "//div[@class='stat-label' and normalize-space(text())='Completed']/preceding-sibling::div[@class='stat-number']/span\r\n"
    		+ "")
    private WebElement completedCount;
 
    @FindBy(xpath = "//div[@class='stat-label' and normalize-space(text())='Objection Raised']/preceding-sibling::div[@class='stat-number']/span\r\n"
    		+ "")
    private WebElement objectionRaisedCount;
 
    @FindBy(xpath = "//div[@class='stat-label' and normalize-space(text())='Missed deadlines']/preceding-sibling::div[@class='stat-number']/span\r\n"
    		+ "")
    private WebElement missedDeadlinesCount;
 
    // Getter methods
    public int getTotalKRAS() {
        return Integer.parseInt(getText(totalKRASCount));
    }
 
    public int getInProgress() {
        return Integer.parseInt(getText(inProgressCount));
    }
 
    public int getPendingAcknowleged() {
        return Integer.parseInt(getText(pendingAcknowlegedCount));
    }
 
    public int getCompleted() {
        return Integer.parseInt(getText(completedCount));
    }
 
    public int getObjectionRaised() {
        return Integer.parseInt(getText(objectionRaisedCount));
    }
 
    public int getMissedDeadlines() {
        return Integer.parseInt(getText(missedDeadlinesCount));
    }
}
 