package query.framework.results;


import java.util.ArrayList;
import java.util.List;

import message.MessageId;

public abstract class LazySearchResultsSpecification<T> {

	private List<MessageId> columnMessageIdentifiers = new ArrayList<MessageId>();
	private List<Class<?>> columnClasses = new ArrayList<Class<?>>();

	public abstract Object value(T object, int columnIndex);

	public List<Class<?>> columnClasses() {
		return columnClasses;
	}

	public List<MessageId> columnMessageIdentifiers() {
		return columnMessageIdentifiers;
	}

	public void add(MessageId messageIdentifier, Class<?> columnClass) {
		columnMessageIdentifiers.add(messageIdentifier);
		columnClasses.add(columnClass);
	}

	public void add(MessageId messageIdentifier) {
		this.add(messageIdentifier, Object.class);
	}

}
