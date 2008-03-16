package transaction;

public interface TransactionManager {

	void execute(Block block);
	
	void objectUpdated(Object o);

	void commit();

	void rollback();
	
}
