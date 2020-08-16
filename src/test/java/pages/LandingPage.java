package pages;

import org.openqa.selenium.WebDriver;

import setup.Setup;

public class LandingPage extends Setup{

	WebDriver driver;

	public LandingPage() {

		driver = Setup.getDriver(); 
	}
}
