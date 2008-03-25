package ui.controller.action;

import message.MessageId;
import query.framework.results.SearchResults;
import report.ReportFactory;
import report.ReportPrint;
import report.ReportUtils;
import ui.UI;
import ui.view.component.SearchUI;

public class ExportSearchResultsAction implements Action {

	private final SearchUI searchUI;

	public ExportSearchResultsAction(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public void execute() {
		String fileName = UI.instance().chooseSaveFileName();
		if (fileName != null) {
			SearchResults results = searchUI.getResults();
			String title = "List";
			ReportPrint print = ReportFactory.instance().standardListReportPrint(results, title);
			ReportUtils.instance().exportXls(print, fileName);
		}
	}

	public MessageId messageId() {
		return MessageId.exportXls;
	}

}
