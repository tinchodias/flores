package persistence;

import model.Store;
import model.StoreFactory;
import security.Users;
import security.UsersFactory;

public class ModelFactory {

	public static Model makeSimpleModel() {
		Store store = StoreFactory.makeSimpleStore();
		Users users = UsersFactory.makeSimpleUsers();
		return new Model(store, users);
	}

	public static Model makeStressModel() {
		Store store = StoreFactory.makeStressStore();
		Users users = UsersFactory.makeSimpleUsers();
		return new Model(store, users);
	}
	
}
