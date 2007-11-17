package query.criteria;

import org.joda.time.ReadableInterval;

import query.framework.criteria.Criteria;

public interface IntervalSearchCriteria extends Criteria {
	
	ReadableInterval getInterval();

}
