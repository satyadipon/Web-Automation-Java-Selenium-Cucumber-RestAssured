package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Setup;

public class AddProductPage extends Setup{

	@FindBy(css = "#name")
	public WebElement name;

	@FindBy(css = "#price")
	public WebElement price;
	
	@FindBy(css = "#description")
	public WebElement description;
	
	@FindBy(css = "button[type='submit']")
	public WebElement save;
	
	
	WebDriver driver;

	public AddProductPage() {

		driver = Setup.getDriver(); 
		PageFactory.initElements(driver, this);
	}
	

}
