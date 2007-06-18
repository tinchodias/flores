package model.receipt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.money.Pesos;
import model.stock.Article;



public class SellItems {

	Map<Article, SellItem> items = new HashMap<Article, SellItem>();
	
	public void add(Article article, Double count, Pesos sellValue, Pesos costValue) {
		items.put(article, new SellItem(count, sellValue, costValue));
	}
	
	public Collection<Article> getArticles() {
		return items.keySet();
	}
	
	public Double getCount(Article article) {
		return items.get(article).getCount();
	}

	public Pesos getSellValue(Article article) {
		return items.get(article).getSellValue();
	}
	
	public Pesos sellTotal() {
		Pesos total = Pesos.newFor(0.0);
		for (SellItem item : items.values()) {
			total = total.plus(item.getSellValue().by(item.getCount()));
		}
		return total;
	}

	public Pesos costTotal() {
		Pesos total = Pesos.newFor(0.0);
		for (SellItem item : items.values()) {
			total = total.plus(item.getCostValue().by(item.getCount()));
		}
		return total;
	}
}

