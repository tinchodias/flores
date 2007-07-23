package model.receipt;

import java.util.Collection;
import java.util.Map;

import model.money.Pesos;
import model.stock.Article;
import model.util.CollectionFactory;

public class SellItems {

	Map<Article, SellItem> items = CollectionFactory.newMap();
	
	public void add(Article article, Double count, Pesos sellValue, Pesos costValue) {
		items.put(article, new SellItem(article, count, sellValue, costValue));
	}
	
	public void add(SellItem item) {
		items.put(item.getArticle(), item);
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
		for (Article article : items.keySet()) {
			SellItem item = items.get(article);
			total = total.plus(item.getSellValue().by(item.getCount()));
		}
		return total;
	}

	public Pesos costTotal() {
		Pesos total = Pesos.newFor(0.0);
		for (Article article : items.keySet()) {
			SellItem item = items.get(article);
			total = total.plus(item.getCostValue().by(item.getCount()));
		}
		return total;
	}

	public Object get(int index) {
		Article article = (Article) items.keySet().toArray()[index];
		return items.get(article);
	}

	public boolean remove(Object object) {
		SellItem sellItem = (SellItem) object;
		return items.remove(sellItem.getArticle()) != null;
	}

	public int size() {
		return items.size();
	}

	public void adjustTotal(Pesos adjustedTotal) {
		Pesos adjustCoefficient = adjustedTotal.dividedBy(sellTotal());
		
		for (Article article : items.keySet()) {
			SellItem item = items.get(article);
			Pesos adjustedValue = item.getSellValue().by(adjustCoefficient);
			item.setSellValue(adjustedValue);
		}
	}

}

