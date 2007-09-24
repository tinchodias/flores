package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.money.MoneyAmount;
import ui.view.component.AdjustTotalUI;
import ui.view.swing.SwingUI;

public class AdjustTotalDialog extends StandardDetailDialog implements AdjustTotalUI {

	private JFormattedTextField adjustedTotal;

	public AdjustTotalDialog() {
		super(MessageId.adjustTotal);
		init();
		pack();
		setLocationRelativeTo(null);
	}

	private void init() {
		adjustedTotal = SwingUI.instance().currencyField();
		
		centerPanel().add(SwingUI.instance().label(adjustedTotal, MessageId.adjustedTotal));
	}

	public MoneyAmount getAdjustedTotal() {
		return SwingUI.instance().moneyAmountFrom(adjustedTotal);
	}

}
