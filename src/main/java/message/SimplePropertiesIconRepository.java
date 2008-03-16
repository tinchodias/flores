package message;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import javax.swing.ImageIcon;

public class SimplePropertiesIconRepository extends IconRepository {

	private static final String PROPERTIES_FILE_NAME = "icons.properties";
	private Properties properties;

	public SimplePropertiesIconRepository() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
		} catch (Exception e) {
			throw new Error("Icons file not found: " + PROPERTIES_FILE_NAME);
		}
	}

	public ImageIcon get(MessageId messageId) {
		String property = properties.getProperty(messageId.toString());
		
		if (property != null) {
			return iconFromResource(property);
		} else {
			return null;
		}
	}

	private ImageIcon iconFromResource(String name) {
		URL url = SimplePropertiesIconRepository.class.getResource(name);

		ImageIcon imageIcon = null;
		if (url != null) {
			imageIcon = new ImageIcon(url);
		}
		return imageIcon;
	}

}
