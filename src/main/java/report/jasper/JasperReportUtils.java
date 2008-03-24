package report.jasper;

import java.io.File;
import java.io.FileOutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.view.JasperViewer;
import report.ReportPrint;
import report.ReportPrintException;
import report.ReportUtils;

public class JasperReportUtils extends ReportUtils {

	public void show(ReportPrint print) {
		JasperViewer.viewReport(((JasperReportPrint) print).getPrint(), false);
	}

	public void exportPdf(ReportPrint print, String reportFileName) {
		try {
			JasperExportManager.exportReportToPdfFile(((JasperReportPrint) print).getPrint(), reportFileName);
		} catch (JRException e) {
			e.printStackTrace();
			throw new ReportPrintException(e);
		}
	}
	
	public void exportXls(ReportPrint print, String reportFileName) {
		try {
			Object outputfile = new FileOutputStream(new File(reportFileName));
			
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, ((JasperReportPrint) print).getPrint());
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputfile);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//			exporterXLS.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporterXLS.exportReport();		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ReportPrintException(e);
		}
	}
	
}
