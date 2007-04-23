package ui.swing.util;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ui.component.TableModelUI;

public class TableModelAdapter implements TableModel {

	private final TableModelUI model;

	public TableModelAdapter(TableModelUI model) {
		this.model = model;
	}

	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
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
		// TODO Auto-generated method stub
		
	}

	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
