package query.results;


import message.MessageId;
import model.money.Pesos;
import model.receipt.Buy;

import org.joda.time.ReadableInstant;

import query.framework.results.LazySearchResultsSpecification;

public class BuySearchResultsSpecification extends LazySearchResultsSpecification {

	public BuySearchResultsSpecification() {
		add(MessageId.date, ReadableInstant.class);
		add(MessageId.supplier);
		add(MessageId.paymentTotal, Pesos.class);
		add(MessageId.total, Pesos.class);
	}
	
	public Object value(Object object, int columnIndex) {
		Buy buy = (Buy) object;
		switch (columnIndex) {
		case 0:
			return buy.date();
		case 1:
			return buy.supplier();
		case 2:
			return buy.paymentTotal();
		case 3:
			return buy.buyTotal();
		}
		return null;
	}

}
