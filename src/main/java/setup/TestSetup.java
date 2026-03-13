package setup;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.LoggerHelper;

public class TestSetup {
	protected WebDriver driver;
	protected Logger log = LoggerHelper.getLogger(getClass());
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void beforeSuit() {
		log.info("Opening Browser...");
		ExtentSparkReporter spark=new ExtentSparkReporter("reports/Index.html");
		extent =new ExtentReports();
		extent.attachReporter(spark);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Launching Amazon Website...");
		//test.info("Launching Amazon Website...");
		driver.get("https://www.amazon.in");	
	}
	@AfterSuite
	public void afterTest() throws InterruptedException, IOException {
		File folder=new File("./Screenshots/waitForElement");
		if (folder.exists()) {
			FileUtils.deleteDirectory(folder);
		}
		log.info("Closing Browser...");
		extent.flush();
		driver.quit();
	}
	@BeforeMethod
	public void setupReports(Method method) {
		test =extent.createTest(method.getName());
	}
}
