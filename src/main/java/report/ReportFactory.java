package report;

import model.receipt.Sell;
import query.framework.results.LazySearchResults;
import report.jasper.JasperReportFactory;

public abstract class ReportFactory {

	private static ReportFactory instance;

	public static ReportFactory instance() {
		if (instance == null) {
			instance = new JasperReportFactory();
		}
		return instance;
	}
	
	public abstract ReportPrint sellReportPrint(Sell sell);
	
	public abstract ReportPrint standardListReportPrint(LazySearchResults results, String title);
	
}
