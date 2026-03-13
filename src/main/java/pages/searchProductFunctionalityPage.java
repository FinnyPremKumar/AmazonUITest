package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchProductFunctionalityPage {
	WebDriver driver;
	//|---------------------------Locators---------------------------------------|
	@FindBy(id= "twotabsearchtextbox")
	WebElement	searchProduct;
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	@FindBy(xpath = "(//div[@data-cy=\"title-recipe\"]//h2//span)[1]")
	WebElement	firstProductName;
	@FindBy(id="nav-logo-sprites")
	WebElement amazonLogo;
	@FindBy(xpath = "//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/div[2]/h2/span[1]")
	WebElement	searchResultsCount;
	
	//|---------------------------Methods---------------------------------------|
	public WebElement searchProduct() {
		return	searchProduct;
	}
	public WebElement searchButton() {
		return searchButton;
	}
	public WebElement firstProductName() {
		return firstProductName;
	}
	public WebElement amazonLogo() {
		return amazonLogo;
	}
	public WebElement searchResultsCount() {
		return searchResultsCount;
	}
	public searchProductFunctionalityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
