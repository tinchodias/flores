package model;

import junit.framework.TestCase;
import model.cashBook.CashExtraction;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.expense.Expense;
import model.expense.ExpenseArticle;
import model.money.MoneyAmount;
import model.receipt.Buy;
import model.receipt.BuyCancellation;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.stock.Article;

import org.joda.time.DateTime;

public class CashBookTest extends TestCase {

	private Store store;
	private Article stockArticle;
	private JuridicPerson client;
	private Vendor vendor;
	private ExpenseArticle expenseArticle;
	private JuridicPerson supplier;

	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFixture.simpleStore();
		
		stockArticle = store.stockArticles().iterator().next();
		
		client = store.clients().iterator().next();
		
		supplier = store.suppliers().iterator().next();
		
		vendor = store.vendors().iterator().next();
		
		expenseArticle = store.expensesArticles().iterator().next();
	}
	
	public void testCashBookCase1() {
		assertCurrentCash(0.0);
		
		Buy buy = StoreFixture.simpleBuy(stockArticle, supplier);
		store.add(buy);
		
		assertCurrentCash(-950.0);

		BuyCancellation cancellation = StoreFixture.buyCancellation(buy);
		store.add(cancellation);
		
		assertCurrentCash(0.0);
	}
	
	public void testCashBookCase2() {
		assertCurrentCash(0.0);
		
		Buy buy = StoreFixture.simpleBuy(stockArticle, supplier);
		store.add(buy);
		
		assertCurrentCash(-950.0);
		
		Sell sell = StoreFixture.simpleSell(stockArticle, client, vendor, store.stock().cost(stockArticle));
		store.add(sell);
		
		assertCurrentCash(-450.0);
	
		SellCancellation cancellation = StoreFixture.sellCancellation(sell);
		store.add(cancellation);

		assertCurrentCash(-950.0);
	}

	public void testCashBookCase3() {
		assertCurrentCash(0.0);
		
		Buy buy = StoreFixture.simpleBuy(stockArticle, supplier);
		store.add(buy);
		
		assertCurrentCash(-950.0);
		
		Sell sell = StoreFixture.simpleSell(stockArticle, client, vendor, store.stock().cost(stockArticle));
		store.add(sell);
		
		assertCurrentCash(-450.0);

		ClientDebtCancellation debtCancellation = StoreFixture.simpleClientDebtCancellation(client);
		store.debts().add(debtCancellation);
		
		assertCurrentCash(-410.0);

		LostDebtDeclaration lostDebtDeclaration = StoreFixture.simpleLostDebtDeclaration(client);
		store.debts().add(lostDebtDeclaration);
		
		assertCurrentCash(-410.0);

		ClientDebtCancellation debtCancellation2 = StoreFixture.simpleClientDebtCancellation(client);
		store.debts().add(debtCancellation2);
		
		assertCurrentCash(-370.0);
	}
	
	public void testCashBookCase4() {
		assertCurrentCash(0.0);
		
		Expense expense = StoreFixture.simpleExpense(expenseArticle);
		store.add(expense);
		
		assertCurrentCash(-300.0);
	}

	public void testSimpleCashExtraction() {
		assertCurrentCash(0.0);

		ClientDebtCancellation debtCancellation = StoreFixture.simpleClientDebtCancellation(client);
		store.debts().add(debtCancellation);
		
		assertCurrentCash(40.0);
		
		MoneyAmount amount = MoneyAmount.newFor(30.0);
		store.cashBook().add(new CashExtraction(new DateTime(), amount, ""));
		
		assertCurrentCash(10.0);
	}
	
	private void assertCurrentCash(double value) {
		assertEquals(MoneyAmount.newFor(value), store.cashBook().currentCash());		
	}
}
