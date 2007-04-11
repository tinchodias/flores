package message;

import java.io.FileInputStream;
import java.util.Properties;

public class SimplePropertiesMessageRepository extends MessageRepository {

	private static final String PROPERTIES_FILE_NAME = "messages.properties";
	private Properties properties;

	public SimplePropertiesMessageRepository() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public String messageFor(MessageIdentifier messageIdentifier) {
		return properties.getProperty(messageIdentifier.toString());
	}

	
	
}
