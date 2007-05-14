package ui.swing.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import query.framework.criteria.Criteria;
import query.framework.results.SearchResults;
import ui.UI;
import ui.component.SearchUI;
import ui.swing.util.TableModelAdapter;

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
		LayoutManager layout = new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS);
		buttonPanel.setLayout(layout);
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
		filtersPanel = new JPanel();
		filtersPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
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
