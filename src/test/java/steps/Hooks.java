package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import setup.Setup;

public class Hooks extends Setup {
	
	@Before()
	public void initialize() {
		
		WebDriverManager.chromedriver().setup();
		setDriver(new ChromeDriver());
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getDriver().get(Setup.getProperty("url"));
	}

	@After()
	public void teardown() {

		if(getDriver() != null)
			getDriver().quit();
		
	}

}
