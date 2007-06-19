package ui.view.swing.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import message.MessageId;
import message.MessageRepository;
import query.framework.criteria.Criteria;
import query.framework.results.SearchResults;
import ui.controller.action.Action;
import ui.view.component.SearchUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.ActionAdapter;
import ui.view.swing.util.FixedBoxLayout;
import ui.view.swing.util.TableModelAdapter;

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

	public StandardSearchPanel() {
		initCenterPanel();
		initButtonPanel();
		
		this.setLayout(new BorderLayout());
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.EAST);
	}

	private void initButtonPanel() {
		buttonPanel = new JPanel();
		FixedBoxLayout fixedBoxLayout = new FixedBoxLayout(buttonPanel, BoxLayout.PAGE_AXIS, new Dimension(100, 25));
		buttonPanel.setLayout(fixedBoxLayout);
		
		buttonPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
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
		filtersButtonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
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

	public void add(Action action) {
		JButton button = new JButton(new ActionAdapter(action));
		buttonPanel().add(button);
	}
	
}
