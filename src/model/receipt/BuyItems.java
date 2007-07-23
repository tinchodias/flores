package model.receipt;

import java.util.Collection;
import java.util.Map;

import model.money.Pesos;
import model.stock.Article;
import model.util.CollectionFactory;

public class BuyItems {

	Map<Article, BuyItem> items = CollectionFactory.newMap();
	
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
	
	public Double getPriceMargin(Article article) {
		return items.get(article).getPriceMargin();
	}

	public Pesos total() {
		Pesos total = Pesos.newFor(0.0);
		for (Article article : items.keySet()) {
			BuyItem item = items.get(article);
			total = total.plus(item.getValue().by(item.getCount()));
		}
		return total;
	}

	public void adjustTotal(Pesos adjustedTotal) {
		Pesos adjustCoefficient = adjustedTotal.dividedBy(total());
		
		for (Article article : items.keySet()) {
			BuyItem item = items.get(article);
			Pesos adjustedValue = item.getValue().by(adjustCoefficient);
			item.setValue(adjustedValue);
		}
	}

	public Object get(int index) {
		Article article = (Article) items.keySet().toArray()[index];
		return items.get(article);
	}

	public boolean remove(Object object) {
		BuyItem buyItem = (BuyItem) object;
		return items.remove(buyItem.getArticle()) != null;
	}

	public int size() {
		return items.size();
	}

}

