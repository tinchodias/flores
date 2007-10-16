package model.cashBook;

import java.util.List;

import model.debts.ClientDebtCancellation;
import model.expense.Expense;
import model.money.MoneyAmount;
import model.receipt.Buy;
import model.receipt.BuyCancellation;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.util.CollectionFactory;

import org.joda.time.base.BaseDateTime;

public class CashBook {

	private List entries = CollectionFactory.newList();
	private MoneyAmount currentCash = MoneyAmount.newFor(0.0);
	private List extractions = CollectionFactory.newList();

	private void addPositiveEntry(Object object, BaseDateTime date, MoneyAmount amount) {
		entries.add(new CashBookEntry(object, date, amount));
		currentCash = currentCash.plus(amount);
	}
	
	private void addNegativeEntry(Object object, BaseDateTime date, MoneyAmount amount) {
		addPositiveEntry(object, date, amount.by(-1));
	}
	
	public void apply(ClientDebtCancellation cancellation) {
		addPositiveEntry(cancellation, cancellation.getDate(), cancellation.getAmount());
	}

	public void apply(Expense expense) {
		addNegativeEntry(expense, expense.getDate(), expense.getCost());
	}

	public void apply(SellCancellation cancellation) {
		addNegativeEntry(cancellation, cancellation.getDate(), cancellation.getSell().payment().total());
	}

	public void apply(BuyCancellation cancellation) {
		addPositiveEntry(cancellation, cancellation.getDate(), cancellation.getBuy().payment().total());
	}

	public void apply(Sell sell) {
		addPositiveEntry(sell, sell.date(), sell.payment().total());
	}

	public void apply(Buy buy) {
		addNegativeEntry(buy, buy.date(), buy.payment().total());
	}

	public Iterable entries() {
		return entries;
	}

	public MoneyAmount currentCash() {
		return currentCash;
	}

	public void add(CashExtraction extraction) {
		extractions.add(extraction);
		addNegativeEntry(extraction, extraction.getDate(), extraction.getAmount());
	}
	
	public Iterable<CashExtraction> extractions() {
		return extractions;
	}
	
}
