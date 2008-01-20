package ui.controller.action;

import message.MessageId;
import query.framework.results.SellItemsLazySearchResults;
import ui.UI;
import ui.view.component.SellUI;

public class RemoveSellItemAction implements Action {

	private final SellUI sellUI;

	public RemoveSellItemAction(SellUI sellUI) {
		this.sellUI = sellUI;
	}

	public void execute() {
		Object selection = sellUI.getItemsPanel().getSelection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.invalidSelection);
		} else {
			SellItemsLazySearchResults results = (SellItemsLazySearchResults) sellUI.getItemsPanel().getResults();
			results.remove(selection);
			sellUI.getItemsPanel().setResults(results);
		}
	}

	public MessageId messageId() {
		return MessageId.remove;
	}

}
