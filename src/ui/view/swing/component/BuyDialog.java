package ui.view.swing.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import message.MessageId;
import ui.view.component.BuyUI;
import ui.view.component.SearchUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.ObjectPicker;

public class BuyDialog extends StandardDetailDialog implements BuyUI {

	private ObjectPicker supplierPicker;
	private BuyItemsPanel itemsPanel;
	private JPanel northPanel;

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

	private JPanel initNorthPanel() {
		supplierPicker = new ObjectPicker();
		
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel.add(SwingUI.instance().label(supplierPicker, MessageId.supplier));
		return northPanel;
	}

	public SearchUI getItemsPanel() {
		return itemsPanel;
	}

}
