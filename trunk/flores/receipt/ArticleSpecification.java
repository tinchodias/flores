package model.receipt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Article;
import model.money.Pesos;



public class ArticleSpecification {

	Map<Article, ArticleSpecificationItem> specifications = new HashMap();
	
	public void add(Article article, Double count, Pesos pesos) {
		specifications.put(article, new ArticleSpecificationItem(count, pesos));
	}
	
	public Collection<Article> getArticles() {
		return specifications.keySet();
	}
	
	public Double getCount(Article article) {
		return specifications.get(article).getCount();
	}

	public Pesos getPesos(Article article) {
		return specifications.get(article).getPesos();
	}
}

