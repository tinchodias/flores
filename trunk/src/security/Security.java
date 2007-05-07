package security;

import message.MessageId;
import persistence.ModelPersistence;
import persistence.exception.MessageIdentifiedException;

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

	public void login(String name, String password) throws MessageIdentifiedException {
		Users users = ModelPersistence.instance().loadedModel().users();
		if (users.isValid(name, password)) {
			loggedUser(users.get(name));
		} else {
			throw new MessageIdentifiedException(MessageId.securityInvalidLogin);
		}
	}

	private void loggedUser(User user) {
		loggedUser = user;
	}

	public User getLoggedUser() {
		return loggedUser;
	}
	
}
