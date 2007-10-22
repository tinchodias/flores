package query.framework.results;

import message.MessageId;
import message.MessageRepository;


public abstract class LazySearchResults implements SearchResults {

	private LazySearchResultsSpecification spec;

	public LazySearchResults(LazySearchResultsSpecification spec) {
		this.spec = spec;
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		if (this.getRowCount() > 0) {
			return this.getValueAt(0, columnIndex).getClass();
		}
		return Object.class;
	}

	public int getColumnCount() {
		return spec.columnMessageIdentifiers().size();
	}

	public String getColumnName(int columnIndex) {
		MessageId messageId = spec.columnMessageIdentifiers().get(columnIndex);
		return MessageRepository.instance().get(messageId);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.spec.value(get(rowIndex), columnIndex);
	}

	public LazySearchResultsSpecification spec() {
		return spec;
	}

}
