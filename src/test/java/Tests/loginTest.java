package Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utils.common;
import pages.loginPage;
import setup.TestSetup;

public class loginTest extends common {
	@Test
	public void loginTests() throws InterruptedException, IOException {
		loginPage lp = new loginPage(driver);
		waitForElement(lp.accountsLink()).click();;
		waitForElement(lp.loginEmailInput()).sendKeys("finnypremkumar@gmail.com");
		waitForElement(lp.emailContinue()).click();;
		waitForElement(lp.passInput()).sendKeys("Finny@99");
		waitForElement(lp.signInSubmit()).click();
		Thread.sleep(10000);
	}
	

}