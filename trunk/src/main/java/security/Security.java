package security;

import message.MessageId;
import persistence.ModelPersistence;

public class Security {

	private static Security instance;

	private User loggedUser;

	public static Security instance() {
		if (instance == null) {
			instance = new Security();
		}
		return instance;
	}

	private Security() {
	}

	/**
	 * Tries to login a user.
	 * 
	 * @param name
	 * @param password
	 * @throws ModelSecurityException on invalid login data.
	 */
	public void login(String name, String password) throws ModelSecurityException {
		Users users = ModelPersistence.instance().loadedModel().users();
		if (users.isValid(name, password)) {
			loggedUser(users.get(name));
		} else {
			throw new ModelSecurityException(MessageId.securityInvalidLogin);
		}
	}

	private void loggedUser(User user) {
		loggedUser = user;
	}

	public User loggedUser() {
		return loggedUser;
	}
	
}
