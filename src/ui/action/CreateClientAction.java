package ui.action;

import persistence.ModelPersistence;
import model.JuridicPerson;
import model.Store;
import ui.component.ClientUI;

public class CreateClientAction implements Action {

	private final ClientUI clientUI;

	public CreateClientAction(ClientUI clientUI) {
		this.clientUI = clientUI;
	}
	
	public void execute() {
		JuridicPerson client = client();
		Store store = ModelPersistence.instance().loadedModel().store();
		store.clients().add(client);
		
		clientUI.setVisible(false);
	}

	private JuridicPerson client() {
		String name = clientUI.getClientName();
		return new JuridicPerson(name);
	}

	public String getTitle() {
		return "Guardar";
	}

}
