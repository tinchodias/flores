package ui.action;

import ui.component.DialogUI;

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
