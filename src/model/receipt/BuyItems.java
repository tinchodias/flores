package model.receipt;

import java.util.Collection;
import java.util.LinkedHashMap;

import model.money.Pesos;
import model.stock.Article;



public class BuyItems {

	LinkedHashMap<Article, BuyItem> items = new LinkedHashMap<Article, BuyItem>();
	
	public void add(Article article, Double count, Pesos value) {
		items.put(article, new BuyItem(article, count, value));
	}
	
	public void add(BuyItem item) {
		items.put(item.getArticle(), item);
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

	public Object get(int index) {
		return items.values().toArray()[index];
	}

	public boolean remove(Object object) {
		BuyItem buyItem = (BuyItem) object;
		return items.remove(buyItem.getArticle()) != null;
	}

	public int size() {
		return items.size();
	}

	public void adjustTotal(Pesos adjustedTotal) {
		Pesos adjustCoefficient = adjustedTotal.dividedBy(total());
		
		for (BuyItem item : items.values()) {
			Pesos adjustedValue = item.getValue().by(adjustCoefficient);
			item.setValue(adjustedValue);
		}
	}

}

