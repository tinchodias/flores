/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.commission.CommissionSummary;
import model.expense.Expense;
import model.expense.ExpenseArticle;
import model.money.Cash;
import model.money.Payment;
import model.money.MoneyAmount;
import model.receipt.Sell;
import model.receipt.SellItems;
import model.stock.Article;

import org.joda.time.DateTime;

import util.TimeUtils;

public class BasicCommissionsTest extends TestCase {

	private Store store;
	private Article clavel;
	private JuridicPerson elvira;
	private Sell sell;
	private Vendor eduardo;
	private ExpenseArticle alquiler;
	private MoneyAmount clavelInitialCost;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFixture.simpleStore();
		
		clavel = store.stockArticles().iterator().next();
		
		clavelInitialCost = store.stock().cost(clavel);

		elvira = store.clients().iterator().next();
		
		eduardo = store.vendors().iterator().next();
		
		alquiler = store.expensesArticles().iterator().next();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testComplete() {
		initialAsserts();
		
		doSell();

		postSellAsserts();
		
		doExpense();
		
		postExpenseAsserts();
	}

	private void initialAsserts() {
		CommissionSummary summary = store.commissions().commissionAt(eduardo, TimeUtils.todayInterval());
		assertEquals(MoneyAmount.newFor(0.0), summary.getTotal());
		assertEquals(MoneyAmount.newFor(0.0), summary.getSellTotal());
		assertEquals(MoneyAmount.newFor(0.0), summary.getCostTotal());
		assertEquals(MoneyAmount.newFor(0.0), summary.getExpensesTotal());
	}

	private void postSellAsserts() {
		CommissionSummary summary = store.commissions().commissionAt(eduardo, TimeUtils.todayInterval());
		assertEquals(MoneyAmount.newFor(450.0), summary.getTotal());
		assertEquals(clavelInitialCost.plus(MoneyAmount.newFor(9.0)).by(100.0), summary.getSellTotal());
		assertEquals(clavelInitialCost.by(100.0), summary.getCostTotal());
		assertEquals(MoneyAmount.newFor(0.0), summary.getExpensesTotal());
	}

	private void postExpenseAsserts() {
		CommissionSummary summary = store.commissions().commissionAt(eduardo, TimeUtils.todayInterval());
		assertEquals(MoneyAmount.newFor(350.0), summary.getTotal());
		assertEquals(clavelInitialCost.plus(MoneyAmount.newFor(9.0)).by(100.0), summary.getSellTotal());
		assertEquals(clavelInitialCost.by(100.0), summary.getCostTotal());
		assertEquals(MoneyAmount.newFor(200.0), summary.getExpensesTotal());
	}
	
	/**
	 * Elvira buys to Eduardo 100 claveles, paying $500 ($9 of gain each one). 
	 */
	private void doSell() {
		SellItems spec = new SellItems();
		spec.add(clavel, 100.0, clavelInitialCost.plus(MoneyAmount.newFor(9.0)), clavelInitialCost);
		
		Payment payment = new Payment();
		payment.add(new Cash(MoneyAmount.newFor(500.0)));
		
		sell = new Sell(spec, new DateTime(), elvira, payment, eduardo);
		store.add(sell);
	}
	
	/**
	 * An expense of $200 is registered.
	 */
	private void doExpense() {
		Expense expense = new Expense(alquiler, MoneyAmount.newFor(200.0), new DateTime());
		store.add(expense);
	}
}
