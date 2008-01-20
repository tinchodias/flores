package query;

public aspect QueryStatisticsLogging {

	pointcut queryExecution() : call(* query.framework.query.Query.results());

	Object around() : queryExecution() {
		long t1 = System.currentTimeMillis();
		Object results = proceed();
		long t2 = System.currentTimeMillis();
		System.out.println("Query time: " + (t2 - t1) + "ms");
		return results;
	}
}
