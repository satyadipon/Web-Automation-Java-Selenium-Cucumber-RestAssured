package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Setup;

public class Navbar {

	@FindBy(id = "home")
	public WebElement oHome;

	@FindBy(id = "about")
	public WebElement oAbout;

	@FindBy(id = "login")
	public WebElement oLogin;

	@FindBy(id = "signup")
	public WebElement oSignup;

	@FindBy(id = "logout")
	public WebElement oLogout;

	@FindBy(id = "currentuser")
	public WebElement oCurrentUser;

	@FindBy(id = "posts")
	public WebElement oMyPosts;

	WebDriver driver;

	public Navbar() {

		driver = Setup.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void clickLogin() {

		oLogin.click();
	}

	public void clickLogout() {

		oLogout.click();
	}

	public void clickMyPosts() {

		oMyPosts.click();
	}

	public void clickSignup() {

		oSignup.click();
	}
	
	public String getCurrentUserName() {

		return oCurrentUser.getText().replace("Welcome", "").replace("!", "").trim();
	}

}
