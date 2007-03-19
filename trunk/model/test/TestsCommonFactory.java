package model.test;

import java.util.Date;

import model.JuridicPerson;
import model.Store;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.BuyArticleSpecification;
import model.receipt.Buy;
import model.stock.Article;

public class TestsCommonFactory {

	public static Store makeEmptyStore() {
		return new Store();
	}

	public static Store makeSimpleStore() {
		Store store = new Store();
		
		JuridicPerson elvira = new JuridicPerson("Elvira");
		store.clients().add(elvira);

		JuridicPerson marquez = new JuridicPerson("Marquez");
		store.suppliers().add(marquez);
		
		Article paqueteClavel = new Article("CLAVEL", "Paquete de Clavel");
		store.articles().add(paqueteClavel);

		Article alquiler = new Article("ALQ", "Alquiler del depósito");
		store.expensesArticles().add(alquiler);
		
		BuyArticleSpecification spec = new BuyArticleSpecification();
		spec.add(paqueteClavel, 2000.0, Pesos.newFor(20.0));
		Buy buy = new Buy(spec, new Date(), marquez, new Payment());
		store.add(buy);
		
		return store;
	}

}
