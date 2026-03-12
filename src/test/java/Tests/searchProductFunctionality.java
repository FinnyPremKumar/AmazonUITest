package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.core.util.Assert;
import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Utils.common;
import pages.searchProductFunctionalityPage;

public class searchProductFunctionality extends common{
	searchProductFunctionalityPage searchProductObj;

	@Test(priority = 0, dataProvider = "AmazonTestDataXLSX")
	public void TC01_verify_search_validProductKeyword(Map<String, String> data) throws InterruptedException, IOException {
		waitForElement(searchProductObj.searchProduct()).click();
		waitForElement(searchProductObj.searchProduct()).clear();
		waitForElement(searchProductObj.searchProduct()).sendKeys(data.get("searchProduct"));
		waitForElement(searchProductObj.searchButton()).click();
	}
	
	@Test(priority = 1, dataProvider = "AmazonTestDataXLSX")
	public void TC02_verify_searchresults_display_relevantProducts_matchingKeyword(Map<String, String> data) throws InterruptedException, IOException {
		waitForElement(searchProductObj.searchProduct()).click();
		waitForElement(searchProductObj.searchProduct()).clear();
		waitForElement(searchProductObj.searchProduct()).sendKeys(data.get("searchProduct"));
		waitForElement(searchProductObj.searchButton()).click();
		String searchResulttext=waitForElement(searchProductObj.firstProductName()).getText();
		searchResulttext.contains("Trimmer");
		
	}
	@Test(priority = 2, dataProvider = "AmazonTestDataXLSX")
	public void TC03_verify_search_Pressing_EnterKey(Map<String, String> data) throws InterruptedException, IOException {
		waitForElement(searchProductObj.searchProduct()).click();
		waitForElement(searchProductObj.searchProduct()).clear();
		waitForElement(searchProductObj.searchProduct()).sendKeys(data.get("searchProduct"));
		waitForElement(searchProductObj.searchProduct()).sendKeys(Keys.ENTER);
	}
	
	
	@BeforeTest
	public void pageObj() {
		 searchProductObj=new searchProductFunctionalityPage(driver);
	}

}
