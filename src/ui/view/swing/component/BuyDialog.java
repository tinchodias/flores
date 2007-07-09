package ui.view.swing.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

import message.MessageId;
import model.JuridicPerson;
import model.money.Pesos;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.BuyUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class BuyDialog extends StandardDetailDialog implements BuyUI {

	private ObjectPicker supplierPicker;
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
		supplierPicker = new ObjectPicker();
		cashField = SwingUI.instance().currencyField();
		
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		northPanel.add(SwingUI.instance().label(supplierPicker, MessageId.supplier));
		northPanel.add(SwingUI.instance().label(cashField, MessageId.cashPay));
	}

	public BuyItemsPanel getItemsPanel() {
		return itemsPanel;
	}

	public void setSupplierSearchInitializer(SearchDialogInitializer initializer) {
		supplierPicker.setSearchInitializer(initializer);
	}

	public JuridicPerson getSupplier() {
		return (JuridicPerson) supplierPicker.getSelection();
	}

	public void setSupplier(JuridicPerson supplier) {
		supplierPicker.setSelection(supplier);
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
