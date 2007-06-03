package ui.controller.action;

import message.MessageId;
import message.MessageRepository;
import ui.controller.initializer.DialogInitializer;

//TODO Ver si es posible (y preferible) implementar todas las acciones ShowX con ésta genérica.
//TODO El string hardcoded de cada Action en getTitle() debe ser solucionado de otra manera.

public class ShowDialogAction implements Action {

	private final DialogInitializer initializer;

	public ShowDialogAction(DialogInitializer initializer) {
		this.initializer = initializer;
	}

	public void execute() {
		initializer.dialog().setVisible(true);
	}

	public String getTitle() {
		return MessageRepository.instance().get(MessageId.create);
	}

}
