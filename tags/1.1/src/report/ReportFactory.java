package report;

import model.receipt.Sell;
import report.jasper.JasperReportFactory;

public abstract class ReportFactory {

	private static ReportFactory instance;

	public static ReportFactory instance() {
		if (instance == null) {
			instance = new JasperReportFactory();
		}
		return instance;
	}
	
	public abstract ReportPrint sellReport(Sell sell);
	
	public abstract void show(ReportPrint print);

	public abstract void exportPdf(ReportPrint print, String reportFileName);
	
}
