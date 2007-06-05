package ui.view.swing.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import message.MessageId;
import message.MessageRepository;
import query.framework.criteria.Criteria;
import query.framework.results.SearchResults;
import ui.UI;
import ui.controller.action.Action;
import ui.view.component.SearchUI;
import ui.view.swing.util.FixedBoxLayout;
import ui.view.swing.util.TableModelAdapter;

public abstract class StandardSearchPanel extends JPanel implements SearchUI {

	private JPanel buttonPanel;
	private JPanel centerPanel;
	private JPanel resultsPanel;
	private JTable resultsTable;
	private JPanel filtersPanel;
	private TableModelAdapter tableModelAdapter;

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
		initFiltersPanel();
		initResultsPanel();
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(filtersPanel, BorderLayout.NORTH);
		centerPanel.add(resultsPanel, BorderLayout.CENTER);
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
		resultsTable = UI.instance().table(tableModelAdapter);
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

	public abstract Criteria criteria();

	public abstract void setSearchAction(Action action);
	
	public Object selection() {
		int rowIndex = resultsTable.getSelectedRow();
		
		if (rowIndex == -1) {
			return null;
		} else {
			SearchResults searchResults = (SearchResults) tableModelAdapter.getResults();
			return searchResults.getFoundObject(rowIndex);
		}
	}
	
}
