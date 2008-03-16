package ui.controller.action;

import message.MessageId;
import message.MessageRepository;
import model.cashBook.CashExtraction;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import ui.controller.initializer.detail.CashExtractionDetailInitializer;
import ui.controller.initializer.detail.mode.DetailMode;
import ui.view.component.CommissionSummaryUI;
import ui.view.component.DetailUI;

public class CreateCommissionCashExtraction implements Action {

	private final CommissionSummaryUI ui;

	public CreateCommissionCashExtraction(CommissionSummaryUI ui) {
		this.ui = ui;
	}

	public void execute() {
		//TODO ugly!
		show();
	}

	private void show() {
		CashExtractionDetailInitializer initializer = new CashExtractionDetailInitializer();
		initializer.mode(DetailMode.CREATING);
		
		DetailUI dialog = initializer.dialog();
		initializer.populator().showIn(dialog, cashExtraction());
		dialog.setVisible(true);
	}
	
	private CashExtraction cashExtraction() {
		return new CashExtraction(new DateTime(), ui.getTotal(), note());
	}

	private String note() {
		DateTimeFormatter formatter = DateTimeFormat.shortDate();
		String header = MessageRepository.instance().get(MessageId.commissionCalculation);
		return header + " (" + formatter.print(ui.getInterval().getStart()) + " - " + formatter.print(ui.getInterval().getEnd()) + ")";
	}

	public MessageId messageId() {
		return MessageId.createCommissionCashExtraction;
	}

}
