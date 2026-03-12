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
	public searchProductFunctionalityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
