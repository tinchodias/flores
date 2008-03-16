package query.results;


import message.MessageId;
import model.cashBook.CashExtraction;
import query.framework.results.LazySearchResultsSpecification;

public class CashExtractionSearchResultsSpecification extends LazySearchResultsSpecification {

	public CashExtractionSearchResultsSpecification() {
		add(MessageId.date);
		add(MessageId.amount);
		add(MessageId.note);
	}
	
	public Object value(Object object, int columnIndex) {
		CashExtraction extraction = (CashExtraction) object;
		switch (columnIndex) {
		case 0:
			return extraction.getDate();
		case 1:
			return extraction.getAmount();
		case 2:
			return extraction.getNote();
		}
		return null;
	}

}
