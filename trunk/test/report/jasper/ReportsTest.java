package report.jasper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import message.MessageId;
import message.SimplePropertiesIconRepository;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import query.framework.results.LazySearchResults;
import query.util.ResultsFixture;

public class ReportsTest extends TestCase {

	public void testSimpleSummaryReport() throws IOException, Exception {
		HashMap parameters = new HashMap();
		parameters.put("aStringParameter", "aStringValue");
		parameters.put("aDoubleParameter", new Double(1.45));		
		
		LazySearchResults results = ResultsFixture.resultsMock(new ArrayList(), 0);
		
		testReport(results, parameters, "SimpleSummaryReport");
	}

	public void testSimpleDetailReport() throws IOException, Exception {
		HashMap parameters = new HashMap();
		
		List<MessageId> columnNames = new ArrayList();
		columnNames.add(MessageId.client);
		columnNames.add(MessageId.city);
		columnNames.add(MessageId.province);
		LazySearchResults results = ResultsFixture.resultsMock(columnNames, 70);
		
		testReport(results, parameters, "SimpleDetailReport");
	}
	
	private void testReport(LazySearchResults results, Map parameters, String reportName) throws Exception, IOException {
		ResultsJRDataSourceAdapter dataSource = new ResultsJRDataSourceAdapter(results);

		URL url = SimplePropertiesIconRepository.class.getResource("/jasper/" + reportName + ".jrxml");
		JasperReport report = JasperCompileManager.compileReport(url.openStream());

		JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
				JasperExportManager.exportReportToPdfFile(print, "C:\\" + reportName + ".pdf");
//			JasperExportManager.exportReportToPdfStream(print, System.out);
//			JasperViewer.viewReport(print);
	}
	
}
