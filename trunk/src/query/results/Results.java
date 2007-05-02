package query.results;

public abstract class Results {

	public abstract int getColumnCount();

	public abstract String getColumnName(int columnIndex);

	public abstract int getRowCount();

	public abstract Object getValueAt(int rowIndex, int columnIndex);

	public abstract Class<?> getColumnClass(int columnIndex);

}
