package ui.action;

import model.JuridicPerson;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.component.ClientUI;

public class ModifyClientAction implements Action {

	private final ClientUI clientUI;
	private final JuridicPerson client;

	public ModifyClientAction(ClientUI clientUI, JuridicPerson client) {
		this.clientUI = clientUI;
		this.client = client;
	}
	
	public void execute() {
		throw new NotImplementedException();
		
//		String clientName = clientUI.getClientName();
//		clientUI.setVisible(false);
	}

	public String getTitle() {
		return "Modificar";
	}

}
