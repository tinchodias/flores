package message;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

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
		return get(messageId, new Object[]{});
	}

	public String get(MessageId messageId, Object[] arguments) {
		String message = properties.getProperty(messageId.toString());
		if (message == null) {
			throw new Error("Message not found: " + messageId);
		}
		for (int i = 0; i < arguments.length; i++) {
			message = StringUtils.replaceOnce(message, ARGUMENT_TOKEN, arguments[i].toString());
		}
		return message;
	}

}
