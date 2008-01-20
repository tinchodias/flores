package ui.controller.action;

import persistence.ModelPersistence;
import message.MessageId;
import transaction.Block;
import ui.controller.populator.DetailPopulator;
import ui.view.component.DetailUI;
import util.ValueHolder;

public class CreateAction implements Action, ValueHolder {

	private final DetailUI dialog;
	private final DetailPopulator populator;
	private Object lastCreated;

	public CreateAction(DetailUI dialog, DetailPopulator populator) {
		this.dialog = dialog;
		this.populator = populator;
	}

	public void execute() {
		ModelPersistence.instance().transactionManager().execute(new Block() {
			public void executeBlock() {
				lastCreated = populator.createFrom(dialog);
			}
		});
		
		dialog.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

	public Object getValue() {
		//TODO rethink this...
		return lastCreated;
	}

}
