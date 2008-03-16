package persistence.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import persistence.Model;
import persistence.ModelPersistence;
import transaction.NullTransactionManager;
import transaction.TransactionManager;

public class ModelPersistenceMock extends ModelPersistence {

	private Model loadedModel;
	private TransactionManager transactionManager;

	public ModelPersistenceMock(Model model) {
		this.loadedModel = model;
		this.transactionManager = new NullTransactionManager();
	}

	@Override
	public Model loadedModel() {
		return loadedModel;
	}

	@Override
	public Map newIdentityMap() {
		return new HashMap();
	}

	@Override
	public List newList() {
		return new ArrayList();
	}

	@Override
	public Map newMap() {
		return new HashMap();
	}

	@Override
	public void open() {
	}

	@Override
	public void save(Model model) {
	}

	@Override
	public void close() {
	}

	@Override
	public Model load() {
		return null;
	}

	@Override
	public TransactionManager transactionManager() {
		return transactionManager;
	}

}
