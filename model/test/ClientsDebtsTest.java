/**
 * 
 */
package model.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.money.Cash;
import model.money.PayMode;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.ArticleSpecification;
import model.receipt.Buy;
import model.receipt.Sell;
import model.stock.Article;

public class ClientsDebtsTest extends TestCase {

	private Store depot;
	private Article paqueteRosa;
	private JuridicPerson elvira;
	private JuridicPerson marquez;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		depot = TestsCommonFactory.makeEmptyStore();

		elvira = new JuridicPerson("Elvira");
		depot.clients().add(elvira);

		marquez = new JuridicPerson("Marquez");
		depot.suppliers().add(marquez);
		
		paqueteRosa = new Article("RO40", "Paquete de Rosa x 40");
		depot.articles().add(paqueteRosa);

		ArticleSpecification spec = new ArticleSpecification();
		spec.add(paqueteRosa, 100.0, Pesos.newFor(15.0));
		Buy buy = new Buy(spec, new Date(), marquez, new Payment());
		depot.add(buy);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSimpleDebt() {
		doSell();
		
		assertEquals(Pesos.newFor(100.0), depot.debts().debtOf(elvira));

		depot.debts().add(new ClientDebtCancellation(elvira, Pesos.newFor(40.0), new Date()));
		assertEquals(Pesos.newFor(60.0), depot.debts().debtOf(elvira));
		
		depot.debts().add(new LostDebtDeclaration(elvira, Pesos.newFor(40.0), new Date()));
		assertEquals(Pesos.newFor(20.0), depot.debts().debtOf(elvira));
	}

	private void doSell() {
		ArticleSpecification spec = new ArticleSpecification();
		spec.add(paqueteRosa, 10.0, Pesos.newFor(50.0));
		
		Payment payment = new Payment();
		payment.add(new Cash(Pesos.newFor(400.0)));
		
		Sell sell = new Sell(spec, new Date(), elvira, payment);
		depot.add(sell);
	}
	
}
