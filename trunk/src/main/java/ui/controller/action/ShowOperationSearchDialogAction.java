package ui.controller.action;

import message.MessageId;
import model.operationSummary.OperationSummary;
import query.criteria.IntervalSearchCriteria;
import ui.controller.manager.ManagerFactory;
import ui.controller.manager.UIModelManager;
import ui.view.component.IntervalSearchUI;
import ui.view.component.SearchDialogUI;
import ui.view.component.SearchUI;

public class ShowOperationSearchDialogAction implements Action {

	private final SearchUI searchUI;

	public ShowOperationSearchDialogAction(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public void execute() {
		OperationSummary operationSummary = (OperationSummary) searchUI.getSelection();
		UIModelManager manager = ManagerFactory.instance().get(operationSummary.getOperationClass());
		SearchDialogUI dialog = manager.searchInitializer().dialog();

		//TODO horrible!
		IntervalSearchUI intervalSearchUI = (IntervalSearchUI) dialog.getSearchPanel();
		IntervalSearchCriteria intervalSearchCriteria = ((IntervalSearchCriteria) searchUI.getCriteria());
		intervalSearchUI.setInterval(intervalSearchCriteria.getInterval());
		dialog.getSearchPanel().getSearchAction().execute();
		
		dialog.setVisible(true);
	}

	public MessageId messageId() {
		return MessageId.view;
	}

}
