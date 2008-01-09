package model;

import java.util.Collection;

import model.address.Address;
import model.address.City;
import model.address.Province;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.expense.Expense;
import model.expense.ExpenseArticle;
import model.money.Cash;
import model.money.Payment;
import model.money.MoneyAmount;
import model.receipt.Buy;
import model.receipt.BuyCancellation;
import model.receipt.BuyItem;
import model.receipt.BuyItems;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.receipt.SellItems;
import model.stock.Article;
import model.stock.ArticleGroup;

import org.apache.commons.lang.math.RandomUtils;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.base.BaseDateTime;

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
		
		Vendor eduardo = new Vendor("Eduardo");
		store.vendors().add(eduardo);

		ArticleGroup floresGroup = new ArticleGroup("Flores");
		store.stockArticleGroups().add(floresGroup);

		Article paqueteClavel = new Article("Clavel", floresGroup);
		store.stockArticles().add(paqueteClavel);

		ExpenseArticle alquiler = new ExpenseArticle("Alquiler del depósito");
		store.expensesArticles().add(alquiler);
		
		return store;
	}

	public static void fillStressed(Store store) {
		System.out.println("Generating Provinces");
		for (int i = 0; i < 30; i++) {
			Province province = new Province("Provincia " + i);
			store.provinces().add(province);
		}
		System.out.println("Generating Null City");
		City nullCity = new City("Ninguna", (Province) oneOf(store.provinces()));
		store.cities().add(nullCity);

		System.out.println("Generating Cities");
		for (int i = 0; i < 100; i++) {
			City city = new City("Ciudad " + i, (Province) oneOf(store.provinces()));
			store.cities().add(city);
		}
		System.out.println("Generating Final Consumer Client");
		JuridicPerson finalConsumerClient = new JuridicPerson("Consumidor Final", new Address("Ninguna", store.cities().iterator().next()));
		store.clients().add(finalConsumerClient);
		
//		System.out.println("Generating Clients");
//		for (int i = 0; i < 50; i++) {
//			JuridicPerson client = new JuridicPerson("Cliente " + i, new Address("Domicilio " + i, (City) oneOf(store.cities())));
//			store.clients().add(client);
//		}
//
//		System.out.println("Generating Suppliers");
//		for (int i = 0; i < 50; i++) {
//			JuridicPerson supplier = new JuridicPerson("Proveedor " + i, new Address("Domicilio " + i, (City) oneOf(store.cities())));
//			store.suppliers().add(supplier);
//		}
//		System.out.println("Generating Vendors");
//		for (int i = 0; i < 10; i++) {
//			Vendor vendor = new Vendor("Vendedor " + i);
//			store.vendors().add(vendor);
//		}
//		
//		System.out.println("Generating Stock Article Groups");
//		for (int i = 0; i < 100; i++) {
//			ArticleGroup group = new ArticleGroup("Marca " + i);
//			store.stockArticleGroups().add(group);
//		}
//		System.out.println("Generating Stock Articles");
//		for (int i = 0; i < 800; i++) {
//			Article article = new Article(String.valueOf(1000000 + i), "Artículo " + i, String.valueOf(RandomUtils.nextInt(i + 10)) + " Litros", (ArticleGroup) oneOf(store.stockArticleGroups()));
//			store.stockArticles().add(article);
//		}
//
//		System.out.println("Generating Expenses Articles");
//		for (int i = 0; i < 50; i++) {
//			ExpenseArticle expenseArticle = new ExpenseArticle("Gasto " + i);
//			store.expensesArticles().add(expenseArticle);
//		}
//
//		System.out.println("Generating Expenses");
//		DateMidnight expensesStart = new DateMidnight(2006, 6, 1);
//		DateMidnight expensesEnd = new DateMidnight(2006, 6, 10);
//		for (BaseDateTime date = expensesStart; date.isBefore(expensesEnd); date = date.toDateTime().plus(Days.ONE)) {
//			for (int i = 0; i < 5; i++) {
//				Expense expense = new Expense((ExpenseArticle) oneOf(store.expensesArticles()), randomMoneyAmount(20), date);
//				store.add(expense);
//			}
//		}
//		
//		System.out.println("Generating Buys");
//		DateMidnight buysStart = new DateMidnight(2006, 1, 1);
//		DateMidnight buysEnd = new DateMidnight(2006, 2, 1);
//		for (BaseDateTime date = buysStart; date.isBefore(buysEnd); date = date.toDateTime().plus(Days.ONE)) {
//			for (int i = 0; i < 5; i++) {
//				BuyItems spec = new BuyItems();
//				for (int j = 0; j < 100; j++) {
//					BuyItem buyItem = new BuyItem((Article) oneOf(store.stockArticles()), new Double(1 + RandomUtils.nextInt(2000)), randomMoneyAmount(20));
//					spec.add(buyItem);
//				}
//				Buy buy = new Buy(spec, date, (JuridicPerson) oneOf(store.suppliers()), randomPayment(spec.total()));
//				store.add(buy);
//			}
//		}
//
//		System.out.println("Generating Sells");
//		DateMidnight sellsStart = new DateMidnight(2007, 1, 1);
//		DateMidnight sellsEnd = new DateMidnight(2007, 1, 10);
//		for (BaseDateTime date = sellsStart; date.isBefore(sellsEnd); date = date.toDateTime().plus(Days.ONE)) {
//			for (int i = 0; i < 100; i++) {
//				SellItems spec = new SellItems();
//				for (int j = 0; j < 5; j++) {
//					Article article = (Article) oneOf(store.stockArticles());
//					spec.add(article, new Double(1 + RandomUtils.nextInt(20)), randomMoneyAmount(40), store.stock().cost(article));
//				}
//				Sell sell = new Sell(spec, date, (JuridicPerson) oneOf(store.clients()), randomPayment(spec.sellTotal()), (Vendor) oneOf(store.vendors()));
//				store.add(sell);
//			}
//		}
	}

	private static MoneyAmount randomMoneyAmount(int bound) {
		return MoneyAmount.newFor(1.0 + RandomUtils.nextInt(bound));
	}
	
	private static MoneyAmount randomMoneyAmount(MoneyAmount moneyAmount) {
		return randomMoneyAmount(moneyAmount.value().intValue());
	}

	private static Payment randomPayment(MoneyAmount moneyAmount) {
		Payment payment = new Payment();
		payment.add(new Cash(randomMoneyAmount(moneyAmount)));
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
	public static Expense simpleExpense(ExpenseArticle article) {
		return new Expense(article, MoneyAmount.newFor(300.0), new DateTime());
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
	public static Sell simpleSell(Article article, JuridicPerson client, Vendor vendor, MoneyAmount cost) {
		SellItems spec = new SellItems();
		spec.add(article, 100.0, MoneyAmount.newFor(9.0), cost);
		
		Payment payment = new Payment();
		payment.add(new Cash(MoneyAmount.newFor(500.0)));
		
		return new Sell(spec, new DateTime(), client, payment, vendor);
	}

	/**
	 * Creates a buy cancellation.
	 * 
	 * @param sell The sell to cancel.
	 * @return The cancellation of the sell. 
	 */
	public static SellCancellation sellCancellation(Sell sell) {
		return new SellCancellation(sell, new DateTime());
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
		spec.add(stockArticle, 2000.0, MoneyAmount.newFor(20.0));

		Payment payment = new Payment();
		payment.add(new Cash(MoneyAmount.newFor(950.0)));

		return new Buy(spec, new DateTime(), supplier, payment);
	}

	/**
	 * Craetes a buy cancellation.
	 * 
	 * @param buy The buy to cancel.
	 * @return The cancellation of the buy.
	 */
	public static BuyCancellation buyCancellation(Buy buy) {
		return new BuyCancellation(buy, new DateTime());
	}

	/**
	 * Creates a debt cancellation of $40.
	 * 
	 * @param client
	 * @return
	 */
	public static ClientDebtCancellation simpleClientDebtCancellation(JuridicPerson client) {
		return new ClientDebtCancellation(client, MoneyAmount.newFor(40.0), new DateTime());
	}

	/**
	 * Creates a lost debt declaration of $40.
	 * 
	 * @param client
	 * @return
	 */
	public static LostDebtDeclaration simpleLostDebtDeclaration(JuridicPerson client) {
		return new LostDebtDeclaration(client, MoneyAmount.newFor(40.0), new DateTime());
	}

	/**
	 * Creates a sell with store objects.
	 * 
	 * @param store
	 * @return
	 */
	public static Sell simpleSell(Store store) {
		Article stockArticle = store.stockArticles().iterator().next();
		JuridicPerson client = store.clients().iterator().next();
		Vendor vendor = store.vendors().iterator().next();
		return StoreFixture.simpleSell(stockArticle, client, vendor, store.stock().cost(stockArticle));
	}
}
