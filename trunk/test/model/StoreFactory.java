package model;

import model.address.Address;
import model.address.City;
import model.address.Province;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyItems;
import model.stock.Article;
import model.stock.ArticleGroup;

import org.joda.time.DateTime;

public class StoreFactory {

	public static Store makeEmptyStore() {
		return new Store();
	}

	public static Store makeSimpleStore() {
		Store store = new Store();

		Province salta = new Province("Salta");
		store.provinces().add(salta);

		City met�n = new City("Met�n", salta);
		store.cities().add(met�n);

		JuridicPerson elvira = new JuridicPerson("Elvira", new Address("San Mart�n 1456", met�n));
		store.clients().add(elvira);

		JuridicPerson marquez = new JuridicPerson("Marquez", new Address("Rosales 356 PB", met�n));
		store.suppliers().add(marquez);
		
		JuridicPerson eduardo = new JuridicPerson("Eduardo", new Address("Moreno 4519", met�n));
		store.vendors().add(eduardo);

		ArticleGroup floresGroup = new ArticleGroup("Flores");
		store.stockArticleGroups().add(floresGroup);

		Article paqueteClavel = new Article("Paquete de Clavel", floresGroup);
		store.stockArticles().add(paqueteClavel);

		Article alquiler = new Article("Alquiler del dep�sito");
		store.expensesArticles().add(alquiler);
		
		BuyItems spec = new BuyItems();
		spec.add(paqueteClavel, 2000.0, Pesos.newFor(20.0));
		Buy buy = new Buy(spec, new DateTime(), marquez, new Payment());
		store.add(buy);
		
		return store;
	}

}
