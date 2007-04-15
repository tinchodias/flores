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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
}
