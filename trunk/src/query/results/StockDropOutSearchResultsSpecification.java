package query.results;


import org.joda.time.ReadableInstant;

import message.MessageId;
import model.stock.StockDropOut;
import query.framework.results.LazySearchResultsSpecification;

public class StockDropOutSearchResultsSpecification extends
		LazySearchResultsSpecification<StockDropOut> {

	public StockDropOutSearchResultsSpecification() {
		add(MessageId.article);
		add(MessageId.count, Double.class);
		add(MessageId.date, ReadableInstant.class);
	}
	
	public Object value(StockDropOut dropOut, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return dropOut.getArticle();
		case 1:
			return dropOut.getCount();
		case 2:
			return dropOut.getDate();
		}
		return null;
	}

}
