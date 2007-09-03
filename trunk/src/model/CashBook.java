package model;

import java.util.List;

import model.debts.ClientDebtCancellation;
import model.expense.Expense;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyCancellation;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.util.CollectionFactory;

import org.joda.time.base.BaseDateTime;

public class CashBook {

	private List entries = CollectionFactory.newList();
	private Pesos currentCash = Pesos.newFor(0.0);

	private void addPositiveEntry(Object object, BaseDateTime date, Pesos amount) {
		entries.add(new CashBookEntry(object, date, amount));
		currentCash = currentCash.plus(amount);
	}
	
	private void addNegativeEntry(Object object, BaseDateTime date, Pesos amount) {
		addPositiveEntry(object, date, amount.by(-1));
	}
	
	public void add(ClientDebtCancellation cancellation) {
		addPositiveEntry(cancellation, cancellation.getDate(), cancellation.getAmount());
	}

	public void add(Expense expense) {
		addNegativeEntry(expense, expense.getDate(), expense.getCost());
	}

	public void add(SellCancellation cancellation) {
		addNegativeEntry(cancellation, cancellation.getDate(), cancellation.getSell().payment().total());
	}

	public void add(BuyCancellation cancellation) {
		addPositiveEntry(cancellation, cancellation.getDate(), cancellation.getBuy().payment().total());
	}

	public void add(Sell sell) {
		addPositiveEntry(sell, sell.date(), sell.payment().total());
	}

	public void add(Buy buy) {
		addNegativeEntry(buy, buy.date(), buy.payment().total());
	}

	public Iterable entries() {
		return entries;
	}

	public Pesos currentCash() {
		return currentCash;
	}
}