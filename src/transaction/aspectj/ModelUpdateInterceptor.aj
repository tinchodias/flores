package transaction.aspectj;

import persistence.ModelPersistence;

public aspect ModelUpdateInterceptor {

//	pointcut updateMethods() : 
//		!execution(* *.toString()) && 
//		!execution(public void *.hashCode()) && 
//		execution(public * model.*.*(..));

	pointcut modelUpdateMethods() : 
		(within(model.*) || within(model.*.*) || within(model.*.*.*)) && (
		execution(public * *.set*(..)) ||
		execution(public * *.apply*(..)) ||
		execution(public * *.notify*(..)) ||
		execution(public * *.add*(..)) ||
		execution(public * *.remove*(..)));
	
	after() returning : modelUpdateMethods() {
		System.out.println("Setting: " + thisJoinPoint.getThis());
		
		ModelPersistence.instance().transactionManager().objectUpdated(thisJoinPoint.getThis());
	}
	
}
