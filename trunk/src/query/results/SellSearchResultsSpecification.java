package query.results;


import message.MessageId;
import model.money.MoneyAmount;
import model.receipt.Sell;

import org.joda.time.ReadableInstant;

import query.framework.results.LazySearchResultsSpecification;

public class SellSearchResultsSpecification extends LazySearchResultsSpecification {

	public SellSearchResultsSpecification() {
		add(MessageId.date, ReadableInstant.class);
		add(MessageId.client);
		add(MessageId.paymentTotal, MoneyAmount.class);
		add(MessageId.costTotal, MoneyAmount.class);
		add(MessageId.sellTotal, MoneyAmount.class);
	}
	
	public Object value(Object object, int columnIndex) {
		Sell sell = (Sell) object;
		switch (columnIndex) {
		case 0:
			return sell.date();
		case 1:
			return sell.client();
		case 2:
			return sell.paymentTotal();
		case 3:
			return sell.costTotal();
		case 4:
			return sell.sellTotal();
		}
		return null;
	}

}
