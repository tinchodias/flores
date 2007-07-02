package query.framework.results;



public class NullSearchResults implements SearchResults {

	private static NullSearchResults instance;

	public static NullSearchResults instance() {
		if (instance == null) {
			instance = new NullSearchResults();
		}
		return instance;
	}

	private NullSearchResults() {
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

	public int getRowCount() {
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

	public Object get(int row) {
		return null;
	}

}
