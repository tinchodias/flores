package transaction.aspectj;

import persistence.ModelPersistence;

public aspect TransactionInterceptor {

	pointcut executingTransaction() : execution(* transaction.TransactionManager.execute(..));
	
	after() returning : executingTransaction() {
		ModelPersistence.instance().transactionManager().commit();
	}

	after() throwing : executingTransaction() {
		ModelPersistence.instance().transactionManager().rollback();
	}
	
}
