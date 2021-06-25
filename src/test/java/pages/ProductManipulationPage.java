package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Setup;

public class ProductManipulationPage extends Setup{

	
	@FindBy(xpath = "//strong[text()='ID:']/../following-sibling::td/span")
	public WebElement idValue;
	@FindBy(xpath = "//strong[text()='Name:']/../following-sibling::td/span")
	public WebElement nameValue;
	@FindBy(xpath = "//strong[text()='Price:']/../following-sibling::td/span")
	public WebElement priceValue;
	@FindBy(xpath = "//strong[text()='Description:']/../following-sibling::td/span")
	public WebElement descValue;

	@FindBy(css = "a[href='/add_product']")
	public WebElement add_new_product;

	@FindBy(css = "a[href='/get_products']")
	public WebElement to_producty_list;
	
	@FindBy(css = "h2")
	public WebElement pageHeader;
	
	
	WebDriver driver;

	public ProductManipulationPage() {

		driver = Setup.getDriver(); 
		PageFactory.initElements(driver, this);
	}
	

}
