/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.Store;
import model.money.Pesos;
import model.receipt.Expense;
import model.stock.Article;

import org.joda.time.DateTime;

public class ExpenseTest extends TestCase {

	private Store store;
	private Article alquiler;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFactory.makeSimpleStore();
		
		alquiler = store.expensesArticles().iterator().next();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSimpleExpenseAdd() {
		Expense expense = createExpense();

		store.expenses().add(expense);
		
		assertTrue(store.expenses().contains(expense));
	}

	private Expense createExpense() {
		return new Expense(alquiler, Pesos.newFor(300.0), new DateTime());
	}
}
