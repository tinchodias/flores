package persistence.db4o;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import message.MessageId;
import model.receipt.Buy;
import persistence.Model;
import persistence.ModelPersistence;
import persistence.exception.MessageIdentifiedException;
import transaction.NullTransactionManager;
import transaction.TransactionManager;
import transaction.simple.SimpleDb4oTransactionManager;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.Configuration;
import com.db4o.config.ObjectClass;
import com.db4o.config.ObjectField;
import com.db4o.config.TSerializable;
import com.db4o.diagnostic.DiagnosticToConsole;

public class Db4oModelPersistence extends ModelPersistence {

	private static Db4oModelPersistence instance;

	public static Db4oModelPersistence instance() {
		if (instance == null) {
			instance = new Db4oModelPersistence();
		}
		return instance;
	}

	private String fileName = "model.db4o";
	private ObjectContainer container;
	private Model loadedModel;
	private TransactionManager transactionManager = new NullTransactionManager();
	
	public Db4oModelPersistence() {
		configureDb4o();
	}

	public void save(Model model) {
		container.set(model);
	}

	public Model load() {
		ObjectSet<Model> modelSet;
		
		try {
			modelSet = container.query(Model.class);
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
		container = Db4o.openFile(getFileName());
		//FIXME hardcoded!
		transactionManager = new SimpleDb4oTransactionManager(container);
		
//		//For NQO info
//		((ObjectContainerBase) container).getNativeQueryHandler().addListener(
//				new Db4oQueryExecutionListener() {
//					public void notifyQueryExecuted(NQOptimizationInfo info) {
//						System.err.println(info);
//					}
//				});
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

	private void configureDb4o() {
		Configuration configuration = Db4o.configure();
		
//		configuration.password("encrPass");
//		configuration.encrypt(true);
		
//		configuration.messageLevel(3);
		configuration.exceptionsOnNotStorable(true);
		configuration.diagnostic().addListener(new DiagnosticToConsole());
		
		//For simple activation
		configuration.activationDepth(Integer.MAX_VALUE);
		
		//For simple update
		ObjectClass oc = configuration.objectClass(Model.class);
		oc.cascadeOnUpdate(true);
		oc.updateDepth(Integer.MAX_VALUE);
		
		configureJodaTime();
		configureOptimization();
	}

	private void configureOptimization() {
		Db4o.configure().objectClass(Buy.class).indexed(true);
		Db4o.configure().objectClass(Buy.class).objectField("date").indexed(true);
		Db4o.configure().objectClass(org.joda.time.base.BaseDateTime.class).objectField("iMillis").indexed(true);
	}

	private void configureJodaTime() {
		//Note: this configuration was published in a db4o forum.
		
		Configuration config = Db4o.configure();
		
	    Class clazz = org.joda.time.base.BaseDateTime.class;
	    ObjectClass oc = config.objectClass(clazz);
	    oc.updateDepth(0);
	    oc.maximumActivationDepth(Integer.MAX_VALUE);
	    oc.minimumActivationDepth(Integer.MAX_VALUE);
	    oc.cascadeOnActivate(true);
	    oc.cascadeOnDelete(false);
	    oc.cascadeOnUpdate(false);
	    
	    ObjectField of = oc.objectField("iMillis");
	    of.indexed(true); 
	    
	    of = oc.objectField("iChronology");
	    of.indexed(false);
	    of.queryEvaluation(false);
	    of.cascadeOnDelete(false);
	        
	    clazz = org.joda.time.DateTime.class; 
	    oc = config.objectClass(clazz);
	    oc.updateDepth(0);
	    oc.maximumActivationDepth(Integer.MAX_VALUE);
	    oc.minimumActivationDepth(Integer.MAX_VALUE);
	    oc.cascadeOnActivate(true);
	    oc.cascadeOnDelete(false);
	    oc.cascadeOnUpdate(false);        
	        
	    clazz = org.joda.time.chrono.ISOChronology.class;
	    oc = config.objectClass(clazz);
	    oc.updateDepth(0);
	    oc.translate(new TSerializable());
	    oc.maximumActivationDepth(Integer.MAX_VALUE);
	    oc.minimumActivationDepth(Integer.MAX_VALUE);
	    oc.cascadeOnActivate(true);
	    oc.cascadeOnDelete(false);
	    oc.cascadeOnUpdate(false);
	    
	    clazz = org.joda.time.chrono.ZonedChronology.class;
	    oc = config.objectClass(clazz);
	    oc.updateDepth(0);
	    oc.translate(new TSerializable());
	    oc.maximumActivationDepth(Integer.MAX_VALUE);
	    oc.minimumActivationDepth(Integer.MAX_VALUE);
	    oc.cascadeOnActivate(true);
	    oc.cascadeOnDelete(false);
	    oc.cascadeOnUpdate(false);
	    
	    clazz = org.joda.time.chrono.GregorianChronology.class;
	    oc = config.objectClass(clazz);
	    oc.updateDepth(0);
	    oc.translate(new TSerializable());
	    oc.maximumActivationDepth(Integer.MAX_VALUE);
	    oc.minimumActivationDepth(Integer.MAX_VALUE);
	    oc.cascadeOnActivate(true);
	    oc.cascadeOnDelete(false);
	    oc.cascadeOnUpdate(false);
	    
	    clazz = org.joda.time.tz.CachedDateTimeZone.class;
	    oc = config.objectClass(clazz);   
	    oc.translate(new TSerializable());		
	}
	
	public List newList() {
		//FIXME!
		if (container!= null) {
			return container.ext().collections().newLinkedList();
		} else {
			return new ArrayList();
		}
	}
	
	public Map newMap() {
		//FIXME!
		if (container != null) {
			return container.ext().collections().newHashMap(0);
		} else {
			return new HashMap();
		}
	}

	public Map newIdentityMap() {
		//FIXME!
		if (container != null) {
			return container.ext().collections().newIdentityHashMap(0);
		} else {
			return new HashMap();
		}
	}

	public TransactionManager transactionManager() {
		return transactionManager;
	}

	/**
	 * TODO remove!
	 */
	public ObjectContainer container() {
		return container; 
		
	}
}
