package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Setup;

public class HomePage extends Setup {

	@FindBy(xpath = "//h1[text()='Welcome to Shoppersdrobe']")
	public List<WebElement> oHeader;

	WebDriver driver;

	public HomePage() {

		driver = Setup.getDriver(); 
		PageFactory.initElements(driver, this);
	}

	public boolean isHeaderDisplayed() {

		if(oHeader.size()>0)
			return true;

		return false;
	}


}
