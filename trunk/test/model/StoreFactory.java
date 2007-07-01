package model;

import java.util.Collection;

import model.address.Address;
import model.address.City;
import model.address.Province;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyItems;
import model.receipt.Sell;
import model.receipt.SellItems;
import model.stock.Article;
import model.stock.ArticleGroup;

import org.apache.commons.lang.math.RandomUtils;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.ReadableDateTime;

public class StoreFactory {

	public static Store makeEmptyStore() {
		return new Store();
	}

	public static Store makeSimpleStore() {
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
		
		BuyItems spec = new BuyItems();
		spec.add(paqueteClavel, 2000.0, Pesos.newFor(20.0));
		Buy buy = new Buy(spec, new DateTime(), marquez, new Payment());
		store.add(buy);
		
		return store;
	}

	public static Store makeStressStore() {
		Store store = new Store();
		
		System.out.println("Generating Provinces");
		for (int i = 0; i < 30; i++) {
			Province province = new Province("Provincia " + i);
			store.provinces().add(province);
		}
		
		System.out.println("Generating Cities");
		for (int i = 0; i < 500; i++) {
			City city = new City("Ciudad " + i, (Province) oneOf(store.provinces()));
			store.cities().add(city);
		}

		System.out.println("Generating Clients");
		for (int i = 0; i < 500; i++) {
			JuridicPerson client = new JuridicPerson("Cliente " + i, new Address("Domicilio " + i, (City) oneOf(store.cities())));
			store.clients().add(client);
		}
		
		System.out.println("Generating Suppliers");
		for (int i = 0; i < 500; i++) {
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
			ArticleGroup group = new ArticleGroup("Grupo " + i);
			store.stockArticleGroups().add(group);
		}
		
		System.out.println("Generating Stock Articles");
		for (int i = 0; i < 800; i++) {
			Article article = new Article("Artículo " + i, (ArticleGroup) oneOf(store.stockArticleGroups()));
			store.stockArticles().add(article);
		}

		System.out.println("Generating Expenses Articles");
		for (int i = 0; i < 50; i++) {
			Article expenseArticle = new Article("Gasto " + i);
			store.expensesArticles().add(expenseArticle);
		}

		System.out.println("Generating Buys");
		DateMidnight buysStart = new DateMidnight(2006, 1, 1);
		DateMidnight buysEnd = new DateMidnight(2006, 2, 1);
		for (ReadableDateTime date = buysStart; date.isBefore(buysEnd); date = date.toDateTime().plus(Days.ONE)) {
			for (int i = 0; i < 5; i++) {
				BuyItems spec = new BuyItems();
				for (int j = 0; j < 100; j++) {
					spec.add((Article) oneOf(store.stockArticles()), new Double(RandomUtils.nextInt(2000)), randomPesos(20));
				}
				Buy buy = new Buy(spec, date, (JuridicPerson) oneOf(store.suppliers()), randomPayment(spec.total()));
				store.add(buy);
			}
		}

		System.out.println("Generating Sells");
		DateMidnight sellsStart = new DateMidnight(2007, 1, 1);
		DateMidnight sellsEnd = new DateMidnight(2007, 2, 1);
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
		}

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
		//TODO too slow?
		return objects.toArray()[i];
	}

}
