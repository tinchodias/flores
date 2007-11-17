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
	private JFormattedTextField otherLossesTotalField;

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
		otherLossesTotalField = SwingUI.instance().currencyField();
		
		centerPanel().add(SwingUI.instance().decorated(sellTotalField, MessageId.sellTotal));
		centerPanel().add(SwingUI.instance().decorated(costTotalField, MessageId.costTotal));
		centerPanel().add(SwingUI.instance().decorated(expensesTotalField, MessageId.expenses));
		centerPanel().add(SwingUI.instance().decorated(otherLossesTotalField, MessageId.otherLosses));
		centerPanel().add(SwingUI.instance().decorated(commissionTotalField, MessageId.total));
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

	public void setOtherLossesTotal(MoneyAmount value) {
		otherLossesTotalField.setValue(value.value());
	}

}
