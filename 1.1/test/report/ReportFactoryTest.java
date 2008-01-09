package report;

import junit.framework.TestCase;
import model.Store;
import model.StoreFixture;
import model.receipt.Sell;
import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;

public class ReportFactoryTest extends TestCase {

	private Store store;

	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
	}

	public void testSellReport() {
		Sell sell = StoreFixture.simpleSell(store);

		ReportFactory reportFactory = ReportFactory.instance();
		ReportPrint print = reportFactory.sellReport(sell);
		reportFactory.exportPdf(print, "/Sell.pdf");
	}
}
