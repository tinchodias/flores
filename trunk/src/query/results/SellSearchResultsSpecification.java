package query.results;


import message.MessageId;
import model.money.Pesos;
import model.receipt.Sell;

import org.joda.time.ReadableInstant;

import query.framework.results.LazySearchResultsSpecification;

public class SellSearchResultsSpecification extends LazySearchResultsSpecification {

	public SellSearchResultsSpecification() {
		add(MessageId.date, ReadableInstant.class);
		add(MessageId.client);
		add(MessageId.paymentTotal, Pesos.class);
		add(MessageId.costTotal, Pesos.class);
		add(MessageId.sellTotal, Pesos.class);
	}
	
	public Object value(Object object, int columnIndex) {
		Sell sell = (Sell) object;
		switch (columnIndex) {
		case 0:
			return sell.date();
		case 1:
			return sell.client();
		case 2:
			return sell.payment().total();
		case 3:
			return sell.items().costTotal();
		case 4:
			return sell.items().sellTotal();
		}
		return null;
	}

}
