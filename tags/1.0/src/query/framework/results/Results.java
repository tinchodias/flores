package query.framework.results;

public interface Results {

	int getColumnCount();

	String getColumnName(int columnIndex);

	int getRowCount();

	Object getValueAt(int rowIndex, int columnIndex);

	Class<?> getColumnClass(int columnIndex);

}
