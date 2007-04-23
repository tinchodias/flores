package ui.component;

public interface TableModelUI {

	int getColumnCount();

	String getColumnName(int columnIndex);

	int getRowCount();

	Object getValueAt(int rowIndex, int columnIndex);

}
