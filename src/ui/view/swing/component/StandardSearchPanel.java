package ui.view.swing.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import message.MessageId;
import message.MessageRepository;
import query.framework.criteria.Criteria;
import query.framework.results.SearchResults;
import ui.controller.action.Action;
import ui.view.component.SearchUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.FixedBoxLayout;
import ui.view.swing.util.TableModelAdapter;
import ui.view.swing.util.actionadapter.ActionAdapter;
import ui.view.swing.util.actionadapter.ClickAdapter;

public abstract class StandardSearchPanel extends JPanel implements SearchUI, Criteria {

	private JPanel buttonPanel;
	private JPanel centerPanel;
	private JPanel resultsPanel;
	private JTable resultsTable;
	private JPanel filtersPanel;
	private TableModelAdapter tableModelAdapter;
	private JPanel northPanel;
	private JPanel filtersButtonsPanel;
	private JButton searchButton;
	private JPanel eastPanel;

	public StandardSearchPanel() {
		initCenterPanel();
		initEastPanel();
		
		this.setLayout(new BorderLayout());
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(eastPanel, BorderLayout.EAST);
	}

	private void initEastPanel() {
		initButtonPanel();
		
		eastPanel = SwingUI.instance().titledBorderPanel(buttonPanel, MessageId.searchPanelButtons);
		Border titledBorder = eastPanel.getBorder();
		Border emptyBorder = BorderFactory.createEmptyBorder(0, 5, 0, 0);
		Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, titledBorder);
		eastPanel.setBorder(compoundBorder);
		eastPanel.setVisible(false);
	}

	private void initButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FixedBoxLayout(buttonPanel, BoxLayout.PAGE_AXIS, new Dimension(120, 25)));
	}

	private void initCenterPanel() {
		initNorthPanel();
		initResultsPanel();
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(northPanel, BorderLayout.NORTH);
		centerPanel.add(resultsPanel, BorderLayout.CENTER);
	}

	private void initNorthPanel() {
		initFiltersPanel();
		initFiltersButtonsPanel();
		
		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(filtersPanel, BorderLayout.CENTER);
		northPanel.add(filtersButtonsPanel, BorderLayout.SOUTH);
	}

	private void initFiltersButtonsPanel() {
		searchButton = new JButton();
		
		filtersButtonsPanel = new JPanel();
		filtersButtonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		filtersButtonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		filtersButtonsPanel.setVisible(false);
		
		filtersButtonsPanel.add(searchButton);
		
	}

	private void initFiltersPanel() {
		filtersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		String filtersTitle = MessageRepository.instance().get(MessageId.searchFiltersTitle);
		filtersPanel.setBorder(BorderFactory.createTitledBorder(filtersTitle));
	}

	private void initResultsPanel() {
		resultsPanel = new JPanel();
		resultsPanel.setLayout(new BorderLayout());
		tableModelAdapter = new TableModelAdapter();
		resultsTable = SwingUI.instance().table(tableModelAdapter);
		resultsPanel.add(new JScrollPane(resultsTable));
	}

	protected JPanel buttonPanel() {
		return buttonPanel;
	}

	protected JPanel filtersPanel() {
		return filtersPanel;
	}
	
	protected JTable resultsTable() {
		return resultsTable;
	}
	
	public void setResults(SearchResults results) {
		tableModelAdapter.setResults(results);
	}

	public SearchResults getResults() {
		return (SearchResults) tableModelAdapter.getResults();
	}
	
	public Criteria getCriteria() {
		return this;
	}

	public void setSearchAction(Action action) {
		searchButton.setAction(new ActionAdapter(action));
		filtersButtonsPanel.setVisible(true);
	}
	
	public Object getSelection() {
		int rowIndex = resultsTable.getSelectedRow();
		
		if (rowIndex == -1) {
			return null;
		} else {
			SearchResults searchResults = (SearchResults) tableModelAdapter.getResults();
			return searchResults.get(rowIndex);
		}
	}

	public List getSelections() {
		int[] rowIndexes = resultsTable.getSelectedRows();
		
		List selections = new ArrayList();
		SearchResults searchResults = (SearchResults) tableModelAdapter.getResults();
		for (int i = 0; i < rowIndexes.length; i++) {
			int rowIndex = rowIndexes[i];
			selections.add(searchResults.get(rowIndex)); 
		}
		return selections;
	}
	
	public void add(Action action) {
		JButton button = new JButton(new ActionAdapter(action));
		buttonPanel().add(button);
		
		// Makes visible the east panel (initially hidden)
		eastPanel.setVisible(true);
	}
	
	public void setDefaultAction(Action action) {
//		for (int i = 0; i < buttonPanel().getComponentCount(); i++) {
//			JButton button = (JButton) buttonPanel().getComponent(i);
//
//			ActionAdapter actionAdapter = (ActionAdapter) button.getAction();
//			if (actionAdapter.getAction().equals(action)) {
//				getRootPane().setDefaultButton(button);
//			}
//		}
		resultsTable.addMouseListener(new ClickAdapter(action, 2));

		//FIXME ENTER selects the next row!
//		resultsTable.addKeyListener(new KeyTypedAdapter(action, KeyEvent.VK_ENTER));
	}

	public Action getSearchAction() {
		return ((ActionAdapter) searchButton.getAction()).getAction();
	}	
	
}
