package persistence.db4o;

import message.MessageId;
import persistence.Model;
import persistence.ModelPersistence;
import persistence.exception.MessageIdentifiedException;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.Configuration;
import com.db4o.ext.DatabaseFileLockedException;

public class Db4oModelPersistence extends ModelPersistence {

	private String fileName = "model.db4o";
	private ObjectContainer container;
	private Model loadedModel;
	
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
//		configuration.diagnostic().addListener(new DiagnosticToConsole());		
	}

	public void save(Model model) {
		container.set(model);
	}

	public Model load() throws MessageIdentifiedException {
		ObjectSet<Model> modelSet;
		
		try {
			modelSet = container.get(new Model(null, null));
		} catch (Exception e) {
			throw new MessageIdentifiedException(MessageId.persistenceInvalidState);
		}
		
		if (modelSet.size() != 1) {
			throw new MessageIdentifiedException(MessageId.persistenceInvalidModel);
		}
		
		loadedModel = modelSet.next();
		return loadedModel;
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
		this.loadedModel = null;
	}
	
	public Model loadedModel() {
		return loadedModel;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
