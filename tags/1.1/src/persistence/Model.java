package persistence;

import security.Users;
import model.Store;

public class Model {
	
	private Store store;
	private Users users;
	
	public Model(Store store, Users users) {
		this.store = store;
		this.users = users;
	}

	public Store store() {
		return store;
	}

	public void store(Store store) {
		this.store = store;
	}
	
	public Users users() {
		return users;
	}

	public void users(Users users) {
		this.users = users;
	}
	
}
