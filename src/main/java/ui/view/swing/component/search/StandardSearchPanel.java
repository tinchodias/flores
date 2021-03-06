package ui.view.swing.component.search;

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
import javax.swing.KeyStroke;
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

	private static final Dimension BUTTON_SIZE = new Dimension(125, 32);
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
	private JButton exportButton;

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
		buttonPanel.setLayout(new FixedBoxLayout(buttonPanel, BoxLayout.PAGE_AXIS, BUTTON_SIZE));
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
		
		filtersButtonsPanel.add(SwingUI.instance().decorated(searchButton));
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
		exportButton = new JButton();
		resultsTable = SwingUI.instance().table(tableModelAdapter);
		resultsPanel.add(SwingUI.instance().decorated(new JScrollPane(resultsTable)), BorderLayout.CENTER);
		resultsPanel.add(SwingUI.instance().decorated(exportButton), BorderLayout.SOUTH);
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
	
	public void setExportAction(Action action) {
		exportButton.setAction(new ActionAdapter(action));
	}
	
	public Object getSelection() {
		int rowIndex = resultsTable.getSelectedRow();
		
		if (rowIndex == -1) {
			return null;
		} else {
			SearchResults searchResults = (SearchResults) tableModelAdapter.getResults();
			int modelIndex = resultsTable.convertRowIndexToModel(rowIndex);
			return searchResults.get(modelIndex);
		}
	}

	public List getSelections() {
		int[] rowIndexes = resultsTable.getSelectedRows();
		
		List selections = new ArrayList();
		SearchResults searchResults = (SearchResults) tableModelAdapter.getResults();
		for (int i = 0; i < rowIndexes.length; i++) {
			int modelIndex = resultsTable.convertRowIndexToModel(rowIndexes[i]);
			selections.add(searchResults.get(modelIndex)); 
		}
		return selections;
	}
	
	public void add(Action action) {
		JButton button = new JButton(new ActionAdapter(action));
		buttonPanel().add(SwingUI.instance().decorated(button));
		
		// Makes visible the east panel (initially hidden)
		eastPanel.setVisible(true);
	}
	
	public void setDefaultAction(Action action) {
		resultsTable.addMouseListener(new ClickAdapter(action, 2));

		String actionKey = "searchPanelDefaultAction";
		resultsTable.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), actionKey);
		resultsTable.getActionMap().put(actionKey, new ActionAdapter(action));
	}

	public Action getSearchAction() {
		return ((ActionAdapter) searchButton.getAction()).getAction();
	}	
	
}
