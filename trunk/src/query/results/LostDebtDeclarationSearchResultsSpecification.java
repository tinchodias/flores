package query.results;


import message.MessageId;
import model.debts.LostDebtDeclaration;
import query.framework.results.LazySearchResultsSpecification;

public class LostDebtDeclarationSearchResultsSpecification extends LazySearchResultsSpecification {

	public LostDebtDeclarationSearchResultsSpecification() {
		add(MessageId.date);
		add(MessageId.client);
		add(MessageId.amount);
	}
	
	public Object value(Object object, int columnIndex) {
		LostDebtDeclaration declaration = (LostDebtDeclaration) object;
		switch (columnIndex) {
		case 0:
			return declaration.getDate();
		case 1:
			return declaration.getClient();
		case 2:
			return declaration.getAmount();
		}
		return null;
	}

}
