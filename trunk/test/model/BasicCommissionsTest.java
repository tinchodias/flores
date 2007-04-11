/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.commission.CommissionSummary;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Expense;
import model.receipt.Sell;
import model.receipt.SellArticleSpecification;
import model.stock.Article;
import model.util.TimeUtils;

import org.joda.time.DateTime;

public class BasicCommissionsTest extends TestCase {

	private Store store;
	private Article clavel;
	private JuridicPerson elvira;
	private Sell sell;
	private JuridicPerson eduardo;
	private Article alquiler;
	private Pesos clavelInitialCost;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = TestsCommonFactory.makeSimpleStore();
		
		clavel = store.stockArticles().iterator().next();
		
		clavelInitialCost = store.stock().cost(clavel);

		elvira = store.clients().iterator().next();
		
		eduardo = store.vendors().iterator().next();
		
		alquiler = store.expensesArticles().iterator().next();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
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
		assertEquals(Pesos.newFor(0.0), summary.getTotal());
		assertEquals(Pesos.newFor(0.0), summary.getSellTotal());
		assertEquals(Pesos.newFor(0.0), summary.getCostTotal());
		assertEquals(Pesos.newFor(0.0), summary.getExpensesTotal());
	}

	private void postSellAsserts() {
		CommissionSummary summary = store.commissions().commissionAt(eduardo, TimeUtils.todayInterval());
		assertEquals(Pesos.newFor(450.0), summary.getTotal());
		assertEquals(clavelInitialCost.plus(Pesos.newFor(9.0)).by(100.0), summary.getSellTotal());
		assertEquals(clavelInitialCost.by(100.0), summary.getCostTotal());
		assertEquals(Pesos.newFor(0.0), summary.getExpensesTotal());
	}

	private void postExpenseAsserts() {
		CommissionSummary summary = store.commissions().commissionAt(eduardo, TimeUtils.todayInterval());
		assertEquals(Pesos.newFor(350.0), summary.getTotal());
		assertEquals(clavelInitialCost.plus(Pesos.newFor(9.0)).by(100.0), summary.getSellTotal());
		assertEquals(clavelInitialCost.by(100.0), summary.getCostTotal());
		assertEquals(Pesos.newFor(200.0), summary.getExpensesTotal());
	}
	
	/**
	 * Elvira buys to Eduardo 100 claveles, paying $500 ($9 of gain each one). 
	 */
	private void doSell() {
		SellArticleSpecification spec = new SellArticleSpecification();
		spec.add(clavel, 100.0, clavelInitialCost.plus(Pesos.newFor(9.0)), clavelInitialCost);
		
		Payment payment = new Payment();
		payment.add(new Cash(Pesos.newFor(500.0)));
		
		sell = new Sell(spec, new DateTime(), elvira, payment, eduardo);
		store.add(sell);
	}
	
	/**
	 * An expense of $200 is registered.
	 */
	private void doExpense() {
		Expense expense = new Expense(alquiler, Pesos.newFor(200.0), new DateTime());
		store.expenses().add(expense);
	}
}
