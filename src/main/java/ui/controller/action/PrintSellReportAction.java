package ui.controller.action;

import message.MessageId;
import model.receipt.Sell;
import report.ReportFactory;
import report.ReportPrint;
import report.ReportUtils;
import util.ValueHolder;

public class PrintSellReportAction implements Action {

	private final ValueHolder holder;

	public PrintSellReportAction(ValueHolder selectionValueHolder) {
		this.holder = selectionValueHolder;
	}

	public void execute() {
		ReportPrint print = ReportFactory.instance().sellReportPrint((Sell) holder.getValue());
		ReportUtils.instance().show(print);
	}

	public MessageId messageId() {
		return MessageId.print;
	}

}
