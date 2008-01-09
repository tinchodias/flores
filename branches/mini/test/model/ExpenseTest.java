/**
 * 
 */
package model;

import java.util.Iterator;

import junit.framework.TestCase;
import model.expense.Expense;
import model.expense.ExpenseArticle;

public class ExpenseTest extends TestCase {

	private Store store;
	private ExpenseArticle alquiler;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFixture.simpleStore();
		
		alquiler = store.expensesArticles().iterator().next();
	}

	public void testSimpleExpenseAdd() {
		Expense expense = StoreFixture.simpleExpense(alquiler);

		store.add(expense);
		
		Iterator<Expense> iterator = store.expenses().iterator();
		assertTrue(iterator.hasNext());
		assertTrue(iterator.next().equals(expense));
	}
}
