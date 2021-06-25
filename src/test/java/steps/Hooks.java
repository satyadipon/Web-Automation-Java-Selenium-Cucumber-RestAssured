package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import setup.Setup;

public class Hooks extends Setup {
	
	@Before
	public void initialize(Scenario scenario) {
		
		if(scenario.getId().toLowerCase().contains("ui")) {
		WebDriverManager.chromedriver().setup();
		setDriver(new ChromeDriver());
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getDriver().get(Setup.getProperty("url"));
		}
		
	}

	@After
	public void teardown(Scenario scenario) {
		
		if(scenario.getId().toLowerCase().contains("ui")) {
		sleep(3);	

		if(getDriver() != null)
			getDriver().quit();
		}
		
	}

}
