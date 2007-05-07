package query.framework.results;


import java.util.ArrayList;
import java.util.List;

import message.MessageIdentifier;

public abstract class LazySearchResultsSpecification<T> {

	private List<MessageIdentifier> columnMessageIdentifiers = new ArrayList<MessageIdentifier>();
	private List<Class<?>> columnClasses = new ArrayList<Class<?>>();

	public abstract Object value(T object, int columnIndex);

	public List<Class<?>> columnClasses() {
		return columnClasses;
	}

	public List<MessageIdentifier> columnMessageIdentifiers() {
		return columnMessageIdentifiers;
	}

	public void add(MessageIdentifier messageIdentifier, Class<?> columnClass) {
		columnMessageIdentifiers.add(messageIdentifier);
		columnClasses.add(columnClass);
	}

	public void add(MessageIdentifier messageIdentifier) {
		this.add(messageIdentifier, Object.class);
	}

}
