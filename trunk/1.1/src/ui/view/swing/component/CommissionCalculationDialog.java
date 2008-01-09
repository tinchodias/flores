package ui.view.swing.component;

import javax.swing.JButton;

import message.MessageId;

import org.joda.time.ReadableInterval;

import ui.controller.action.Action;
import ui.view.component.CommissionCalculationUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.IntervalPicker;
import ui.view.swing.util.actionadapter.ActionAdapter;
import util.TimeUtils;

public class CommissionCalculationDialog extends StandardDialog implements CommissionCalculationUI {

	private IntervalPicker intervalPicker;
	private JButton acceptButton;
	
	public CommissionCalculationDialog() {
		super(MessageId.commissionCalculation);
		
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		intervalPicker = new IntervalPicker();
		intervalPicker.setInterval(TimeUtils.recentDaysInterval(7));
		
		acceptButton = new JButton();
		getRootPane().setDefaultButton(acceptButton);

		centerPanel().add(SwingUI.instance().decorated(intervalPicker));
		buttonPanel().add(SwingUI.instance().decorated(acceptButton));
	}

	public ReadableInterval getInterval() {
		return intervalPicker.getInterval();
	}

	public void setAcceptAction(Action action) {
		acceptButton.setAction(new ActionAdapter(action));
	}

}
