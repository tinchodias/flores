package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.Vendor;
import model.money.MoneyAmount;

import org.joda.time.ReadableInterval;

import ui.view.component.CommissionSummaryUI;
import ui.view.swing.SwingUI;

public class CommissionSummaryDialog extends StandardDetailDialog implements CommissionSummaryUI {

	private JFormattedTextField costTotalField;
	private JFormattedTextField expensesTotalField;
	private JFormattedTextField sellTotalField;
	private JFormattedTextField commissionTotalField;
	private ReadableInterval interval;

	public CommissionSummaryDialog() {
		super(MessageId.commissionSummary);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		sellTotalField = SwingUI.instance().currencyField();
		costTotalField = SwingUI.instance().currencyField();
		expensesTotalField = SwingUI.instance().currencyField();
		commissionTotalField = SwingUI.instance().currencyField();
		
		centerPanel().add(SwingUI.instance().label(sellTotalField, MessageId.sellTotal));
		centerPanel().add(SwingUI.instance().label(costTotalField, MessageId.costTotal));
		centerPanel().add(SwingUI.instance().label(expensesTotalField, MessageId.expenses));
		centerPanel().add(SwingUI.instance().label(commissionTotalField, MessageId.total));
	}

	public void setCostTotal(MoneyAmount value) {
		costTotalField.setValue(value.value());
	}

	public void setExpensesTotal(MoneyAmount value) {
		expensesTotalField.setValue(value.value());
	}

	public void setInterval(ReadableInterval interval) {
		//TODO assign to a picker?
		this.interval = interval;
	}

	public void setSellTotal(MoneyAmount value) {
		sellTotalField.setValue(value.value());
	}

	public void setTotal(MoneyAmount value) {
		commissionTotalField.setValue(value.value());
	}

	public void setVendor(Vendor vendor) {
		//TODO implement!
	}

	public MoneyAmount getTotal() {
		return SwingUI.instance().moneyAmountFrom(commissionTotalField);
	}

	public ReadableInterval getInterval() {
		return interval;
	}

}
