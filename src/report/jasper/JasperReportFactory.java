package report.jasper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import message.MessageId;
import message.MessageRepository;
import message.SimplePropertiesIconRepository;
import model.receipt.Sell;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import query.framework.results.LazySearchResults;
import query.framework.results.SellItemsLazySearchResults;
import report.ReportFactory;
import report.ReportPrint;
import report.ReportPrintException;
import ui.view.swing.component.StandardDialog;

public class JasperReportFactory extends ReportFactory {

	public ReportPrint sellReport(Sell sell) {
		LazySearchResults results = new SellItemsLazySearchResults(sell.items());

		HashMap parameters = new HashMap();
		addLabel(parameters, MessageId.sell);
		addLabel(parameters, MessageId.article);
		addLabel(parameters, MessageId.count);
		addLabel(parameters, MessageId.unitPrice);
		addLabel(parameters, MessageId.client);
		addLabel(parameters, MessageId.clientDebt);
		addLabel(parameters, MessageId.paymentTotal);
		addLabel(parameters, MessageId.total);
		addString(parameters, MessageId.total, sell.sellTotal());
		addString(parameters, MessageId.paymentTotal, sell.paymentTotal());
		addString(parameters, MessageId.clientDebt, sell.clientDebt()); //TODO show total debt?
		addString(parameters, MessageId.date, sell.date());
		addString(parameters, MessageId.client, sell.client());
		
		return jasperReportPrintFor("Sell", results, parameters);
	}

	private void addString(Map parameters, MessageId messageId, Object object) {
		parameters.put(messageId.toString(), object.toString());
	}

	private void addLabel(Map parameters, MessageId messageId) {
		parameters.put(messageId.toString() + "Label", MessageRepository.instance().get(messageId));
	}

	private ReportPrint jasperReportPrintFor(String reportName, LazySearchResults results, HashMap parameters) {
		JasperPrint print;
		try {
			JasperReport report = reportFor(reportName);
			JRDataSource dataSource = new ResultsJRDataSourceAdapter(results);
			print = printFor(parameters, dataSource, report);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ReportPrintException(e); 
		}
		return new JasperReportPrint(print);
	}

	private JasperPrint printFor(HashMap parameters, JRDataSource dataSource, JasperReport report) throws JRException {
		return JasperFillManager.fillReport(report, parameters, dataSource);
	}

	private JasperReport reportFor(String reportName) throws JRException, IOException {
		URL url = SimplePropertiesIconRepository.class.getResource("/jasper/" + reportName + ".jrxml");
		return JasperCompileManager.compileReport(url.openStream());
	}

	public void show(ReportPrint print) {
		JasperPrint jasperPrint = ((JasperReportPrint) print).getPrint();
		
		JasperViewer viewer = new JasperViewer(jasperPrint);

		StandardDialog dialog = new StandardDialog(MessageId.print);
		dialog.getContentPane().add(viewer.getContentPane(), BorderLayout.CENTER);
		dialog.setPreferredSize(new Dimension(760, 480));
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		
		viewer.setFitWidthZoomRatio();
		dialog.setVisible(true);
		
		//FIXME close viewer!
	}

	public void exportPdf(ReportPrint print, String reportFileName) {
		JasperPrint jasperPrint = ((JasperReportPrint) print).getPrint();
		try {
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportFileName);
		} catch (JRException e) {
			e.printStackTrace();
			throw new ReportPrintException(e);
		}
	}
	
}