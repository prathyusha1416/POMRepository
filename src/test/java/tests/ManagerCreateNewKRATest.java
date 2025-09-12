package tests;

import base.BaseTest;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageKRACreateNewKRA;
import utils.ConfigReader;
import utils.DBUtils;

import java.sql.ResultSet;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ManagerCreateNewKRATest extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private String username;
    private String password;

    @BeforeClass
    public void setUp() {
        try {
            // 1️⃣ Initialize WebDriver
            driver = DriverFactory.initDriver("chrome");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 2️⃣ Navigate to application URL
            String url = ConfigReader.get("url");
            if (url == null || url.isEmpty()) {
                throw new Exception("App URL not configured in config.properties");
            }
            driver.get(url);

            // 3️⃣ Connect to DB
            DBUtils.connectDB(
                ConfigReader.get("db.url"),
                ConfigReader.get("db.username"),
                ConfigReader.get("db.password")
            );

            // 4️⃣ Fetch all credentials
            List<Map<String, String>> allCreds = DBUtils.getAllCredentials(
                "Select UserName, Pwd from TBL_ATTENDANCE_USERS where Status=1"
            );

            if (allCreds.isEmpty()) {
                throw new Exception("❌ No credentials found in DB");
            }

            // 🔹 Pick one record dynamically
            // Option A: First record
            // Map<String, String> cred = allCreds.get(0);

            // Option B: Random record
            Random rand = new Random();
            Map<String, String> cred = allCreds.get(rand.nextInt(allCreds.size()));

            // ✅ Assign to class-level variables
            username = cred.get("username");
            password = cred.get("password");

            System.out.println("✅ Picked User -> " + username);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("❌ @BeforeClass setup failed: " + e.getMessage());
        }
    }

    @Test
    public void verifyValidLoginAndKRA_DBValidation() {
        try {
            // Step 1: Login
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);

            // Step 2: Create New KRA
            ManageKRACreateNewKRA manageKRA = new ManageKRACreateNewKRA(driver);
            manageKRA.clickManageKRA();

            // Wait and click "Create New KRA"
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create New KRA']"))).click();

            // Select employee dynamically (Angular dropdown)
            manageKRA.selectEmployeeAngular(4);

            // Fill KRA details
            manageKRA.KRAName("Prathyusha");
            manageKRA.Frequency(4);
            manageKRA.DescriptionofKRA("Automating KRA creation with Selenium & DB validation");
            manageKRA.setFromDate("09-09-2025");

            // Click create button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create KRA']"))).click();
            System.out.println("✅ Created Successfully in UI");

            // Step 3: DB Validation
            String query = "SELECT TOP 1 KRAName, Description, Frequency FROM KRATable ORDER BY CreatedDate DESC";
            ResultSet rs = DBUtils.executeQuery(query);

            if (rs.next()) {
                Assert.assertEquals(rs.getString("KRAName"), "Prathyusha", "KRA Name mismatch!");
                Assert.assertTrue(rs.getString("Description").contains("Selenium"), "Description mismatch!");
                Assert.assertEquals(rs.getString("Frequency"), "Half-Yearly", "Frequency mismatch!");
                System.out.println("✅ DB Validation Passed");
            } else {
                Assert.fail("❌ No record found in DB for created KRA");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("❌ Test failed: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            DBUtils.closeDB();
            //DriverFactory.quitDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
