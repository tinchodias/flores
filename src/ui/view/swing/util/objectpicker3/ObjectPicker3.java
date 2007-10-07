package ui.view.swing.util.objectpicker3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import org.apache.commons.lang.ObjectUtils;

import query.framework.query.SearchQuery;
import query.framework.results.SearchResults;
import ui.controller.action.objectpicker3.ShowObjectPickerDialog;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.controller.manager.UIModelManager;
import ui.view.swing.util.actionadapter.ActionAdapter;
import ui.view.swing.util.objectpicker.SelectionListener;


public class ObjectPicker3 extends Container {

	private JTextField field;
	private SearchQuery query;
	private Object selection;
	private JPopupMenu menu = new JPopupMenu();
	private JButton button;
	private List<SelectionListener> selectionListeners = new ArrayList();
	private final Color fieldNaturalBackgroudColor;
	private final Color fieldDirtyBackgroudColor = Color.PINK;
	private ObjectPickerDocumentHandler fieldDocumentHandler;

	public ObjectPicker3() {
		setLayout(new BorderLayout());
		
		field = new JTextField();
		fieldDocumentHandler = new ObjectPickerDocumentHandler(this);
		field.getDocument().addDocumentListener(fieldDocumentHandler);
		field.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int selectedIndex = menu.getSelectionModel().getSelectedIndex();
//					if (selectedIndex >= 0) {
//						((JMenuItem) menu.getComponent(selectedIndex)).doClick();
//					}
					menu.setVisible(false);
					menu.setVisible(true);
//					e.consume();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
//					System.out.println("up");
//					int newIndex = Math.max(0, menu.getSelectionModel().getSelectedIndex() - 1);
//					Component component = menu.getComponent(newIndex);
//					menu.setSelected(component);
//					component.requestFocusInWindow();
					menu.setVisible(false);
					menu.setVisible(true);
//					e.consume();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//					System.out.println("down");
//					int newIndex = Math.min(menu.getComponentCount() - 1, menu.getSelectionModel().getSelectedIndex() + 1);
//					Component component = menu.getComponent(newIndex);
//					menu.setSelected(component);
//					component.requestFocusInWindow();
					menu.setVisible(false);
					menu.setVisible(true);
//					e.consume();
				}
//				System.out.println("sel: " + menu.getSelectionModel().getSelectedIndex());
			}
		});
		
		button = new JButton();
		Dimension size = field.getPreferredSize();
		button.setPreferredSize(new Dimension(size.height, size.height));
		
		add(field, BorderLayout.CENTER);
		add(button, BorderLayout.EAST);

		
		fieldNaturalBackgroudColor = field.getBackground();
	}

	public void setUIModelManager(UIModelManager manager) {
		setSearchInitializer(manager.searchInitializer());
		setQuery(manager.stringSearchQuery());
	}
	
	public void setSearchInitializer(SearchDialogInitializer initializer) {
		button.setAction(new ActionAdapter(new ShowObjectPickerDialog(initializer, this)));
	}

	public void setQuery(SearchQuery query) {
		this.query = query;
	}

	public SearchQuery getQuery() {
		return query;
	}
	
	public void setSelection(Object item) {
		field.getDocument().removeDocumentListener(fieldDocumentHandler);
		field.setText(ObjectUtils.toString(item));
		field.getDocument().addDocumentListener(fieldDocumentHandler);		
//		setPopupVisible(false);
		setDirtyField(false);
		selection = item;
		notifySelection();
	}

	public Object getSelection() {
		return selection;
	}

	private void notifySelection() {
		for (SelectionListener listener: selectionListeners) {
			listener.selected(getSelection());
		}  
	}
	
	public void addSelectionListener(SelectionListener listener) {
		selectionListeners.add(listener);
	}
	
	public void setResults(SearchResults results) {
		menu.setVisible(false);
		if (results.getRowCount() > 0) {
			menu.removeAll();
			//TODO optimize
			for (Object object : results) {
				menu.add(new ObjectPickerMenuAction(object, this));
			}
			menu.show(this, 0, field.getHeight());
			menu.getSelectionModel().setSelectedIndex(0);
			field.requestFocusInWindow();
		}
	}

	public String getString() {
		return field.getText();
	}

	public void setString(String text) {
		field.setText(text);
	}

	public void setPopupVisible(boolean visible) {
		menu.setVisible(visible);
	}
	
	public boolean isPopupVisible() {
		return menu.isVisible();
	}
	
	public void setDirtyField(boolean dirty) {
		if (dirty) {
			selection = null;
			field.setBackground(fieldDirtyBackgroudColor);
		} else {
			field.setBackground(fieldNaturalBackgroudColor);
		}
	}
	
}
