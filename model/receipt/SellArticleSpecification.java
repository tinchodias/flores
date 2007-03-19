package model.receipt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.money.Pesos;
import model.stock.Article;



public class SellArticleSpecification {

	Map<Article, SellArticleSpecificationItem> specifications = new HashMap<Article, SellArticleSpecificationItem>();
	
	public void add(Article article, Double count, Pesos sellValue, Pesos costValue) {
		specifications.put(article, new SellArticleSpecificationItem(count, sellValue, costValue));
	}
	
	public Collection<Article> getArticles() {
		return specifications.keySet();
	}
	
	public Double getCount(Article article) {
		return specifications.get(article).getCount();
	}

	public Pesos getSellValue(Article article) {
		return specifications.get(article).getSellValue();
	}
	
	public Pesos sellTotal() {
		Pesos total = Pesos.newFor(0.0);
		for (SellArticleSpecificationItem item : specifications.values()) {
			total = total.plus(item.getSellValue().by(item.getCount()));
		}
		return total;
	}

	public Pesos costTotal() {
		Pesos total = Pesos.newFor(0.0);
		for (SellArticleSpecificationItem item : specifications.values()) {
			total = total.plus(item.getCostValue().by(item.getCount()));
		}
		return total;
	}
}

