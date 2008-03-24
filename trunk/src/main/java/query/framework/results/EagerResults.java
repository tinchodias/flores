package query.framework.results;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;


public abstract class EagerResults implements Results {

	private List<List> rows;
	private List<String> columnNames;
	private List<Class<?>> columnClasses;

	public Class<?> getColumnClass(int columnIndex) {
		return columnClasses.get(columnIndex);
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public String getColumnName(int columnIndex) {
		return columnNames.get(columnIndex);
	}

	public String getColumnDescription(int columnIndex) {
		throw new NotImplementedException();
	}

	public int getRowCount() {
		return rows.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return rows.get(rowIndex).get(columnIndex);
	}

	protected List<Class<?>> getColumnClasses() {
		return columnClasses;
	}

	protected void setColumnClasses(List<Class<?>> columnClasses) {
		this.columnClasses = columnClasses;
	}

	protected List<String> getColumnNames() {
		return columnNames;
	}

	protected void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

	protected List<List> getRows() {
		return rows;
	}

	protected void setRows(List<List> rows) {
		this.rows = rows;
	}

}
