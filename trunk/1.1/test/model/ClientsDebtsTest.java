/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.receipt.Sell;
import model.stock.Article;
import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;

public class ClientsDebtsTest extends TestCase {

	private Store store;
	private JuridicPerson elvira;
	
	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();

		Article anArticle = store.stockArticles().iterator().next();
		JuridicPerson aSupplier = store.suppliers().iterator().next();
		store.add(StoreFixture.simpleBuy(anArticle, aSupplier));
		
		elvira = store.clients().iterator().next();
	}

	public void testSimpleDebt() {
		Sell aSell = StoreFixture.simpleSell(store);
		store.add(aSell);
		
		assertEquals(aSell.clientDebt(), store.debts().debtOf(elvira));

		ClientDebtCancellation debtCancellation = StoreFixture.simpleClientDebtCancellation(elvira);
		store.debts().add(debtCancellation);
		
		assertEquals(aSell.clientDebt().minus(debtCancellation.getAmount()), store.debts().debtOf(elvira));
		
		LostDebtDeclaration lostDebtDeclaration = StoreFixture.simpleLostDebtDeclaration(elvira);
		store.debts().add(lostDebtDeclaration);
		
		assertEquals(aSell.clientDebt().minus(debtCancellation.getAmount()).minus(lostDebtDeclaration.getAmount()), store.debts().debtOf(elvira));
	}

}
