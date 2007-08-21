package report;

import junit.framework.TestCase;
import model.Store;
import model.StoreFixture;
import model.receipt.Sell;

public class ReportFactoryTest extends TestCase {

	private Store store;
	
	protected void setUp() throws Exception {
		super.setUp();
		store = StoreFixture.simpleStore();
	}

	public void testSellReport() {
		Sell sell = StoreFixture.simpleSell(store);

		ReportFactory reportFactory = ReportFactory.instance();
		ReportPrint print = reportFactory.sellReport(sell);
		reportFactory.exportPdf(print, "/Sell.pdf");
	}
}
