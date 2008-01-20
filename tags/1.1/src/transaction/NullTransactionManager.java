package transaction;

public class NullTransactionManager implements TransactionManager {

	public void commit() {
	}

	public void execute(Block block) {
		block.executeBlock();
	}

	public void objectUpdated(Object o) {
	}

	public void rollback() {
	}

}
