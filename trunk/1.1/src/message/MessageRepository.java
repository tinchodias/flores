package message;



public abstract class MessageRepository {

	public static final String ARGUMENT_TOKEN = "·";
	private static MessageRepository instance;

	public static MessageRepository instance() {
		if (instance == null) {
			instance = new SimplePropertiesMessageRepository();
		}
		return instance;
	}

	/**
	 * Retrieves a plain message.
	 * 
	 * @param messageId
	 * @return
	 */
	public abstract String get(MessageId messageId);

	/**
	 * Retrieves a message. Uses the arguments received converting each one with toString(), 
	 * and replacing with them the <tt>ARGUMENT_TOKEN</tt> occurrences.
	 *   
	 * @param messageId
	 * @param arguments
	 * @return
	 */
	public abstract String get(MessageId messageId, Object[] arguments);
	
}
