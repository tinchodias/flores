package message;

import javax.swing.ImageIcon;




public abstract class IconRepository {

	private static IconRepository instance;

	public static IconRepository instance() {
		if (instance == null) {
			instance = new SimplePropertiesIconRepository();
		}
		return instance;
	}

	/**
	 * Returns the icon associated with the {@link MessageId}.
	 * @param messageId
	 * @return The icon, or <code>null</code> if it is not found.
	 */
	public abstract ImageIcon get(MessageId messageId);
	
}
