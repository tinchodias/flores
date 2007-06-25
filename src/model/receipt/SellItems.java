package model.receipt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.money.Pesos;
import model.stock.Article;



public class SellItems {

	Map<Article, SellItem> items = new HashMap<Article, SellItem>();
	
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

	public Object get(int index) {
		return items.values().toArray()[index];
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
		
		for (SellItem item : items.values()) {
			Pesos adjustedValue = item.getSellValue().by(adjustCoefficient);
			item.setSellValue(adjustedValue);
		}
	}

}

