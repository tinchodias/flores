package persistence;

import model.Store;
import model.StoreFixture;
import security.Users;
import security.UsersFactory;

public class ModelFactory {

	public static Model makeSimpleModel() {
		Store store = StoreFixture.simpleStore();
		Users users = UsersFactory.makeSimpleUsers();
		return new Model(store, users);
	}

	public static Model makeStressModel() {
		Store store = StoreFixture.stressStore();
		Users users = UsersFactory.makeSimpleUsers();
		return new Model(store, users);
	}
	
}
