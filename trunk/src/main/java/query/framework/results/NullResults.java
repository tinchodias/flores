package query.framework.results;



public class NullResults implements Results {

	private static Results instance;

	public static Results instance() {
		if (instance == null) {
			instance = new NullResults();
		}
		return instance;
	}

	private NullResults() {
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		return Object.class;
	}

	public int getColumnCount() {
		return 0;
	}

	public String getColumnName(int columnIndex) {
		return "";
	}

	public String getColumnDescription(int columnIndex) {
		return "";
	}
	
	public int getRowCount() {
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}
