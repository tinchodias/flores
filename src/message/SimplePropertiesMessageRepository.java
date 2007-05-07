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
			throw new Error("Messages file not found: " + PROPERTIES_FILE_NAME);
		}
	}

	@Override
	public String messageFor(MessageIdentifier messageIdentifier) {
		String property = properties.getProperty(messageIdentifier.toString());
		
		if (property == null) {
			throw new Error("Message not found: " + messageIdentifier);
		}
		
		return property;
	}

	
	
}
