package setup;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache
{
	private final Properties configProp = new Properties();

	private PropertiesCache()
	{
		//Private constructor to restrict new instances
		File file = new File("application.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Reading all properties from the file");
		try {
			configProp.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Bill Pugh Solution for singleton pattern
	private static class LazyHolder
	{
		private static final PropertiesCache INSTANCE = new PropertiesCache();
	}

	public static PropertiesCache getInstance()
	{
		return LazyHolder.INSTANCE;
	}

	public String getProperty(String key){
		return configProp.getProperty(key);
	}

	public Set<String> getAllPropertyNames(){
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key){
		return configProp.containsKey(key);
	}

	public void setProperty(String key, String value){
		configProp.setProperty(key, value);
	}

	public void flush() throws FileNotFoundException, IOException {
		try (final OutputStream outputstream 
				= new FileOutputStream("application.properties");) {
			configProp.store(outputstream,"File Updated");
			outputstream.close();
		}
	}
}