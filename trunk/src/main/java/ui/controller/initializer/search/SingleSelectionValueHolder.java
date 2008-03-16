package ui.controller.initializer.search;

import ui.view.component.SearchUI;
import util.ValueHolder;

public class SingleSelectionValueHolder implements ValueHolder {

	private final SearchUI searchUI;

	public SingleSelectionValueHolder(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public Object getValue() {
		return searchUI.getSelection();
	}

}
