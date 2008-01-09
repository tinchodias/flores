package ui.controller.initializer.search;

import ui.controller.initializer.DialogInitializer;
import ui.view.component.SearchDialogUI;

public interface SearchDialogInitializer extends DialogInitializer {

	public abstract SearchDialogUI dialog();
	
}
