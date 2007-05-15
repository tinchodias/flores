package ui.controller.action;

import ui.view.component.DialogUI;

public class CloseDialogAction implements Action {

	private final DialogUI dialogUI;

	public CloseDialogAction(DialogUI dialogUI) {
		this.dialogUI = dialogUI;
	}

	public void execute() {
		dialogUI.setVisible(false);
	}

	public String getTitle() {
		return "Cerrar";
	}

}
