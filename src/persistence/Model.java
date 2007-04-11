package persistence;

import model.Store;

public class Model {
	
	private Store store;
	
	public Model() {
		store = new Store();
	}

	public Model(Store store) {
		this.store = store;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
}
