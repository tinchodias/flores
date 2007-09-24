package query.results;


import message.MessageId;
import model.debts.ClientDebtCancellation;
import model.money.MoneyAmount;

import org.joda.time.ReadableInstant;

import query.framework.results.LazySearchResultsSpecification;

public class ClientDebtCancellationSearchResultsSpecification extends LazySearchResultsSpecification {

	public ClientDebtCancellationSearchResultsSpecification() {
		add(MessageId.date, ReadableInstant.class);
		add(MessageId.client);
		add(MessageId.amount, MoneyAmount.class);
	}
	
	public Object value(Object object, int columnIndex) {
		ClientDebtCancellation cancellation = (ClientDebtCancellation) object;
		switch (columnIndex) {
		case 0:
			return cancellation.getDate();
		case 1:
			return cancellation.getClient().toString();
		case 2:
			return cancellation.getAmount();
		}
		return null;
	}

}
