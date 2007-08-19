package query.criteria;

import org.joda.time.ReadableInterval;

import query.framework.criteria.Criteria;

public interface ExpenseSearchCriteria extends Criteria {
	
	public ReadableInterval getInterval();

}
