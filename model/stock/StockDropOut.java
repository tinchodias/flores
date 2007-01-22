package model.stock;

import java.util.Date;

public class StockDropOut {

	private final Article article;
	private final double count;
	private final Date date;

	public StockDropOut(Article article, double count, Date date) {
		this.article = article;
		this.count = count;
		this.date = date;
	}

	public Article getArticle() {
		return article;
	}

	public double getCount() {
		return count;
	}

	public Date getDate() {
		return date;
	}

}
