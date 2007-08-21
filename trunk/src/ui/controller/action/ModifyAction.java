package ui.controller.action;

import persistence.ModelPersistence;
import message.MessageId;
import transaction.Block;
import ui.controller.populator.DetailPopulator;
import ui.view.component.DetailUI;

public class ModifyAction implements Action {

	private final DetailUI dialog;
	private final DetailPopulator populator;

	public ModifyAction(DetailUI dialog, DetailPopulator populator) {
		this.dialog = dialog;
		this.populator = populator;
	}

	public void execute() {
		ModelPersistence.instance().transactionManager().execute(new Block() {
			public void executeBlock() {
				populator.modifyFrom(dialog);
			}
		});
		
		dialog.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
