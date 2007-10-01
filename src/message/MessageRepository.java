package message;



public abstract class MessageRepository {

	private static MessageRepository instance;

	public static MessageRepository instance() {
		if (instance == null) {
			instance = new SimplePropertiesMessageRepository();
		}
		return instance;
	}

	public abstract String get(MessageId messageId);

	public abstract String get(MessageId messageId, String[] arguments);
	
}
