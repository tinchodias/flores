package report;

import report.jasper.JasperReportUtils;

public abstract class ReportUtils {

	private static ReportUtils instance;

	public static ReportUtils instance() {
		if (instance == null) {
			instance = new JasperReportUtils();
		}
		return instance;
	}
	
	public abstract void show(ReportPrint print);

	public abstract void exportPdf(ReportPrint print, String reportFileName);
	
	public abstract void exportXls(ReportPrint print, String reportFileName);
	
}
