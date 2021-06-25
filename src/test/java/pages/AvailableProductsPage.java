package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Setup;

public class AvailableProductsPage extends Setup{

	
	@FindBy(xpath = "//*[text()='Edit product']")
	public List<WebElement> editProduct;
	@FindBy(xpath = "//*[text()='Show product']")
	public List<WebElement> showProduct;
	@FindBy(xpath = "//*[text()='Delete product']")
	public List<WebElement> deleteProduct;
	@FindBy(xpath = "(//tr/td)[1]")
	public List<WebElement> productId;
	
	
	@FindBy(css = "h2")
	public WebElement pageHeader;
	
	
	WebDriver driver;

	public AvailableProductsPage() {

		driver = Setup.getDriver(); 
		PageFactory.initElements(driver, this);
	}
	

}
