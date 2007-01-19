package model.test;

import java.util.Date;

import model.Article;
import model.JuridicPerson;
import model.Store;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.ArticleSpecification;
import model.receipt.Buy;

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
		
		Article paqueteRosa = new Article("ROSA40", "Paquete de Rosa x 40");
		Article paqueteClavel = new Article("CLAVEL", "Paquete de Clavel");
		store.articles().add(paqueteClavel);
		store.articles().add(paqueteRosa);

		ArticleSpecification spec = new ArticleSpecification();
		spec.add(paqueteClavel, 2000.0, Pesos.newFor(20.0));
		spec.add(paqueteRosa, 10.0, Pesos.newFor(15.0));
		Buy buy = new Buy(spec, new Date(), marquez, new Payment());
		store.add(buy);
		
		return store;
	}

}
