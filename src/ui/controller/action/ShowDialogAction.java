package ui.controller.action;

import message.MessageId;
import message.MessageRepository;
import ui.controller.initializer.DialogInitializer;

//TODO Ver si es posible (y preferible) implementar todas las acciones ShowX con ésta genérica.

public class ShowDialogAction implements Action {

	private final DialogInitializer initializer;
	private MessageId titleMessageId;

	public ShowDialogAction(DialogInitializer initializer, MessageId titleMessageId) {
		this.initializer = initializer;
		this.titleMessageId = titleMessageId;
	}

	public void execute() {
		initializer.dialog().setVisible(true);
	}

	public String getTitle() {
		return MessageRepository.instance().get(titleMessageId);
	}

}
