package ui.view.swing.util;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import message.MessageRepository;
import model.cashBook.CashBookEntry;
import ui.controller.manager.ManagerFactory;
import ui.controller.manager.UIModelManager;

public class CashBookCellRenderer extends DefaultTableCellRenderer {

	private static CashBookCellRenderer instance;

	public static CashBookCellRenderer instance() {
		if (instance == null) {
			instance = new CashBookCellRenderer();
		}
		return instance;
	}
	
	private CashBookCellRenderer() {
		super();
		this.setHorizontalAlignment(JLabel.CENTER);
	}

	protected void setValue(Object value) {
		String text = "";
		
		if (value != null) {
			text = textFor((CashBookEntry) value);
		}
		setText(text);
	}

	private String textFor(CashBookEntry entry) {
		UIModelManager manager = ManagerFactory.instance().get(entry.getObject().getClass());
		return MessageRepository.instance().get(manager.singularNameMessageId());
	}
}
