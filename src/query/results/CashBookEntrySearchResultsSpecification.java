package query.results;


import message.MessageId;
import model.cashBook.CashBookEntry;
import model.money.MoneyAmount;

import org.joda.time.ReadableInstant;

import query.framework.results.LazySearchResultsSpecification;

public class CashBookEntrySearchResultsSpecification extends LazySearchResultsSpecification {

	public CashBookEntrySearchResultsSpecification() {
		add(MessageId.date, ReadableInstant.class);
		add(MessageId.amount, MoneyAmount.class);
		add(MessageId.reason, CashBookEntry.class);
	}
	
	public Object value(Object object, int columnIndex) {
		CashBookEntry entry = (CashBookEntry) object;
		switch (columnIndex) {
		case 0:
			return entry.getDate();
		case 1:
			return entry.getAmount();
		case 2:
			return entry;
		}
		return null;
	}
}
