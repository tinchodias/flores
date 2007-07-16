package transaction;

import transaction.spring.SpringTransactionManager;

public abstract class TransactionManager {

	private static TransactionManager instance;

	TransactionManager instance() {
		if (instance == null) {
			instance = new SpringTransactionManager();
		}
		return instance;
	}
	
	public abstract Object execute(Block block);
	
}
