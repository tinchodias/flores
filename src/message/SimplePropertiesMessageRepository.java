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

	public String get(MessageId messageId) {
		String property = properties.getProperty(messageId.toString());
		
		if (property == null) {
			throw new Error("Message not found: " + messageId);
		}
		
		return property;
	}

}
