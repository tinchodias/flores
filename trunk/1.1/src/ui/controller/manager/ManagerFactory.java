package ui.controller.manager;

import java.util.HashMap;
import java.util.Map;

import model.address.City;
import model.cashBook.CashExtraction;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.expense.Expense;
import model.expense.ExpenseArticle;
import model.receipt.Buy;
import model.receipt.Sell;
import model.stock.Article;
import model.stock.ArticleGroup;
import model.stock.StockDropOut;

public class ManagerFactory {

	private static ManagerFactory instance;

	public static ManagerFactory instance() {
		if (instance == null) {
			instance = new ManagerFactory();
		}
		return instance;
	}

	private Map managersMap;

	private ManagerFactory() {
		managersMap = new HashMap();
		managersMap.put(Sell.class, new SellManager());
		managersMap.put(Buy.class, new BuyManager());
		managersMap.put(Expense.class, new ExpenseManager());
		managersMap.put(ClientDebtCancellation.class, new ClientDebtCancellationManager());
		managersMap.put(LostDebtDeclaration.class, new LostDebtDeclarationManager());
		managersMap.put(CashExtraction.class, new CashExtractionManager());
		managersMap.put(StockDropOut.class, new StockDropOutManager());
		managersMap.put(Article.class, new StockManager());
		managersMap.put(ExpenseArticle.class, new ExpenseArticleManager());
		managersMap.put(City.class, new CityManager());
		managersMap.put(ArticleGroup.class, new ArticleGroupManager());
		
		//TODO key collision with Client and Supplier.
		//TODO put key into each manager.
	}
	
	public UIModelManager get(Class<?> aClass) {
		return (UIModelManager) managersMap.get(aClass);
	}

}
