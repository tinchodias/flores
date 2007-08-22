package ui.controller.action;

import message.MessageId;
import model.receipt.Sell;
import report.ReportFactory;
import report.ReportPrint;
import util.ValueHolder;

public class PrintSellReportAction implements Action, ValueHolder {

	private Sell sell;

	public void execute() {
		ReportPrint print = ReportFactory.instance().sellReport(sell);
		ReportFactory.instance().show(print);
	}

	public MessageId messageId() {
		return MessageId.print;
	}

	public Object getValue() {
		return sell;
	}

	public void setValue(Object value) {
		sell = (Sell) value;
	}

}
