package transaction.aspectj;

import persistence.ModelPersistence;

public aspect ModelUpdateInterceptor {

	pointcut modelUpdateMethods() : 
		(within(model.*) || within(model.*.*) || within(model.*.*.*)) && (
		execution(public * *.set*(..)) ||
		execution(public * *.apply*(..)) ||
		execution(public * *.notify*(..)) ||
		execution(public * *.add*(..)) ||
		execution(public * *.remove*(..))) ||
		execution(public * *.adjustTotal*(..));
	
	after() returning : modelUpdateMethods() {
		System.out.println("objectUpdated: " + thisJoinPoint.getThis());
		
		ModelPersistence.instance().transactionManager().objectUpdated(thisJoinPoint.getThis());
	}
	
}
