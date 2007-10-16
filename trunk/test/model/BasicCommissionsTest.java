/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.commission.BasicCommissionsManager;
import model.commission.CommissionSummary;
import model.debts.LostDebtDeclaration;
import model.expense.Expense;
import model.money.MoneyAmount;
import model.receipt.Sell;
import model.stock.Article;
import model.stock.StockDropOut;
import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;
import util.TimeUtils;

public class BasicCommissionsTest extends TestCase {

	private static final MoneyAmount ZERO_AMOUNT = MoneyAmount.newFor(0.0);
	private Store store;
	private Vendor aVendor;
	private BasicCommissionsManager commissions;
	private JuridicPerson aClient;
	
	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
		commissions = new BasicCommissionsManager();
		store.commissions(commissions);
		
		Article clavel = store.stockArticles().iterator().next();
		JuridicPerson aSupplier = store.suppliers().iterator().next();
		store.add(StoreFixture.simpleBuy(clavel, aSupplier));
		
		aClient = store.clients().iterator().next();
		aVendor = store.vendors().iterator().next();
	}

	public void testComplete() {
		MoneyAmount gains = ZERO_AMOUNT;
		MoneyAmount losses = ZERO_AMOUNT;
		assertValidSummaryTotal(gains, losses);
		
		Sell aSell = StoreFixture.simpleSell(store);
		store.add(aSell);
		gains = gains.plus(aSell.sellTotal());
		losses = losses.plus(aSell.costTotal());
		assertValidSummaryTotal(gains, losses);

		Expense anExpense = StoreFixture.simpleExpense(store);
		store.add(anExpense);
		losses = losses.plus(anExpense.getCost());
		assertValidSummaryTotal(gains, losses);
		
		LostDebtDeclaration lostDebtDeclaration = StoreFixture.simpleLostDebtDeclaration(aClient);
		store.debts().add(lostDebtDeclaration);
		losses = losses.plus(lostDebtDeclaration.getAmount());
		assertValidSummaryTotal(gains, losses);
		
		StockDropOut aStockDropOut = StoreFixture.simpleStockDropOut(store);
		store.stock().add(aStockDropOut);
		losses = losses.plus(aStockDropOut.getUnitCost().by(aStockDropOut.getCount()));
		assertValidSummaryTotal(gains, losses);
	}
	
	private void assertValidSummaryTotal(MoneyAmount gains, MoneyAmount losses) {
		assertSummaryTotalEquals(gains.minus(losses).by(commissions.getCommisionMultiplier()));
	}

	private void assertSummaryTotalEquals(MoneyAmount value) {
		CommissionSummary summary = store.commissions().commissionAt(aVendor, TimeUtils.todayInterval());
		assertEquals(value, summary.getTotal());
	}

}
