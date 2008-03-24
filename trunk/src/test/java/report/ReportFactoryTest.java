package report;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import message.MessageId;
import model.Store;
import model.StoreFixture;
import model.receipt.Sell;
import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;
import query.framework.results.LazySearchResults;
import query.util.ResultsFixture;

public class ReportFactoryTest extends TestCase {

	private Store store;
	private ReportFactory reportFactory;

	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
		reportFactory = ReportFactory.instance();
	}

	public void testSellReport() {
		Sell sell = StoreFixture.simpleSell(store);
		assertNotNull(reportFactory.sellReportPrint(sell));
	}
	
	public void testStandardReport() {
		List<MessageId> columnNames = new ArrayList();
		columnNames.add(MessageId.client);
		columnNames.add(MessageId.city);
		columnNames.add(MessageId.province);
		LazySearchResults results = ResultsFixture.resultsMock(columnNames, 70);
		
		assertNotNull(reportFactory.standardListReportPrint(results, "Test title"));
	}
	
}
