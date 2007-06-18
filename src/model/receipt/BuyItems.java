package model.receipt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.money.Pesos;
import model.stock.Article;



public class BuyItems {

	Map<Article, BuyItem> items = new HashMap<Article, BuyItem>();
	
	public void add(Article article, Double count, Pesos value) {
		items.put(article, new BuyItem(article, count, value));
	}
	
	public Collection<Article> getArticles() {
		return items.keySet();
	}
	
	public Double getCount(Article article) {
		return items.get(article).getCount();
	}

	public Pesos getValue(Article article) {
		return items.get(article).getValue();
	}
	
	public Pesos total() {
		Pesos total = Pesos.newFor(0.0);
		for (BuyItem item : items.values()) {
			total = total.plus(item.getValue().by(item.getCount()));
		}
		return total;
	}
}

