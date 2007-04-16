package persistence.db4o;

import message.MessageIdentifier;
import persistence.Model;
import persistence.ModelPersistence;
import persistence.exception.MessageIdentifiedException;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.Configuration;
import com.db4o.diagnostic.DiagnosticToConsole;
import com.db4o.ext.DatabaseFileLockedException;

public class Db4oModelPersistence extends ModelPersistence {

	private String fileName = "testModel.db4o";
	private ObjectContainer container;
	
	public Db4oModelPersistence() {
		super();
		configureDb4o();
	}

	private void configureDb4o() {
		Configuration configuration = Db4o.configure();
		
//		configuration.password("encrPass");
//		configuration.encrypt(true);
		
		configuration.messageLevel(3);
		configuration.exceptionsOnNotStorable(true);
		configuration.diagnostic().addListener(new DiagnosticToConsole());		
	}

	public void save(Model model) {
		container.set(model);
	}

	public Model load() throws MessageIdentifiedException {
		ObjectSet<Model> modelSet = container.get(new Model(null, null));
		
		if (modelSet.size() != 1) {
			throw new MessageIdentifiedException(MessageIdentifier.PERSISTENCE_INVALID_MODEL);
		}
		
		return modelSet.next();
	}

	public void open() {
		try {
			this.container = Db4o.openFile(getFileName());
		} catch (DatabaseFileLockedException e) {
			throw e;
		}
	}

	public void close() {
		//TODO verificar que close devuelva true
		this.container.close();
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
