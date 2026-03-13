package Tests;


import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.common;
import pages.searchProductFunctionalityPage;

public class searchProductFunctionality extends common{
	searchProductFunctionalityPage searchProductObj;

	@Test(priority = 0, dataProvider = "AmazonTestDataXLSX")
	public void TC01_verify_search_validProductKeyword(Map<String, String> data) throws InterruptedException, IOException {
		log.info("Clicking on Search Box");
		test.info("Clicking on Search Box");
		try {
			waitForElement(searchProductObj.searchProduct()).click();
			waitForElement(searchProductObj.searchProduct()).clear();
			log.info("Entering the Search Item into Search Box");
			test.info("Entering the Search Item into Search Box");
			waitForElement(searchProductObj.searchProduct()).sendKeys(data.get("searchProduct"));
			log.info("Cicking on Search Button");
			test.info("Cicking on Search Button");
			waitForElement(searchProductObj.searchButton()).click();
			test.pass("TCPassed");
		}catch (Exception e) {
			test.fail("Test failed due to: " + e.getMessage());
		}
	}
	
	@Test(priority = 1, dataProvider = "AmazonTestDataXLSX")
	public void TC02_verify_searchresults_display_relevantProducts_matchingKeyword(Map<String, String> data) throws InterruptedException, IOException {
		log.info("Clicking on Search Box");
		test.info("Clicking on Search Box");
		waitForElement(searchProductObj.searchProduct()).click();
		waitForElement(searchProductObj.searchProduct()).clear();
		log.info("Entering the Search Item into the Search Box");
		waitForElement(searchProductObj.searchProduct()).sendKeys(data.get("searchProduct"));
		log.info("Clicking on Search Button");
		waitForElement(searchProductObj.searchButton()).click();
		log.info("Checking whether the Product page displays with relevant Products from Search Results");
		String searchResulttext=waitForElement(searchProductObj.firstProductName()).getText();
		log.info("Validating whether product results contain searched Item name");
		searchResulttext.contains("Trimmer");
		
	}
	@Test(priority = 2, dataProvider = "AmazonTestDataXLSX")
	public void TC03_verify_search_Pressing_EnterKey(Map<String, String> data) throws InterruptedException, IOException {
		log.info("Clicking on Search Box");
		waitForElement(searchProductObj.searchProduct()).click();
		waitForElement(searchProductObj.searchProduct()).clear();
		log.info("Entering the Search Item into the Search Box");
		waitForElement(searchProductObj.searchProduct()).sendKeys(data.get("searchProduct"));
		log.info("Clicking on Enter Button from Keyboard");
		waitForElement(searchProductObj.searchProduct()).sendKeys(Keys.ENTER);
	}
	@Test(priority = 3, dataProvider = "AmazonTestDataXLSX")
	public void TC04_verify_search_count_inResultsPage(Map<String, String> data) throws InterruptedException, IOException {
		log.info("Clicking on Search Box");
		waitForElement(searchProductObj.searchProduct()).click();
		waitForElement(searchProductObj.searchProduct()).clear();
		log.info("Entering the Search Item into the Search Box");
		waitForElement(searchProductObj.searchProduct()).sendKeys(data.get("searchProduct"));
		log.info("Clicking on Enter Button from Keyboard");
		waitForElement(searchProductObj.searchProduct()).sendKeys(Keys.ENTER);
		String results=searchProductObj.searchResultsCount().getText();
		boolean validation=results.contains("results");
		Assert.assertTrue(validation, "Search Results contain number of products counts");
	}
	
	@BeforeMethod
	public void navigateToHomepage() throws IOException {
		log.info("Navigates to Homepage");
		waitForElement(searchProductObj.amazonLogo()).click();	
	}
	
	@BeforeTest
	public void pageObj() {
		 searchProductObj=new searchProductFunctionalityPage(driver);
	}

}