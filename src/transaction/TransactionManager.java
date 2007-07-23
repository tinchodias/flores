package transaction;

public interface TransactionManager {

	Object execute(Block block);
	
	void objectUpdated(Object o);

	void commit();

	void rollback();
	
}
