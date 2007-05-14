package ui.swing.util;

import java.util.Collection;
import java.util.HashSet;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import query.framework.results.NullResults;
import query.framework.results.Results;

public class TableModelAdapter implements TableModel {

	private Results model;
	private Collection<TableModelListener> listeners = new HashSet<TableModelListener>();

	public TableModelAdapter(Results model) {
		this.model = model;
	}

	public TableModelAdapter() {
		this(NullResults.instance());
	}

	public Class<?> getColumnClass(int columnIndex) {
		return model.getColumnClass(columnIndex);
	}

	public int getColumnCount() {
		return model.getColumnCount();
	}

	public String getColumnName(int columnIndex) {
		return model.getColumnName(columnIndex);
	}

	public int getRowCount() {
		return model.getRowCount();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return model.getValueAt(rowIndex, columnIndex);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

	public Results getResults() {
		return model;
	}
	
	public void setResults(Results results) {
		model = results;
		notifyTableChanged();
	}

	private void notifyTableChanged() {
		TableModelEvent tableModelEvent = new TableModelEvent(this, TableModelEvent.HEADER_ROW);
		for (TableModelListener listener : listeners) {
			listener.tableChanged(tableModelEvent);
		}
	}

}
