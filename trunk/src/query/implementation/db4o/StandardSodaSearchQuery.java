package query.implementation.db4o;

import org.joda.time.ReadableInterval;

import persistence.db4o.Db4oModelPersistence;
import query.framework.criteria.Criteria;
import query.framework.query.SearchQuery;
import query.framework.results.Db4oObjectSetSearchResults;
import query.framework.results.LazySearchResultsSpecification;
import query.framework.results.SearchResults;

import com.db4o.query.Query;

public abstract class StandardSodaSearchQuery<GenericCriteria extends Criteria> implements SearchQuery {

	private GenericCriteria criteria;

	public void setCriteria(Criteria criteria) {
		this.criteria = (GenericCriteria) criteria;
	}

	public SearchResults results() {
		return new Db4oObjectSetSearchResults(resultsSpecification(), query().execute());
	}

	protected GenericCriteria criteria() {
		return criteria;
	}

	protected abstract Query query();

	protected abstract LazySearchResultsSpecification resultsSpecification();

	protected static final Query queryFor(Class clazz) {
		Query query = Db4oModelPersistence.instance().container().query();
		query.constrain(clazz);
		return query;
	}

	protected static final Query constrainInterval(Query query,
			ReadableInterval interval) {
		Query iMillisField = query.descend("date").descend("iMillis");
		iMillisField.constrain(interval.getStartMillis()).greater().or(iMillisField.constrain(interval.getStartMillis()).equal());
		iMillisField.constrain(interval.getEndMillis()).smaller();
		iMillisField.orderDescending();
		return query;
	}

	// protected ObjectSet nativeQuery(final ReadableInterval interval) {
	// Predicate<Buy> predicate = new Predicate<Buy>() {
	// public boolean match(Buy buy) {
	// // return criteria.getInterval().contains(buy.date());
	// return interval.getStartMillis() <= buy.date().getMillis()
	// && interval.getEndMillis() > buy.date().getMillis();
	// }
	// };
	// return Db4oModelPersistence.instance().container().query(predicate);
	// }

}
