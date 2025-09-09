package base;

import factory.DriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        String browser = ConfigReader.get("browser");
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        DriverFactory.quitDriver();
    }
}
