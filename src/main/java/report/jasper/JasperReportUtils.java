package report.jasper;

import java.io.File;
import java.io.FileOutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
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
			throw new ReportPrintException(e);
		}
	}
	
	public void exportXls(ReportPrint print, String reportFileName) {
		try {
			JasperPrint jasperPrint = ((JasperReportPrint) print).getPrint();
			Object outputFile = new FileOutputStream(new File(reportFileName));
			
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputFile);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
			exporterXLS.exportReport();		
		} catch (Exception e) {
			throw new ReportPrintException(e);
		}
	}
	
}
