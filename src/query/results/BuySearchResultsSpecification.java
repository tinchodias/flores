package query.results;


import message.MessageId;
import model.money.Pesos;
import model.receipt.Buy;

import org.joda.time.ReadableInstant;

import query.framework.results.LazySearchResultsSpecification;

public class BuySearchResultsSpecification extends LazySearchResultsSpecification<Buy> {

	public BuySearchResultsSpecification() {
		add(MessageId.date, ReadableInstant.class);
		add(MessageId.supplier);
		add(MessageId.paymentTotal, Pesos.class);
		add(MessageId.buyTotal, Pesos.class);
	}
	
	public Object value(Buy buy, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return buy.date();
		case 1:
			return buy.getSupplier();
		case 2:
			return buy.getPayment().total();
		case 3:
			return buy.specification().total();
		}
		return null;
	}

}
