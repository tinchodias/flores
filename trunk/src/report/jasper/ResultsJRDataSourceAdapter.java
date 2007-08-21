package report.jasper;

import java.util.List;

import message.MessageId;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import query.framework.results.LazySearchResults;

public class ResultsJRDataSourceAdapter implements JRDataSource {

	private final LazySearchResults results;
	private int currentRowIndex = -1; 

	public ResultsJRDataSourceAdapter(LazySearchResults results) {
		this.results = results;
	}

	public Object getFieldValue(JRField field) throws JRException {
		List<MessageId> columnIds = results.spec().columnMessageIdentifiers();
		for (int i = 0; i < columnIds.size(); i++) {
			String column = columnIds.get(i).toString();
			if (field.getName().equals(column)) {
				return results.getValueAt(currentRowIndex, i).toString(); //TODO always toString()?
			}
		}
		throw new Error("Invalid column: " + field.getName());
	}

	public boolean next() throws JRException {
		if (currentRowIndex < results.getRowCount() - 1) {
			currentRowIndex++;
			return true;
		} else {
			return false;
		}
	}

}
