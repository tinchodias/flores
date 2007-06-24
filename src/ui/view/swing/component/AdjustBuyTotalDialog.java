package ui.view.swing.component;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.money.Pesos;
import ui.view.component.AdjustBuyTotalUI;
import ui.view.swing.SwingUI;

public class AdjustBuyTotalDialog extends StandardDetailDialog implements AdjustBuyTotalUI {

	private JFormattedTextField adjustedTotal;

	public AdjustBuyTotalDialog() {
		super(MessageId.adjustTotal);
		init();
		pack();
		setLocationRelativeTo(null);
	}

	private void init() {
		adjustedTotal = SwingUI.instance().currencyField();
		
		centerPanel().add(SwingUI.instance().label(adjustedTotal, MessageId.adjustedTotal));
	}

	public Pesos getAdjustedTotal() {
		return SwingUI.instance().pesosFrom(adjustedTotal);
	}

}
