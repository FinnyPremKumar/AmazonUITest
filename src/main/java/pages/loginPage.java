package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	@FindBy(xpath = "//span[contains(text(),'Account & Lists')]")
	WebElement	homeaccountslink;
	@FindBy(id = "ap_email_login")
	WebElement	loginEmailInput;
	@FindBy(xpath = "//span[@id=\"continue\"]/span/input")
	WebElement	emailContinue;
	@FindBy(id = "ap_password")
	WebElement	passInput;
	@FindBy(id = "signInSubmit")
	WebElement 	signInButton;
	
	public WebElement accountsLink() {
		
		return	homeaccountslink;
	}
	public WebElement loginEmailInput() {
		return	loginEmailInput;
	}
	public WebElement emailContinue() {
		return	emailContinue;
	}
	public WebElement passInput() {
		return	passInput;
	}
	public WebElement signInSubmit() {
		return	signInButton;
	}
	
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
