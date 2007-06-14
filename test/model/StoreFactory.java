package model;

import model.JuridicPerson;
import model.Store;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyArticleSpecification;
import model.stock.Article;
import model.stock.ArticleGroup;

import org.joda.time.DateTime;

public class StoreFactory {

	public static Store makeEmptyStore() {
		return new Store();
	}

	public static Store makeSimpleStore() {
		Store store = new Store();
		
		JuridicPerson elvira = new JuridicPerson("Elvira");
		store.clients().add(elvira);

		JuridicPerson marquez = new JuridicPerson("Marquez");
		store.suppliers().add(marquez);
		
		JuridicPerson eduardo = new JuridicPerson("Eduardo");
		store.vendors().add(eduardo);

		ArticleGroup floresGroup = new ArticleGroup("Flores");
		store.stockArticleGroups().add(floresGroup);
		
		Article paqueteClavel = new Article("CLAVEL", "Paquete de Clavel", floresGroup);
		store.stockArticles().add(paqueteClavel);

		Article alquiler = new Article("ALQ", "Alquiler del dep�sito");
		store.expensesArticles().add(alquiler);
		
		BuyArticleSpecification spec = new BuyArticleSpecification();
		spec.add(paqueteClavel, 2000.0, Pesos.newFor(20.0));
		Buy buy = new Buy(spec, new DateTime(), marquez, new Payment());
		store.add(buy);
		
		return store;
	}

}
