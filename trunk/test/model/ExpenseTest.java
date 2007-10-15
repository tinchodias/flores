/**
 * 
 */
package model;

import java.util.Iterator;

import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;

import junit.framework.TestCase;
import model.expense.Expense;
import model.expense.ExpenseArticle;

public class ExpenseTest extends TestCase {

	private Store store;
	private ExpenseArticle anExpenseArticle;

	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
		
		anExpenseArticle = store.expensesArticles().iterator().next();
	}

	public void testSimpleExpenseAdd() {
		Expense expense = StoreFixture.simpleExpense(anExpenseArticle);

		store.add(expense);
		
		Iterator<Expense> iterator = store.expenses().iterator();
		assertTrue(iterator.hasNext());
		assertTrue(iterator.next().equals(expense));
	}
}
