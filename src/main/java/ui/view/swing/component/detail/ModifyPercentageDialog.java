package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.util.Percentage;
import ui.view.component.ModifyPercentageUI;
import ui.view.swing.SwingUI;

public class ModifyPercentageDialog extends StandardDetailDialog implements ModifyPercentageUI {

	private JFormattedTextField percentageField;

	public ModifyPercentageDialog() {
		super(MessageId.modifyPercentage);
		init();
		pack();
		setLocationRelativeTo(null);
	}

	private void init() {
		percentageField = SwingUI.instance().decimalField();
		
		centerPanel().add(SwingUI.instance().decorated(percentageField, MessageId.priceMargin));
	}

	public Percentage getPercentage() {
		return SwingUI.instance().percentageFrom(percentageField);
	}

}
