package ui.controller.action;

import message.MessageId;
import query.framework.results.LazySearchResults;
import ui.UI;
import ui.view.component.BuyUI;

public class RemoveBuyItemAction implements Action {

	private final BuyUI buyUI;

	public RemoveBuyItemAction(BuyUI buyUI) {
		this.buyUI = buyUI;
	}

	public void execute() {
		Object selection = buyUI.getItemsPanel().getSelection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.invalidSelection);
		} else {
			LazySearchResults results = (LazySearchResults) buyUI.getItemsPanel().getResults();
			results.remove(selection);
			buyUI.getItemsPanel().setResults(results);
		}
	}

	public MessageId messageId() {
		return MessageId.remove;
	}

}
