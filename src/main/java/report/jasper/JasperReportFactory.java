package report.jasper;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import message.MessageId;
import message.MessageRepository;
import message.SimplePropertiesIconRepository;
import model.money.MoneyAmount;
import model.receipt.Sell;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignElement;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.joda.time.ReadableDateTime;
import org.joda.time.format.DateTimeFormat;

import persistence.ModelPersistence;
import query.framework.results.LazySearchResults;
import query.framework.results.SearchResults;
import query.framework.results.SellItemsLazySearchResults;
import report.ReportFactory;
import report.ReportPrint;
import report.ReportPrintException;

public class JasperReportFactory extends ReportFactory {

	public ReportPrint sellReportPrint(Sell sell) {
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
		MoneyAmount debt = ModelPersistence.instance().loadedModel().store().debts().debtOf(sell.client());
		addString(parameters, MessageId.clientDebt, debt); //TODO show a snapshot?
		addString(parameters, MessageId.date, sell.date());
		addString(parameters, MessageId.client, sell.client());
		
		return reportPrintFor(reportFor("Sell"), results, parameters);
	}

	private static void addString(Map parameters, MessageId messageId, ReadableDateTime date) {
		parameters.put(messageId.toString(), DateTimeFormat.shortDateTime().print(date));
	}

	private static void addString(Map parameters, MessageId messageId, Object object) {
		parameters.put(messageId.toString(), object.toString());
	}

	private static void addLabel(Map parameters, MessageId messageId) {
		parameters.put(messageId.toString() + "Label", MessageRepository.instance().get(messageId));
	}

	private static ReportPrint reportPrintFor(JasperReport report, SearchResults results, HashMap parameters) {
		JasperPrint print;
		try {
			JRDataSource dataSource = new ResultsJRDataSourceAdapter(results);
			print = JasperFillManager.fillReport(report, parameters, dataSource);
		} catch (Exception e) {
			throw new ReportPrintException(e); 
		}
		return new JasperReportPrint(print);
	}

	private static JasperReport reportFor(String reportName) {
		try {
			return JasperCompileManager.compileReport(urlFor(reportName).openStream());
		} catch (Exception e) {
			throw new ReportPrintException(e); 
		}
	}

	private static URL urlFor(String reportName) {
		return SimplePropertiesIconRepository.class.getResource("/jasper/" + reportName + ".jrxml");
	}

	public ReportPrint standardListReportPrint(SearchResults results, String title) {
		return reportPrintFor(standardListReport(results, title), results, new HashMap());
	}

	private JasperReport standardListReport(SearchResults results, String title) {
		try {
			JasperDesign design = (JasperDesign) JRXmlLoader.load(urlFor("StandardList").openStream());
			
			JRDesignStaticText pageTitle = (JRDesignStaticText) design.getPageHeader().getElementByKey("staticText-2");
			pageTitle.setText(title);
			
			JRDesignBand headerBand = (JRDesignBand) design.getColumnHeader();
			JRDesignBand detailBand = (JRDesignBand) design.getDetail();
			JRDesignElement templateHeader = (JRDesignElement) headerBand.getElementByKey("staticText-1");
			JRDesignElement templateField = (JRDesignElement) detailBand.getElementByKey("textField-1");
			
			for (int i = 0; i < results.getColumnCount(); i++) {
				int cloneWidth = templateHeader.getWidth() / results.getColumnCount();
				int cloneX = i * cloneWidth;
				String columnName = results.getColumnName(i);
				String columnDescription = results.getColumnDescription(i);
				
				design.addField(columnField(columnName));
				headerBand.addElement(columnHeaderElement(templateHeader, cloneWidth, i, cloneX, columnDescription));
				detailBand.addElement(columnValueElement(templateField, cloneWidth, i, cloneX, columnName));
			}

			//Removes template stuff
			headerBand.removeElement(templateHeader);
			detailBand.removeElement(templateField);
			
			return JasperCompileManager.compileReport(design);
		} catch (Exception e) {
			throw new ReportPrintException(e); 
		}
	}

	private JRDesignElement columnValueElement(JRDesignElement templateField,
			int cloneWidth, int i, int cloneX, String columnName) {
		JRDesignTextField cloneColumnValue = (JRDesignTextField) templateField.clone();
		cloneColumnValue.setX(cloneX);
		cloneColumnValue.setWidth(cloneWidth);
		cloneColumnValue.setKey("columnValue" + i);
		JRDesignExpression expression = new JRDesignExpression();
		expression.setValueClass(String.class);
		expression.setText("$F{" + columnName + "}");
		cloneColumnValue.setExpression(expression);
		return cloneColumnValue;
	}

	private JRDesignElement columnHeaderElement(JRDesignElement templateHeader,
			int cloneWidth, int i, int cloneX, String columnDescription) {
		JRDesignStaticText cloneColumnHeader = (JRDesignStaticText) templateHeader.clone();
		cloneColumnHeader.setX(cloneX);
		cloneColumnHeader.setWidth(cloneWidth);
		cloneColumnHeader.setKey("columnHeader" + i);
		cloneColumnHeader.setText(columnDescription);
		return cloneColumnHeader;
	}

	private JRDesignField columnField(String columnName) {
		JRDesignField field = new JRDesignField();
		field.setName(columnName);
		field.setValueClass(String.class);
		return field;
	}
	
}
