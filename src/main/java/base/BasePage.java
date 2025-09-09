package base;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
	
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
    	
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
    }

    protected void click(WebElement element) {
    	
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    protected void type(WebElement element, String text) {
    	
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
    	
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void hover(WebElement element) {
    	
        new Actions(driver).moveToElement(element).perform();
        
    }
}
