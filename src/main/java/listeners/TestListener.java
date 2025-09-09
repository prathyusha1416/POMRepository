package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.FrameworkConstants;
import factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

   /* @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.REPORTS_PATH);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }*/
    
    @Override
    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_a").format(new Date());
 
        // 1. Timestamped report
        String reportFile = FrameworkConstants.REPORTS_PATH + "ExtentReport_" + timestamp + ".html";
 
        // 2. Latest report (always overwritten)
        String latestReportFile = FrameworkConstants.REPORTS_PATH + "ExtentReport_latest.html";
 
        ExtentSparkReporter sparkMain = new ExtentSparkReporter(reportFile);
        ExtentSparkReporter sparkLatest = new ExtentSparkReporter(latestReportFile);
 
        extent = new ExtentReports();
        extent.attachReporter(sparkMain, sparkLatest);
    }
 

   /* @Override
    public void onFinish(ITestContext context) {
        if (extent != null) extent.flush();
    }*/
    
    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
 
            // Auto-open the latest report in browser
            try {
                String latestReport = FrameworkConstants.REPORTS_PATH + "ExtentReport_latest.html";
                File htmlFile = new File(latestReport);
                if (htmlFile.exists()) {
                    java.awt.Desktop.getDesktop().browse(htmlFile.toURI());
                }
            } catch (Exception e) {
                System.out.println("Unable to open report automatically: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test passed");
    }
/*
    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, result.getThrowable());
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            try {
                String filePath = takeScreenshot(driver, result.getMethod().getMethodName());
                test.get().addScreenCaptureFromPath(filePath);
                System.out.println("Screenshot attached");
            } catch (IOException e) {
                test.get().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
            }
        }
    }*/
    
    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, result.getThrowable());
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            try {
                String filePath = takeScreenshot(driver, result.getMethod().getMethodName());
                test.get().fail("Screenshot:",
                        com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
            } catch (IOException e) {
                test.get().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
            }
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test skipped");
    }

    /*private String takeScreenshot(WebDriver driver, String methodName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_a").format(new Date());
        String fileName = methodName + "_" + timestamp + ".png";
        Path dir = Paths.get(FrameworkConstants.SCREENSHOT_PATH);
        Files.createDirectories(dir);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path dest = dir.resolve(fileName);
        Files.copy(src.toPath(), dest);
        return dest.toString();
    }*/
    
    private String takeScreenshot(WebDriver driver, String methodName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_a").format(new Date());
        String fileName = methodName + "_" + timestamp + ".png";

        Path dir = Paths.get(FrameworkConstants.SCREENSHOT_PATH);
        Files.createDirectories(dir);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path dest = dir.resolve(fileName);
        Files.copy(src.toPath(), dest);

        // Convert Windows path to a relative or forward-slash path for report
        return dest.toAbsolutePath().toString().replace("\\", "/");
    }

}
