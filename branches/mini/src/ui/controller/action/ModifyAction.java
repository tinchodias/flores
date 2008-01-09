package ui.controller.action;

import persistence.ModelPersistence;
import message.MessageId;
import transaction.Block;
import ui.controller.populator.DetailPopulator;
import ui.view.component.DetailUI;
import util.ValueHolder;

public class ModifyAction implements Action {

	private final DetailUI dialog;
	private final DetailPopulator populator;
	private final ValueHolder holder;

	public ModifyAction(DetailUI dialog, DetailPopulator populator, ValueHolder holder) {
		this.dialog = dialog;
		this.populator = populator;
		this.holder = holder;
	}

	public void execute() {
		ModelPersistence.instance().transactionManager().execute(new Block() {
			public void executeBlock() {
				populator.modifyFrom(dialog, holder.getValue());
			}
		});
		
		dialog.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
