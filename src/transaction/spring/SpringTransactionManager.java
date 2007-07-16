package transaction.spring;

import transaction.Block;
import transaction.TransactionManager;

public class SpringTransactionManager extends TransactionManager {

	public Object execute(Block block) {
		return block.executeBlock();
	}

}
