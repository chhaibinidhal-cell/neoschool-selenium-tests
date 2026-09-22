package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;
    protected final String baseUrl =
            "https://app.neoschool.innoteam.tn/neoschool";
    private static final String reportDir =
            System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "custom-report";

    @BeforeSuite
    
    public void beforeSuite() {
        new File(reportDir).mkdirs();

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
                reportDir + File.separator + "Execution Results - " + timestamp + ".html"
        );
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Testing");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Testing");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    
    @BeforeMethod
    public void setUp(Method method) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (test != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.fail("FAILED: " + result.getName());
                test.fail(result.getThrowable());

                String path = takeScreenshot(result.getName());
                test.addScreenCaptureFromPath(path);

            } else if (result.getStatus() == ITestResult.SKIP) {
                test.skip("SKIPPED: " + result.getName());
            } else {
                test.pass("PASSED: " + result.getName());
            }
        }

        if (driver != null) driver.quit();
    }
    
    @AfterSuite
    public void afterSuite() {
        if (extent != null) extent.flush();
    }

    private String takeScreenshot(String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String destination = reportDir + File.separator + screenshotName + "_" + dateName + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;
    }
}
