package Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import setup.TestSetup;

public class common extends TestSetup {
	public WebElement waitForElement(WebElement	 element) throws IOException {
		WebDriverWait	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		long timestamp  = System.currentTimeMillis();

		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./Screenshots/"+Thread.currentThread().getStackTrace()[2].getMethodName()+"/"+timestamp+".png");
		
		FileUtils.copyFile(source, Dest);
		return wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	@DataProvider(name = "AmazonTestDataXLSX")
	public static Object[][] testData(Method method) {
		String filepath = "src/test/resources/TestData.xlsx";
		String sheetName = "amazonScenarios";
		System.out.println("MethodName: "+method.getName());
		System.out.println("Reading Excel Data...");
		return ExcelUtils.getScenariosData(filepath, sheetName, method.getName());
	}
}
