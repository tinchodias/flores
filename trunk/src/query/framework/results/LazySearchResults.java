package query.framework.results;

import java.util.ArrayList;
import java.util.List;


import message.MessageId;
import message.MessageRepository;


public class LazySearchResults<T> implements SearchResults<T> {

	private List<T> sources = new ArrayList<T>();
	private LazySearchResultsSpecification<T> spec;

	public LazySearchResults(LazySearchResultsSpecification<T> spec) {
		this.spec = spec;
	}
	
	public void add(T object) {
		this.sources.add(object);
	}

	public Class<?> getColumnClass(int columnIndex) {
		return spec.columnClasses().get(columnIndex);
	}

	public int getColumnCount() {
		return spec.columnClasses().size();
	}

	public String getColumnName(int columnIndex) {
		MessageId messageIdentifier = 
			spec.columnMessageIdentifiers().get(columnIndex);
		return MessageRepository.instance().messageFor(messageIdentifier);
	}

	public int getRowCount() {
		return sources.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.spec.value(sources.get(rowIndex), columnIndex);
	}

	public T getFoundObject(int rowIndex) {
		return sources.get(rowIndex);
	}

}
