package setup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;



public class Setup 
{
	private static WebDriver driver = null;
	private static Properties prop = new Properties();
	
	static {
		InputStream stream = Setup.class.getResourceAsStream("/propertyFiles/config.properties");
		try {
			prop.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public static String getProperty(String property) {
		
		return prop.getProperty(System.getProperty("env","test")+"."+property);
	}
	
	public static void sleep(int secs) {
		
		try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
