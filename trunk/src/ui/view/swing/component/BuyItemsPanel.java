package ui.view.swing.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import message.MessageId;
import model.receipt.BuyItems;
import query.framework.results.BuyItemsLazySearchResults;
import query.framework.results.SearchResults;
import ui.controller.action.Action;
import ui.view.swing.SwingUI;
import ui.view.swing.util.actionadapter.ActionAdapter;


public class BuyItemsPanel extends StandardSearchPanel {

	private JLabel totalLabel;
	private JButton adjustTotalButton;
	private JPanel infoPanel;

	public BuyItemsPanel() {
		init();
	}

	private void init() {
		filtersPanel().setVisible(false);
		
		initInfoPanel();
		
		add(infoPanel, BorderLayout.SOUTH);
	}

	private void initInfoPanel() {
		totalLabel = new JLabel("                    ");
		totalLabel.setFont(totalLabel.getFont().deriveFont(20.0f));
		
		adjustTotalButton = new JButton();
		
		infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		infoPanel.add(SwingUI.instance().label(totalLabel, MessageId.total));
		infoPanel.add(adjustTotalButton);
	}

	public void setAdjustTotalAction(Action action) {
		adjustTotalButton.setAction(new ActionAdapter(action));
	}
	
	public void setResults(SearchResults results) {
		super.setResults(results);
		
		BuyItems buyItems = ((BuyItemsLazySearchResults) results).getBuyItems();
		
		totalLabel.setText(buyItems.total().toString());
	}
	
}
