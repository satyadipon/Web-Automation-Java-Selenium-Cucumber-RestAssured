package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Setup;

public class LandingPage extends Setup{

	@FindBy(css = "a[href='/add_product']")
	public WebElement add_product;

	@FindBy(css = "a[href='/get_products']")
	public WebElement get_products;
	
	@FindBy(xpath = "//h1[text()='Welcome to product application']")
	public WebElement landingPageHeader;

	
	
	WebDriver driver;

	public LandingPage() {

		driver = Setup.getDriver(); 
		PageFactory.initElements(driver, this);
	}
	

}
