package query.framework.results;

import java.util.ArrayList;
import java.util.List;

import message.MessageId;
import message.MessageRepository;


public class LazySearchResults implements SearchResults {

	private List sources = new ArrayList();
	private LazySearchResultsSpecification spec;

	public LazySearchResults(LazySearchResultsSpecification spec) {
		this.spec = spec;
	}
	
	public void add(Object object) {
		this.sources.add(object);
	}

	public boolean remove(Object object) {
		return this.sources.remove(object);
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
		return MessageRepository.instance().get(messageIdentifier);
	}

	public int getRowCount() {
		return sources.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.spec.value(sources.get(rowIndex), columnIndex);
	}

	public Object get(int index) {
		return sources.get(index);
	}

}
