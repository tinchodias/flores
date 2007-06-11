package ui.controller.action;

import message.MessageId;

public interface Action {
	
	public void execute();

	public MessageId messageId();

}
