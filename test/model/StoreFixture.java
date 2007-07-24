package model;

import java.util.Collection;

import model.address.Address;
import model.address.City;
import model.address.Province;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.BuyItems;
import model.receipt.Expense;
import model.receipt.Sell;
import model.receipt.SellAnnulment;
import model.receipt.SellItems;
import model.stock.Article;
import model.stock.ArticleGroup;

import org.apache.commons.lang.math.RandomUtils;
import org.joda.time.DateTime;

public class StoreFixture {

	public static Store emptyStore() {
		return new Store();
	}

	public static Store simpleStore() {
		Store store = new Store();

		Province salta = new Province("Salta");
		store.provinces().add(salta);

		City metán = new City("Metán", salta);
		store.cities().add(metán);

		JuridicPerson elvira = new JuridicPerson("Elvira", new Address("San Martín 1456", metán));
		store.clients().add(elvira);

		JuridicPerson marquez = new JuridicPerson("Marquez", new Address("Rosales 356 PB", metán));
		store.suppliers().add(marquez);
		
		JuridicPerson eduardo = new JuridicPerson("Eduardo", new Address("Moreno 4519", metán));
		store.vendors().add(eduardo);

		ArticleGroup floresGroup = new ArticleGroup("Flores");
		store.stockArticleGroups().add(floresGroup);

		Article paqueteClavel = new Article("Clavel", floresGroup);
		store.stockArticles().add(paqueteClavel);

		Article alquiler = new Article("Alquiler del depósito");
		store.expensesArticles().add(alquiler);
		
		return store;
	}

	public static Store stressStore() {
		Store store = new Store();

		System.out.println("Generating Provinces");
		for (int i = 0; i < 30; i++) {
			Province province = new Province("Provincia " + i);
			store.provinces().add(province);
		}
		System.out.println("Generating Null City");
		City nullCity = new City("Ninguna", (Province) oneOf(store.provinces()));
		store.cities().add(nullCity);
/*
		System.out.println("Generating Cities");
		for (int i = 0; i < 500; i++) {
			City city = new City("Ciudad " + i, (Province) oneOf(store.provinces()));
			store.cities().add(city);
		}

		System.out.println("Generating Final Consumer Client");
		JuridicPerson finalConsumerClient = new JuridicPerson("Consumidor Final", new Address("Ninguna", store.cities().iterator().next()));
		store.clients().add(finalConsumerClient);
		
		System.out.println("Generating Clients");
		for (int i = 0; i < 50; i++) {
			JuridicPerson client = new JuridicPerson("Cliente " + i, new Address("Domicilio " + i, (City) oneOf(store.cities())));
			store.clients().add(client);
		}

//		ModelPersistence.instance().transactionManager().commit();
		
		System.out.println("Generating Suppliers");
		for (int i = 0; i < 50; i++) {
			JuridicPerson supplier = new JuridicPerson("Proveedor " + i, new Address("Domicilio " + i, (City) oneOf(store.cities())));
			store.suppliers().add(supplier);
		}
		System.out.println("Generating Vendors");
		for (int i = 0; i < 10; i++) {
			JuridicPerson vendor = new JuridicPerson("Vendedor " + i, new Address("Domicilio " + i, (City) oneOf(store.cities())));
			store.vendors().add(vendor);
		}
		
		System.out.println("Generating Stock Article Groups");
		for (int i = 0; i < 100; i++) {
			ArticleGroup group = new ArticleGroup("Marca " + i);
			store.stockArticleGroups().add(group);
		}
		
		System.out.println("Generating Stock Articles");
		for (int i = 0; i < 800; i++) {
			Article article = new Article(String.valueOf(1000000 + i), "Artículo " + i, String.valueOf(RandomUtils.nextInt(i + 10)) + " Litros", (ArticleGroup) oneOf(store.stockArticleGroups()));
			store.stockArticles().add(article);
		}

		System.out.println("Generating Expenses Articles");
		for (int i = 0; i < 50; i++) {
			Article expenseArticle = new Article("Gasto " + i);
			store.expensesArticles().add(expenseArticle);
		}

//		ModelPersistence.instance().transactionManager().commit();
		/*
		System.out.println("Generating Buys");
		DateMidnight buysStart = new DateMidnight(2006, 1, 1);
		DateMidnight buysEnd = new DateMidnight(2006, 1, 2);
		for (ReadableDateTime date = buysStart; date.isBefore(buysEnd); date = date.toDateTime().plus(Days.ONE)) {
			for (int i = 0; i < 5; i++) {
				BuyItems spec = new BuyItems();
				for (int j = 0; j < 100; j++) {
					BuyItem buyItem = new BuyItem((Article) oneOf(store.stockArticles()), new Double(RandomUtils.nextInt(2000)), randomPesos(20), 0.5);
					spec.add(buyItem);
				}
				Buy buy = new Buy(spec, date, (JuridicPerson) oneOf(store.suppliers()), randomPayment(spec.total()));
				store.add(buy);
			}
			ModelPersistence.instance().transactionManager().commit();
		}

		System.out.println("Generating Sells");
		DateMidnight sellsStart = new DateMidnight(2007, 1, 1);
		DateMidnight sellsEnd = new DateMidnight(2007, 1, 2);
		for (ReadableDateTime date = sellsStart; date.isBefore(sellsEnd); date = date.toDateTime().plus(Days.ONE)) {
			for (int i = 0; i < 100; i++) {
				SellItems spec = new SellItems();
				for (int j = 0; j < 10; j++) {
					Article article = (Article) oneOf(store.stockArticles());
					spec.add(article, new Double(RandomUtils.nextInt(20)), randomPesos(40), store.stock().cost(article));
				}
				Sell sell = new Sell(spec, date, (JuridicPerson) oneOf(store.clients()), randomPayment(spec.sellTotal()), (JuridicPerson) oneOf(store.vendors()));
				store.add(sell);
			}
			ModelPersistence.instance().transactionManager().commit();
		}*/

		return store;
	}

	private static Pesos randomPesos(int bound) {
		return Pesos.newFor(new Double(RandomUtils.nextInt(bound)));
	}
	
	private static Pesos randomPesos(Pesos pesos) {
		return randomPesos(pesos.value().intValue());
	}

	private static Payment randomPayment(Pesos pesos) {
		Payment payment = new Payment();
		payment.add(new Cash(randomPesos(pesos)));
		return payment;
	}


	private static Object oneOf(Collection objects) {
		int i = RandomUtils.nextInt(objects.size());
		return objects.toArray()[i];
	}

	/**
	 * An expense of $300.
	 * 
	 * @param article
	 * @return
	 */
	public static Expense simpleExpense(Article article) {
		return new Expense(article, Pesos.newFor(300.0), new DateTime());
	}

	/**
	 * The client buys 100 claveles at $9 each, paying $500.
	 *  
	 * @param article 
	 * @param client 
	 * @param vendor 
	 * @param cost 
	 * @return 
	 */
	public static Sell simpleSell(Article article, JuridicPerson client, JuridicPerson vendor, Pesos cost) {
		SellItems spec = new SellItems();
		spec.add(article, 100.0, Pesos.newFor(9.0), cost);
		
		Payment payment = new Payment();
		payment.add(new Cash(Pesos.newFor(500.0)));
		
		return new Sell(spec, new DateTime(), client, payment, vendor);
	}

	/**
	 * Creates a buy annullment.
	 * 
	 * @param sell The sell to cancel.
	 * @return The annulment of the sell. 
	 */
	public static SellAnnulment sellAnnulment(Sell sell) {
		return new SellAnnulment(sell, new DateTime());
	}

	/**
	 * Creates a buy to the supplier of 2000 articles as $20 each, paying $950.
	 * 
	 * @param stockArticle
	 * @param supplier
	 * @return A buy.
	 */
	public static Buy simpleBuy(Article stockArticle, JuridicPerson supplier) {
		BuyItems spec = new BuyItems();
		spec.add(stockArticle, 2000.0, Pesos.newFor(20.0));

		Payment payment = new Payment();
		payment.add(new Cash(Pesos.newFor(950.0)));

		return new Buy(spec, new DateTime(), supplier, payment);
	}

	/**
	 * Craetes a buy annulment.
	 * 
	 * @param buy The buy to cancel.
	 * @return The annulment of the buy.
	 */
	public static BuyAnnulment buyAnnulment(Buy buy) {
		return new BuyAnnulment(buy, new DateTime());
	}

	/**
	 * Creates a debt cancellation of $40.
	 * 
	 * @param client
	 * @return
	 */
	public static ClientDebtCancellation simpleClientDebtCancellation(JuridicPerson client) {
		return new ClientDebtCancellation(client, Pesos.newFor(40.0), new DateTime());
	}

	/**
	 * Creates a lost debt declaration of $40.
	 * 
	 * @param client
	 * @return
	 */
	public static LostDebtDeclaration simpleLostDebtDeclaration(JuridicPerson client) {
		return new LostDebtDeclaration(client, Pesos.newFor(40.0), new DateTime());
	}
}
