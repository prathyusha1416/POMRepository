package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ManageKRACreateCopyKRA extends BasePage {

    @FindBy(xpath = "//button[@class='toggle-btn active']")
    private WebElement ManageKRA;

    @FindBy(xpath = "//button[@class='action-btn']")
    private WebElement CreateNewKRA;

    @FindBy(xpath = "//label[normalize-space()='Copy KRA from Employee to Employee']")
    private WebElement CopyKRAfromEmployeetoEmployee;

    // Dropdowns
    @FindBy(xpath = "//mat-select[@formcontrolname='fromEmployee']")
    private WebElement FromEmployee;

    @FindBy(xpath = "//mat-label[text()='Select Multiple Items']/following::mat-select[1]")
    private WebElement SelectMultipleItems;
    
    

    @FindBy(xpath = "//mat-label[contains(text(),'To Employee')]/following::mat-select[1]")
    private WebElement ToEmployee;

    public ManageKRACreateCopyKRA(WebDriver driver) {
        super(driver);
    }

    // ======================= Buttons =======================
    public void clickManageKRA() {
        ManageKRA.click();
    }

    public void clickCreateNewKRA() {
        CreateNewKRA.click();
    }

    public void clickCopyKRAfromEmployeetoEmployee() {
        CopyKRAfromEmployeetoEmployee.click();
    }

    // ======================= Generic Dropdown Handling =======================
    private void selectOptionByText(WebElement dropdown, String visibleText) {
        dropdown.click(); // open the dropdown
        List<WebElement> options = driver.findElements(By.cssSelector("mat-option"));
        boolean found = false;
        for (WebElement option : options) {
            if (option.getText().trim().equals(visibleText)) {
                option.click();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("Option not found in dropdown: " + visibleText);
        }
        // Optional: click outside to close
        driver.findElement(By.cssSelector("body")).click();
    }

    private void selectOptionByIndex(WebElement dropdown, int index) {
        dropdown.click(); // open dropdown
        List<WebElement> options = driver.findElements(By.cssSelector("mat-option"));
        if (index >= 0 && index < options.size()) {
            options.get(index).click();
        } else {
            throw new IllegalArgumentException("Invalid dropdown index: " + index);
        }
        driver.findElement(By.cssSelector("body")).click();
    }

    // ======================= FromEmployee Dropdown =======================
    public void selectFromEmployeeByText(String text) {
        selectOptionByText(FromEmployee, text);
    }

    public void selectFromEmployeeByIndex(int index) {
        selectOptionByIndex(FromEmployee, index);
    }

    // ======================= ToEmployee Dropdown =======================
    public void selectToEmployeeByText(String text) {
        selectOptionByText(ToEmployee, text);
    }

    public void selectToEmployeeByIndex(int index) {
        selectOptionByIndex(ToEmployee, index);
    }

    // ======================= SelectMultipleItems Dropdown =======================
    public void selectMultipleItemsByText(String... items) {
        SelectMultipleItems.click(); // open dropdown
        List<WebElement> options = driver.findElements(By.cssSelector("mat-option"));

        for (String item : items) {
            boolean found = false;
            for (WebElement option : options) {
                if (option.getText().trim().equals(item)) {
                    option.click();
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new RuntimeException("Option not found in SelectMultipleItems dropdown: " + item);
            }
        }
        // click outside to close dropdown
        driver.findElement(By.cssSelector("body")).click();
    }

    public void selectMultipleItemsByIndex(int... indexes) {
        SelectMultipleItems.click(); // open dropdown
       
        List<WebElement> options = driver.findElements(By.cssSelector("mat-option"));

        for (int index : indexes) {
            if (index >= 0 && index < options.size()) {
                options.get(index).click();
            } else {
                throw new IllegalArgumentException("Invalid index in SelectMultipleItems dropdown: " + index);
            }
        }
        driver.findElement(By.cssSelector("body")).click();
    }
    /* public void selectFirstEmployeeAngular() {
    SelectEmployee.click(); // click mat-select to open
    List<WebElement> options = wait.until(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(employeeOptions));
    options.get(0).click(); // select first option
}*/
  
}
