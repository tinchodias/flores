package ui.view.swing.component.detail;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

import message.MessageId;
import model.JuridicPerson;
import model.money.Pesos;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.SellUI;
import ui.view.swing.SwingUI;
import ui.view.swing.component.search.SellItemsPanel;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class SellDialog extends StandardDetailDialog implements SellUI {

	private ObjectPicker clientPicker;
	private SellItemsPanel itemsPanel;
	private JPanel northPanel;
	private JFormattedTextField cashField;

	public SellDialog() {
		super(MessageId.sell);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		itemsPanel = new SellItemsPanel();
		
		initNorthPanel();
		
		centerPanel().setLayout(new BorderLayout());
		centerPanel().add(northPanel, BorderLayout.NORTH);
		centerPanel().add(itemsPanel, BorderLayout.CENTER);
	}

	private void initNorthPanel() {
		clientPicker = new ObjectPicker();
		cashField = SwingUI.instance().currencyField();
		
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		northPanel.add(SwingUI.instance().label(clientPicker, MessageId.client));
		northPanel.add(SwingUI.instance().label(cashField, MessageId.cashPay));
	}

	public SellItemsPanel getItemsPanel() {
		return itemsPanel;
	}

	public void setClientSearchInitializer(SearchDialogInitializer initializer) {
		clientPicker.setSearchInitializer(initializer);
	}

	public JuridicPerson getClient() {
		return (JuridicPerson) clientPicker.getSelection();
	}

	public void setClient(JuridicPerson client) {
		clientPicker.setSelection(client);
	}
	
	public Pesos getCashPay() {
		return SwingUI.instance().pesosFrom(cashField);
	}

	public void setCashPay(Pesos value) {
		cashField.setValue(value.value());
	}
	
	public void setAdjustTotalAction(Action action) {
		itemsPanel.setAdjustTotalAction(action);
	}

}
