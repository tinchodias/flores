package ui.swing.component;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ClientSearchPanel extends JPanel {

	private JPanel buttonPanel;
	private JPanel centerPanel;
//	private JPanel filtersPanel;
	private JPanel resultsPanel;
	private JTable resultsTable;

	public ClientSearchPanel() {
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
//		initFiltersPanel();
		initResultsPanel();
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
//		centerPanel.add(filtersPanel, BorderLayout.NORTH);
		centerPanel.add(resultsPanel, BorderLayout.CENTER);
	}

//	private void initFiltersPanel() {
//		filtersPanel = new JPanel();
//	}

	private void initResultsPanel() {
		resultsPanel = new JPanel();
		resultsPanel.setLayout(new BorderLayout());
		resultsTable = new JTable(new DefaultTableModel(15, 5));
		resultsPanel.add(new JScrollPane(resultsTable));
	}

	protected JPanel buttonPanel() {
		return buttonPanel;
	}

//	protected JPanel filtersPanel() {
//		return filtersPanel;
//	}
	
	protected JTable resultsTable() {
		return resultsTable;
	}
	
}
