package query.util;

import java.util.List;

import message.MessageId;

import query.framework.results.DefaultLazySearchResults;
import query.framework.results.LazySearchResults;
import query.framework.results.LazySearchResultsSpecification;
import query.framework.results.NullResults;
import query.framework.results.Results;

public class ResultsFixture {

	public static Results nullResults() {
		return NullResults.instance();
	}

	public static LazySearchResults resultsMock(List<MessageId> columnNames, int rowCount) {
		LazySearchResultsSpecification specification = new LazySearchResultsSpecificationMock(columnNames);
		DefaultLazySearchResults results = new DefaultLazySearchResults(specification);
		for (int i = 0; i < rowCount; i++) {
			results.add(new Integer(i));
		}
		return results;
	}

	public static class LazySearchResultsSpecificationMock extends LazySearchResultsSpecification {

		public LazySearchResultsSpecificationMock(List<MessageId> columnNames) {
			for (MessageId id : columnNames) {
				add(id);
			}
		}
		
		public Object value(Object object, int columnIndex) {
			Integer i = (Integer) object;
			return "value " + i + " " + columnIndex;
		}
	}
}
