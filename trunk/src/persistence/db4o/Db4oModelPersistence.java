package persistence.db4o;

import message.MessageIdentifier;
import persistence.Model;
import persistence.ModelPersistence;
import persistence.exception.MessageIdentifiedException;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Db4oModelPersistence extends ModelPersistence {

	private static final String FILENAME = "model.db4o";
	ObjectContainer container;
	
	public Db4oModelPersistence() {
		super();
		this.container = Db4o.openFile(FILENAME);
	}

	@Override
	public void save(Model model) {
		container.set(model);
	}

	@Override
	public Model load() throws MessageIdentifiedException {
		ObjectSet<Model> modelSet = container.get(new Model(null, null));
		
		if (modelSet.size() != 1) {
			throw new MessageIdentifiedException(MessageIdentifier.PERSISTENCE_INVALID_MODEL);
		}
		
		return modelSet.next();
	}
}
