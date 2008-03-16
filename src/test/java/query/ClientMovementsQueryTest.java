package query;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.StoreFixture;
import model.Vendor;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.stock.Article;

import org.joda.time.DateTime;
import org.joda.time.ReadableInterval;

import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;
import query.framework.criteria.ClientMovementSearchCriteria;
import query.framework.query.SearchQuery;
import util.TimeUtils;

public class ClientMovementsQueryTest extends TestCase {

	private Store store;
	private Article stockArticle;
	private JuridicPerson client;
	private Vendor vendor;
	private SearchQuery query;

	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
		
		stockArticle = store.stockArticles().iterator().next();

		JuridicPerson supplier = store.suppliers().iterator().next();
		store.add(StoreFixture.simpleBuy(stockArticle, supplier));
		
		client = store.clients().iterator().next();
		
		vendor = store.vendors().iterator().next();

		query = QueryFactory.instance().clientMovementsQuery();
	}
	
	public void testOneClient() {
		Sell sell = StoreFixture.simpleSell(stockArticle, client, vendor, store.stock().cost(stockArticle));
		store.add(sell);

		SellCancellation sellCancellation = new SellCancellation(sell, new DateTime());
		store.add(sellCancellation);
		
		ClientDebtCancellation debtCancellation = StoreFixture.simpleClientDebtCancellation(client);
		store.debts().add(debtCancellation);

		LostDebtDeclaration lostDebtDeclaration = StoreFixture.simpleLostDebtDeclaration(client);
		store.debts().add(lostDebtDeclaration);
		
		query.setCriteria(new ClientMovementSearchCriteria() {
			public JuridicPerson getClient() {
				return client;
			}

			public ReadableInterval getInterval() {
				return TimeUtils.recentDaysInterval(2);
			}
		});
		assertEquals(4, query.results().getRowCount());
	}
	
}
