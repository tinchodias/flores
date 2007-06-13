package query.criteria;

import org.joda.time.ReadableInterval;

import query.framework.criteria.Criteria;

public interface StockDropOutSearchCriteria extends Criteria {

	public ReadableInterval getInterval();

}
