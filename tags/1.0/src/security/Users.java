package security;

import java.util.Map;

import model.util.CollectionFactory;

public class Users {
	private Map<String, User> users = CollectionFactory.newMap();

	public void add(User user) {
		users.put(user.getName(), user);
	}

	public User get(String name) {
		return users.get(name);
	}

	public void remove(User user) {
		users.remove(user.getName());
	}
	
	public boolean isValid(String name, String password) {
		User user = users.get(name);
		
		if (user != null) {
			if (user.getPasswordHash().equals(new PasswordHash(password))) {
				return true;
			}
		}
		return false;
	}

}
