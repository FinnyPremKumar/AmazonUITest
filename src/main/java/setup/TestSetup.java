package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSetup {
	protected WebDriver driver;
	
	@BeforeSuite
	public void beforeSuit() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");	
	}
	@AfterSuite
	public void afterTest() throws InterruptedException {
		driver.quit();
	}
}
