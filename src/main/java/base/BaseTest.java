package base;

import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    	
        String browser = ConfigReader.get("browser");
        DriverFactory.initDriver(browser); 
        DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        //DriverFactory.quitDriver(); 
    }
}
