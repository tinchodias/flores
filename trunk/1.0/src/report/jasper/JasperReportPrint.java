package report.jasper;

import net.sf.jasperreports.engine.JasperPrint;
import report.ReportPrint;

public class JasperReportPrint implements ReportPrint {

	private JasperPrint print;
	
	public JasperReportPrint(JasperPrint print) {
		this.print = print;
	}

	public JasperPrint getPrint() {
		return print;
	}
}
