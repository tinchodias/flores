package ui.swing.component;

import java.awt.BorderLayout;

import javax.swing.JButton;

import ui.action.Action;
import ui.component.ClientsUI;
import ui.swing.util.ActionAdapter;
import ui.swing.util.StandardDialog;

public class ClientsDialog extends StandardDialog implements ClientsUI {

	private ClientSearchPanel clientSearchPanel;
	private JButton okButton;
	private JButton addClientButton;
	private JButton modifyClientButton;

	public ClientsDialog() {
		super();
		initComponents();
		pack();
	}

	private void initComponents() {
		initSearchPanel();

		okButton = new JButton("Aceptar");
		
		this.centerPanel().setLayout(new BorderLayout());
		this.centerPanel().add(clientSearchPanel, BorderLayout.CENTER);
		this.buttonPanel().add(okButton);
	}

	private void initSearchPanel() {
		clientSearchPanel = new ClientSearchPanel();  
		addClientButton = new JButton("Agregar");
		modifyClientButton = new JButton("Modificar");
		
		clientSearchPanel.buttonPanel().add(addClientButton);
		clientSearchPanel.buttonPanel().add(modifyClientButton);
	}

	public void setOkButtonAction(Action action) {
		okButton.setAction(new ActionAdapter(action));
	}

	public void setAddClientButtonAction(Action action) {
		addClientButton.setAction(new ActionAdapter(action));
	}
	
	public void setModifyClientButtonAction(Action action) {
		modifyClientButton.setAction(new ActionAdapter(action));
	}

	public ClientSearchPanel getSearchPanel() {
		return clientSearchPanel;
	}
	
}
