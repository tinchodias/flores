package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import message.MessageId;
import model.money.Pesos;
import ui.view.component.CashExtractionUI;
import ui.view.swing.SwingUI;

public class CashExtractionDialog extends StandardDetailDialog implements CashExtractionUI {

	private JFormattedTextField amountField;
	private JTextField noteField;

	public CashExtractionDialog() {
		super(MessageId.cashExtraction);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		amountField = SwingUI.instance().currencyField();
		noteField = new JTextField();
		
		centerPanel().add(SwingUI.instance().label(amountField, MessageId.amount));
		centerPanel().add(SwingUI.instance().label(noteField, MessageId.note));
	}

	public Pesos getAmount() {
		return SwingUI.instance().pesosFrom(amountField);
	}

	public String getNote() {
		return noteField.getText();
	}
	
}
