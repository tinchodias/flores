package persistence;

import java.util.List;
import java.util.Map;

import persistence.db4o.Db4oModelPersistence;
import persistence.exception.MessageIdentifiedException;


public abstract class ModelPersistence {

	private static ModelPersistence instance;

	public static ModelPersistence instance() {
		if (instance == null) {
			instance = new Db4oModelPersistence();
		}
		return instance;
	}

	public abstract void open();

	public abstract void close();
	
	public abstract void save(Model model);

	public abstract Model load() throws MessageIdentifiedException;

	public abstract Model loadedModel();

	//TODO
	public abstract List newList();

	//TODO
	public abstract Map newMap();
	
}
