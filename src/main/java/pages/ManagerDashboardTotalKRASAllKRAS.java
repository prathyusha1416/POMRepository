package pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
 
public class ManagerDashboardTotalKRAS extends BasePage {
 
    @FindBy(xpath = "(//div[@class=\"stat-label\"])[1]")
    private WebElement TotalKRAS;
 
    @FindBy(xpath = "//button[contains(text(),'📋 List')]")
    private WebElement Lists;
 
    @FindBy(xpath = "//div[@class='team-progress-section']//div[1]//div[2]//div[1]//span[1]")
    private WebElement firstKRA;
 
    @FindBy(xpath = "//button[@class='filter-tab active']")
    private WebElement ALLKRAS;
 
    public ManagerDashboardTotalKRAS(WebDriver driver) {
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
}
 