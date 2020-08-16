package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Setup;

public class LoginPage extends Setup {

	@FindBy(name = "email")
	public WebElement oEmail;
	
	@FindBy(name = "password")
	public WebElement oPassword;
	
	@FindBy(css = "input[value='Sign In']")
	public WebElement oSignIn;
	
	WebDriver driver;

	public LoginPage() {

		driver = Setup.getDriver(); 
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
		
		oEmail.sendKeys(username);
		oPassword.sendKeys(password);
		oSignIn.click();
	}

}
