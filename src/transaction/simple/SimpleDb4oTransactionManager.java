package transaction.simple;

import java.util.Collection;
import java.util.HashSet;

import transaction.Block;
import transaction.TransactionManager;

import com.db4o.ObjectContainer;


public class SimpleDb4oTransactionManager implements TransactionManager {

	private ObjectContainer objectContainer;
	private Collection updatedObjects = new HashSet();
	
	public SimpleDb4oTransactionManager(ObjectContainer objectContainer) {
		this.objectContainer = objectContainer;
	}

	public ObjectContainer getObjectContainer() {
		return objectContainer;
	}
	
	public void setObjectContainer(ObjectContainer objectContainer) {
		this.objectContainer = objectContainer;
	}

	public synchronized Object execute(Block block) {
		return block.executeBlock();
	}

	public synchronized void objectUpdated(Object o) {
		updatedObjects.add(o);
	}	

	public synchronized void commit() {
		System.out.println("Commit with " + updatedObjects.size() + " objects.");
		for (Object object : updatedObjects) {
			objectContainer.set(object);
		}
		updatedObjects.clear();
		objectContainer.commit();
	}

	public synchronized void rollback() {
		System.out.println("Rollback with " + updatedObjects.size() + " objects.");
		objectContainer.rollback();
		for (Object object : updatedObjects) {
			objectContainer.ext().refresh(object, 1);
		}
		updatedObjects.clear();
	}

}
