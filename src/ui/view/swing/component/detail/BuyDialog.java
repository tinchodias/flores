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
import ui.view.component.BuyUI;
import ui.view.swing.SwingUI;
import ui.view.swing.component.search.BuyItemsPanel;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class BuyDialog extends StandardDetailDialog implements BuyUI {

	private ObjectPicker3 supplierPicker;
	private BuyItemsPanel itemsPanel;
	private JPanel northPanel;
	private JFormattedTextField cashField;

	public BuyDialog() {
		super(MessageId.buy);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		itemsPanel = new BuyItemsPanel();
		
		initNorthPanel();
		
		centerPanel().setLayout(new BorderLayout());
		centerPanel().add(northPanel, BorderLayout.NORTH);
		centerPanel().add(itemsPanel, BorderLayout.CENTER);
	}

	private void initNorthPanel() {
		supplierPicker = new ObjectPicker3();
		cashField = SwingUI.instance().currencyField();
		
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		northPanel.add(SwingUI.instance().label(supplierPicker, MessageId.supplier));
		northPanel.add(SwingUI.instance().label(cashField, MessageId.cashPay));
	}

	public BuyItemsPanel getItemsPanel() {
		return itemsPanel;
	}

	public JuridicPerson getSupplier() {
		return (JuridicPerson) supplierPicker.getSelection();
	}

	public void setSupplier(JuridicPerson supplier) {
		supplierPicker.setSelection(supplier);
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

	public void setSupplierManager(UIModelManager manager) {
		supplierPicker.setUIModelManager(manager);
	}

}
