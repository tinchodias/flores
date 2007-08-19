package ui.view.swing.util;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import message.MessageId;
import message.MessageRepository;
import model.CashBookEntry;
import model.expense.Expense;
import model.receipt.Buy;
import model.receipt.Sell;

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
			text = reasonFor((CashBookEntry) value);
		}
		setText(text);
	}

	//TODO !!!
	private String reasonFor(CashBookEntry entry) {
		MessageId messageId = null;
		Object object = entry.getObject();
		
		if (object instanceof Sell) {
			messageId = MessageId.sell; 
		} else if (object instanceof Buy) {
			messageId = MessageId.buy; 
		} else if (object instanceof Expense) {
			messageId = MessageId.expense;
		}
		
		return MessageRepository.instance().get(messageId);
	}
}
