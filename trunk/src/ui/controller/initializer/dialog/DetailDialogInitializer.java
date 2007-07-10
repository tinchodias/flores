package ui.controller.initializer.detail;

import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateAction;
import ui.controller.action.ModifyAction;
import ui.controller.initializer.DialogInitializer;
import ui.controller.initializer.detail.mode.DetailMode;
import ui.controller.initializer.detail.mode.DetailModeVisitor;
import ui.controller.populator.DetailPopulator;
import ui.view.component.DetailUI;

public abstract class DetailDialogInitializer implements DialogInitializer, DetailModeVisitor {

	private DetailMode mode;
	private DetailPopulator populator;
	private DetailUI baseDialog;

	public DetailPopulator populator() {
		return populator;
	}
	
	public DetailMode mode() {
		return mode;
	}

	public void mode(DetailMode mode) {
		this.mode = mode;
	}

	public void populator(DetailPopulator populator) {
		this.populator = populator;
	}
	
	public DetailUI dialog() {
		baseDialog = baseDialog();
		baseDialog.setMode(mode);
		baseDialog.setCancelAction(new CloseDialogAction(baseDialog));
		
		mode.applyTo(this);
		
		return baseDialog;
	}

	protected abstract DetailUI baseDialog();

	protected void initCreatingMode(DetailUI baseDialog) {
		baseDialog.setAcceptAction(new CreateAction(baseDialog, populator));
	}
	
	protected void initModifyingMode(DetailUI baseDialog) {
		populator.showIn(baseDialog);
		baseDialog.setAcceptAction(new ModifyAction(baseDialog, populator));
	}
	
	protected void initViewingMode(DetailUI baseDialog) {
		populator().showIn(baseDialog);
	}
	
	public void setViewingMode() {
		initViewingMode(baseDialog);
	}

	public void setCreatingMode() {
		initCreatingMode(baseDialog);
	}

	public void setModifyingMode() {
		initModifyingMode(baseDialog);
	}
	
}
