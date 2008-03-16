package ui.controller.action;

import message.MessageId;

public class CompositeAction implements Action {

	private final MessageId messageId;
	private final Action action1;
	private final Action action2;

	public CompositeAction(Action action1, Action action2, MessageId messageId) {
		this.action1 = action1;
		this.action2 = action2;
		this.messageId = messageId;
	}

	public void execute() {
		action1.execute();
		action2.execute();
	}

	public MessageId messageId() {
		return messageId;
	}

}
