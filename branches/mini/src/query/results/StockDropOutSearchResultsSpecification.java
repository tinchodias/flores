package query.results;


import org.joda.time.ReadableInstant;

import message.MessageId;
import model.stock.StockDropOut;
import query.framework.results.LazySearchResultsSpecification;

public class StockDropOutSearchResultsSpecification extends LazySearchResultsSpecification {

	public StockDropOutSearchResultsSpecification() {
		add(MessageId.date, ReadableInstant.class);
		add(MessageId.article);
		add(MessageId.count, Double.class);
	}
	
	public Object value(Object object, int columnIndex) {
		StockDropOut dropOut = (StockDropOut) object;
		switch (columnIndex) {
		case 0:
			return dropOut.getDate();
		case 1:
			return dropOut.getArticle();
		case 2:
			return dropOut.getCount();
		}
		return null;
	}

}