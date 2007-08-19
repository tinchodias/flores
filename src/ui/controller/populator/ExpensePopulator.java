package ui.controller.populator;

import model.Store;
import model.expense.Expense;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import ui.view.component.ExpenseUI;

import com.db4o.foundation.NotSupportedException;

public class ExpensePopulator extends DetailPopulator<Expense, ExpenseUI>{

	public void createFrom(ExpenseUI ui) {
		Expense expense = new Expense(ui.getExpenseArticle(), ui.getCost(), new DateTime());
		
		Store store = ModelPersistence.instance().loadedModel().store();
		store.add(expense);
	}

	public void modifyFrom(ExpenseUI ui) {
		throw new NotSupportedException();
	}

	public void showIn(ExpenseUI ui) {
		throw new NotSupportedException();
	}

}
