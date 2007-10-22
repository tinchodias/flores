package query.framework.results;


import java.util.ArrayList;
import java.util.List;

import message.MessageId;

public abstract class LazySearchResultsSpecification {

	private List<MessageId> columnMessageIdentifiers = new ArrayList<MessageId>();

	public abstract Object value(Object object, int columnIndex);

	public List<MessageId> columnMessageIdentifiers() {
		return columnMessageIdentifiers;
	}

	public void add(MessageId messageIdentifier) {
		columnMessageIdentifiers.add(messageIdentifier);
	}

}
