package model;

import validation.ModelValidationError;
import model.stock.Stock;
import junit.framework.TestCase;

public class StockTest extends TestCase {

	private Stock stock;
	private Store store;

	protected void setUp() throws Exception {
		store = StoreFixture.simpleStore();
		stock = store.stock();
	}

	public void testStockNotNegative() {
		try {
			stock.apply(StoreFixture.simpleSell(store));
			fail("May not sell if there isn't enough stock");
		} catch (ModelValidationError e) {
		}
	}
}
