package report;

import java.io.File;

import model.Store;
import model.StoreFixture;
import model.receipt.Sell;
import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;
import junit.framework.TestCase;

public class ReportUtilsTest extends TestCase {

	private static final String EXPORT_TEST_PDF = "exportTest.pdf";
	private static final String EXPORT_TEST_XLS = "exportTest.xls";
	private ReportUtils reportUtils;
	private ReportPrint print;

	protected void setUp() throws Exception {
		reportUtils = ReportUtils.instance();

		ModelPersistenceFixture.mockWithSimpleModel();
		Store store = ModelPersistence.instance().loadedModel().store();
		Sell sell = StoreFixture.simpleSell(store);
		print = ReportFactory.instance().sellReportPrint(sell);
	}

	public void testShow() {
		reportUtils.show(print);
	}

	public void testExportPdf() {
		reportUtils.exportPdf(print, EXPORT_TEST_PDF);
		File file = new File(EXPORT_TEST_PDF);
		assertTrue(file.exists());
		file.deleteOnExit();
	}

	public void testExportXls() {
		reportUtils.exportXls(print, EXPORT_TEST_XLS);
		File file = new File(EXPORT_TEST_XLS);
		assertTrue(file.exists());
		file.deleteOnExit();
	}

}
