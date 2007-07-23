package transaction;

public class NullTransactionManager implements TransactionManager {

	public void commit() {
	}

	public Object execute(Block block) {
		return block.executeBlock();
	}

	public void objectUpdated(Object o) {
	}

	public void rollback() {
	}

}
