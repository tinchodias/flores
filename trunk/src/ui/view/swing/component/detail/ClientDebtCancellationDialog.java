package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.JuridicPerson;
import model.money.Pesos;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.ClientDebtCancellationUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class ClientDebtCancellationDialog extends StandardDetailDialog implements ClientDebtCancellationUI {

	private JFormattedTextField amountField;
	private ObjectPicker clientPicker;

	public ClientDebtCancellationDialog() {
		super(MessageId.clientDebtCancellation);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		amountField = SwingUI.instance().currencyField();
		clientPicker = new ObjectPicker();
		
		centerPanel().add(SwingUI.instance().label(clientPicker, MessageId.client));
		centerPanel().add(SwingUI.instance().label(amountField, MessageId.amount));
	}

	public Pesos getAmount() {
		return SwingUI.instance().pesosFrom(amountField);
	}

	public JuridicPerson getClient() {
		return (JuridicPerson) clientPicker.getSelection();
	}

	public void setClientSearchInitializer(SearchDialogInitializer initializer) {
		clientPicker.setSearchInitializer(initializer);
	}
	
}
