package ui.view.swing.component.detail;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

import message.MessageId;
import model.JuridicPerson;
import model.money.MoneyAmount;
import ui.controller.action.Action;
import ui.controller.manager.UIModelManager;
import ui.view.component.SellUI;
import ui.view.swing.SwingUI;
import ui.view.swing.component.search.SellItemsPanel;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class SellDialog extends StandardDetailDialog implements SellUI {

	private ObjectPicker3 clientPicker;
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
		clientPicker = new ObjectPicker3();
		cashField = SwingUI.instance().currencyField();
		
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		northPanel.add(SwingUI.instance().label(clientPicker, MessageId.client));
		northPanel.add(SwingUI.instance().label(cashField, MessageId.cashPay));
	}

	public SellItemsPanel getItemsPanel() {
		return itemsPanel;
	}

	public JuridicPerson getClient() {
		return (JuridicPerson) clientPicker.getSelection();
	}

	public void setClient(JuridicPerson client) {
		clientPicker.setSelection(client);
	}
	
	public MoneyAmount getCashPay() {
		return SwingUI.instance().moneyAmountFrom(cashField);
	}

	public void setCashPay(MoneyAmount value) {
		cashField.setValue(value.value());
	}
	
	public void setAdjustTotalAction(Action action) {
		itemsPanel.setAdjustTotalAction(action);
	}

	public void setClientManager(UIModelManager manager) {
		clientPicker.setUIModelManager(manager);
	}
	
}
