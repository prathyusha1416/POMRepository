package base;

import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.DBUtils;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUpDB() throws Exception {
        // ✅ Setup DB Connection once per suite
        DBUtils.connectDB(
            ConfigReader.get("db.url"),
            ConfigReader.get("db.username"),
            ConfigReader.get("db.password")
        );
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        // ✅ Setup WebDriver before each test
        String browser = ConfigReader.get("browser");
        DriverFactory.initDriver(browser);

        // ✅ Navigate to URL
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // ✅ Quit WebDriver after each test
       // DriverFactory.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownDB() throws Exception {
        // ✅ Close DB connection after suite
       // DBUtils.closeDB();
    }
}
